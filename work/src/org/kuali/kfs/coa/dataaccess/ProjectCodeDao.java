/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source: /opt/cvs/kfs/work/src/org/kuali/kfs/coa/dataaccess/ProjectCodeDao.java,v $
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
package org.kuali.module.chart.dao;

import org.kuali.module.chart.bo.ProjectCode;


/**
 * This interface defines basic methods that ProjectCode Dao's must provide
 * 
 * 
 */
public interface ProjectCodeDao {

    /**
     * @param projectCode - primary key
     * @return ProjectCode
     * 
     * Retrieves a ProjectCode object by primary key.
     */
    public ProjectCode getByPrimaryId(String projectCode);

    /**
     * @param name
     * @return ProjectCode
     * 
     * Retrieves a ProjectCode object by primary name.
     */
    public ProjectCode getByName(String name);

    /**
     * 
     * @param projectCode - a populated ProjectCode object to be saved
     */
    public void save(ProjectCode projectCode);
}
