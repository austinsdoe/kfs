/*
 * Copyright 2007 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.module.budget.dao.jdbc;

import org.kuali.core.util.Guid;
import org.kuali.module.budget.dao.OrganizationSalarySettingSearchDao;

/**
 * This class...
 */
public class OrganizationSalarySettingSearchDaoJdbc extends BudgetConstructionDaoJdbcBase implements OrganizationSalarySettingSearchDao {

    private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( OrganizationSalarySettingSearchDaoJdbc.class );
    private static final int MAXLEVEL = 50;

    /**
     * @see org.kuali.module.budget.dao.OrganizationSalarySettingSearchDao#buildIntendedIncumbentSelect(java.lang.String, java.lang.Integer)
     */
    public void buildIntendedIncumbentSelect(String personUserIdentifier, Integer universityFiscalYear) {

        LOG.debug( "buildIntendedIncumbentSelect() started" );

        // This uses the GROUP BY clause to force a distinct set so as to not trip over the unique constraint on the target table.
        // For some reason the constraint is violated without the use of GROUP BY in Oracle
        getSimpleJdbcTemplate()
        .update(  "INSERT INTO ld_bcn_incumbent_sel_t "
                + " (PERSON_UNVL_ID, EMPLID, FIN_OBJECT_CD, PERSON_NM) "
                + "SELECT DISTINCT pull.person_unvl_id, bcaf.emplid, bcaf.fin_object_cd, iinc.person_nm "
                + "FROM ld_bcn_pullup_t pull, ld_bcn_acct_org_hier_t hier, ld_pndbc_apptfnd_t bcaf, ld_bcn_intincbnt_t iinc "
                + "WHERE pull.pull_flag > 0 "
                + "  AND pull.person_unvl_id = ? "
                + "  AND hier.univ_fiscal_yr = ? "
                + "  AND hier.org_fin_coa_cd = pull.fin_coa_cd "
                + "  AND hier.org_cd = pull.org_cd "
                + "  AND bcaf.univ_fiscal_yr = hier.univ_fiscal_yr "
                + "  AND bcaf.fin_coa_cd = hier.fin_coa_cd "
                + "  AND bcaf.account_nbr = hier.account_nbr "
                + "  AND bcaf.emplid NOT IN ('VACANT') "
                + "  AND iinc.emplid = bcaf.emplid "
                + "GROUP BY pull.person_unvl_id, bcaf.emplid, bcaf.fin_object_cd, iinc.person_nm", personUserIdentifier, universityFiscalYear);
    }

    /**
     * @see org.kuali.module.budget.dao.OrganizationSalarySettingSearchDao#cleanIntendedIncumbentSelect(java.lang.String)
     */
    public void cleanIntendedIncumbentSelect(String personUserIdentifier) {

        clearTempTableByUnvlId("ld_bcn_incumbent_sel_t", "PERSON_UNVL_ID", personUserIdentifier);
    }

    /**
     * @see org.kuali.module.budget.dao.OrganizationSalarySettingSearchDao#buildPositionSelect(java.lang.String, java.lang.Integer)
     */
    public void buildPositionSelect(String personUserIdentifier, Integer universityFiscalYear) {

        LOG.debug( "buildPositionSelect() started" );
        
        String sessionId = new Guid().toString();
        initSelectedPositionOrgs(sessionId, personUserIdentifier);

        populatePositionSelectForSubTree(sessionId, personUserIdentifier, universityFiscalYear);

        clearTempTableBySesId("ld_bcn_build_pos_sel01_mt", "SESID", sessionId);
    }
    
    private void initSelectedPositionOrgs(String sessionId, String personUserIdentifier){
        
        int currentLevel = 0;
        
        int rowsAffected = getSimpleJdbcTemplate()
        .update(  "INSERT INTO ld_bcn_build_pos_sel01_mt "
                + " (SESID, FIN_COA_CD, ORG_CD, ORG_LEVEL_CD) "
                + "SELECT ?, p.fin_coa_cd, p.org_cd,  ? "
                + "FROM ld_bcn_pullup_t p "
                + "WHERE p.pull_flag > 0 "
                + "  AND p.person_unvl_id = ? ", sessionId, currentLevel, personUserIdentifier);
        
        if (rowsAffected > 0){
            populateSelectedPositionOrgsSubTree(currentLevel, sessionId);
        }
    }
    
    private void populateSelectedPositionOrgsSubTree(int previousLevel, String sessionId){
        
        if (previousLevel <= MAXLEVEL){
            int currentLevel = previousLevel + 1;
            
            int rowsAffected = getSimpleJdbcTemplate()
            .update(  "INSERT INTO ld_bcn_build_pos_sel01_mt "
                    + " (SESID, FIN_COA_CD, ORG_CD, ORG_LEVEL_CD) "
                    + "SELECT ?, r.fin_coa_cd, r.org_cd, ? "
                    + "FROM ld_bcn_org_rpts_t r, ld_bcn_build_pos_sel01_mt a "
                    + "WHERE a.sesid = ? "
                    + "  AND a.org_level_cd = ? "
                    + "  AND a.fin_coa_cd = r.rpts_to_fin_coa_cd "
                    + "  AND a.org_cd = r.rpts_to_org_cd "
                    + "  AND not (r.fin_coa_cd = r.rpts_to_fin_coa_cd and r.org_cd = r.rpts_to_org_cd) ", sessionId, currentLevel, sessionId, previousLevel);

            if (rowsAffected > 0){
                populateSelectedPositionOrgsSubTree(currentLevel, sessionId);
            }
        } else {
            // overrun problem
            LOG.warn(String.format("\nWarning: One or more selected organizations have reporting organizations more than maxlevel of %d deep.",
                    MAXLEVEL));
        }
    }
    
    private void populatePositionSelectForSubTree(String sessionId, String personUserIdentifier, Integer universityFiscalYear){
        
        // insert actives that are funded with person or vacant
        getSimpleJdbcTemplate()
        .update(  "INSERT INTO ld_bcn_pos_sel_t "
                + " (PERSON_UNVL_ID, POSITION_NBR, UNIV_FISCAL_YR, EMPLID,  "
                + "  IU_POSITION_TYPE, POS_DEPTID, SETID_SALARY , SAL_ADMIN_PLAN, GRADE, POS_DESCR, PERSON_NM) "
                + "SELECT DISTINCT ?, p.position_nbr,p.univ_fiscal_yr, af.emplid, p.iu_position_type, "
                + "    p.pos_deptid, p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr, i.person_nm "
                + "FROM ld_bcn_build_pos_sel01_mt o, ld_bcn_pos_t p, "
                + "     ld_pndbc_apptfnd_t af LEFT OUTER JOIN ld_bcn_intincbnt_t i ON (af.emplid=i.emplid) "
                + "WHERE o.sesid = ? "
                + "  AND p.pos_deptid = CONCAT(o.fin_coa_cd, CONCAT('-', o.org_cd)) "
                + "  AND p.univ_fiscal_yr = ? "
                + "  AND p.pos_eff_status != 'I' "
                + "  AND p.univ_fiscal_yr = af.univ_fiscal_yr "
                + "  AND p.position_nbr = af.position_nbr "
                + "GROUP BY p.position_nbr, p.univ_fiscal_yr, af.emplid,p.iu_position_type, p.pos_deptid, "
                + "         p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr, i.person_nm ", personUserIdentifier, sessionId, universityFiscalYear);  

        // add actives that are unfunded
        getSimpleJdbcTemplate()
        .update(  "INSERT INTO ld_bcn_pos_sel_t "
                + " (PERSON_UNVL_ID, POSITION_NBR, UNIV_FISCAL_YR, EMPLID,  "
                + "  IU_POSITION_TYPE, POS_DEPTID, SETID_SALARY , SAL_ADMIN_PLAN, GRADE, POS_DESCR) "
                + "SELECT DISTINCT ?, p.position_nbr, p.univ_fiscal_yr, 'NOTFUNDED', p.iu_position_type, "
                + "    p.pos_deptid, p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr "
                + "FROM ld_bcn_build_pos_sel01_mt o, ld_bcn_pos_t p "
                + "WHERE o.sesid = ? "
                + "  AND p.pos_deptid = CONCAT(o.fin_coa_cd, CONCAT('-', o.org_cd)) "
                + "  AND p.univ_fiscal_yr = ? "
                + "  AND p.pos_eff_status != 'I' "
                + "  AND NOT EXISTS "
                + "      (SELECT * "
                + "       FROM ld_bcn_pos_sel_t ps "
                + "       WHERE ps.person_unvl_id = ? "
                + "         AND ps.position_nbr = p.position_nbr "
                + "         AND ps.univ_fiscal_yr = p.univ_fiscal_yr) "
                + "GROUP BY p.position_nbr, p.univ_fiscal_yr, p.iu_position_type, p.pos_deptid, "
                + "         p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr ", personUserIdentifier, sessionId, universityFiscalYear, personUserIdentifier);

        // insert inactives that are funded due to timing problem
        getSimpleJdbcTemplate()
        .update(  "INSERT INTO ld_bcn_pos_sel_t "
                + " (PERSON_UNVL_ID, POSITION_NBR, UNIV_FISCAL_YR, EMPLID,  "
                + "  IU_POSITION_TYPE, POS_DEPTID, SETID_SALARY , SAL_ADMIN_PLAN, GRADE, POS_DESCR, PERSON_NM) "
                + "SELECT DISTINCT ?, p.position_nbr, p.univ_fiscal_yr, af.emplid, p.iu_position_type, "
                + "    p.pos_deptid, p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr, 'INACTIVE POS.' "
                + "FROM ld_bcn_build_pos_sel01_mt o, ld_bcn_pos_t p, "
                + "     ld_pndbc_apptfnd_t af LEFT OUTER JOIN ld_bcn_intincbnt_t i ON (af.emplid=i.emplid) "
                + "WHERE o.sesid = ? "
                + "  AND p.pos_deptid = CONCAT(o.fin_coa_cd, CONCAT('-', o.org_cd)) "
                + "  AND p.univ_fiscal_yr = ? "
                + "  AND p.pos_eff_status = 'I' "
                + "  AND p.univ_fiscal_yr = af.univ_fiscal_yr "
                + "  AND p.position_nbr = af.position_nbr "
                + "GROUP BY p.position_nbr, p.univ_fiscal_yr, af.emplid,p.iu_position_type, p.pos_deptid, "
                + "         p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr ", personUserIdentifier, sessionId, universityFiscalYear);  

        // insert inactives that are unfunded
        getSimpleJdbcTemplate()
        .update(  "INSERT INTO ld_bcn_pos_sel_t "
                + " (PERSON_UNVL_ID, POSITION_NBR, UNIV_FISCAL_YR, EMPLID,  "
                + " IU_POSITION_TYPE, POS_DEPTID, SETID_SALARY , SAL_ADMIN_PLAN, GRADE, POS_DESCR, PERSON_NM) "
                + "SELECT DISTINCT ?, p.position_nbr, p.univ_fiscal_yr, 'NOTFUNDED', p.iu_position_type, "
                + "    p.pos_deptid, p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr, 'INACTIVE POS.' "
                + "FROM ld_bcn_build_pos_sel01_mt o, ld_bcn_pos_t p "
                + "WHERE o.sesid = ? "
                + "  AND p.pos_deptid = CONCAT(o.fin_coa_cd, CONCAT('-', o.org_cd)) "
                + "  AND p.univ_fiscal_yr = ? "
                + "  AND p.pos_eff_status = 'I' "
                + "  AND NOT EXISTS "
                + "      (SELECT * "
                + "       FROM ld_bcn_pos_sel_t ps "
                + "       WHERE ps.person_unvl_id = ? "
                + "         AND ps.position_nbr = p.position_nbr "
                + "         AND ps.univ_fiscal_yr = p.univ_fiscal_yr) "
                + "GROUP BY p.position_nbr, p.univ_fiscal_yr, p.iu_position_type, p.pos_deptid, "
                + "         p.setid_salary, p.pos_sal_plan_dflt, p.pos_grade_dflt, p.pos_descr ", personUserIdentifier, sessionId, universityFiscalYear, personUserIdentifier);
        
        // set name field for vacants
        getSimpleJdbcTemplate()
        .update(  "UPDATE ld_bcn_pos_sel_t p "
                + "SET person_nm = 'VACANT' "
                + "WHERE p.person_unvl_id = ? "
                + "  AND p.emplid = 'VACANT' "
                + "  AND p.person_nm IS NULL ", personUserIdentifier);
        
        // reset name field for positions that only have deleted funding associated
        // note that this overwrites any actual names except for Inactives
        getSimpleJdbcTemplate()
        .update(  "UPDATE ld_bcn_pos_sel_t p "
                + "SET p.person_nm = 'NOT FUNDED' "
                + "WHERE p.person_unvl_id = ? "
                + "  AND p.person_nm != 'INACTIVE POS.' "
                + "  AND NOT EXISTS "
                + "    (SELECT * "
                + "    FROM ld_pndbc_apptfnd_t af "
                + "    WHERE af.univ_fiscal_yr = p.univ_fiscal_yr "
                + "      AND af.position_nbr = p.position_nbr "
                + "      AND af.appt_fnd_dlt_cd = 'N') ", personUserIdentifier);
        
        // anything leftover is not funded
        getSimpleJdbcTemplate()
        .update(  "UPDATE ld_bcn_pos_sel_t p "
                + "SET person_nm = 'NOT FUNDED' "
                + "WHERE p.person_unvl_id = ? "
                + "    AND p.person_nm IS NULL ", personUserIdentifier);
        
    }

    /**
     * @see org.kuali.module.budget.dao.OrganizationSalarySettingSearchDao#cleanPositionSelect(java.lang.String)
     */
    public void cleanPositionSelect(String personUserIdentifier) {
        
        clearTempTableByUnvlId("ld_bcn_pos_sel_t", "PERSON_UNVL_ID", personUserIdentifier);
    }

}
