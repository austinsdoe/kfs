/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source: /opt/cvs/kfs/work/src/org/kuali/kfs/fp/document/web/struts/IndirectCostAdjustmentForm.java,v $
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
package org.kuali.module.financial.web.struts.form;

import java.util.Map;

import org.kuali.PropertyConstants;
import org.kuali.core.bo.SourceAccountingLine;
import org.kuali.core.bo.TargetAccountingLine;
import org.kuali.core.document.TransactionalDocument;
import org.kuali.core.util.SpringServiceLocator;
import org.kuali.core.web.struts.form.KualiTransactionalDocumentFormBase;
import org.kuali.module.financial.document.IndirectCostAdjustmentDocument;
import org.kuali.module.financial.rules.IndirectCostAdjustmentDocumentRuleConstants;

/**
 * This class is the action form for Indirect Cost Adjustment Document
 * 
 * 
 */

public class IndirectCostAdjustmentForm extends KualiTransactionalDocumentFormBase {

    /**
     * Constructs a IndirectCostAdjustmentForm.java.
     */
    public IndirectCostAdjustmentForm() {
        super();
        setDocument(new IndirectCostAdjustmentDocument());
    }

    /**
     * @return Returns the Indirect Cost Adjustment Document
     */
    public IndirectCostAdjustmentDocument getIndirectCostAdjustmentDocument() {
        return (IndirectCostAdjustmentDocument) getDocument();
    }

    /**
     * @param indirectCostAdjustmentDocument the <code>IndirectCostAdjustmentDocument</code> to set
     */
    public void setIndirectCostAdjustmentDocument(IndirectCostAdjustmentDocument indirectCostAdjustmentDocument) {
        setDocument(indirectCostAdjustmentDocument);
    }

    /**
     * 
     * @see org.kuali.core.web.struts.form.KualiTransactionalDocumentFormBase#createNewSourceAccountingLine(org.kuali.core.document.TransactionalDocument)
     */
    @Override
    public SourceAccountingLine createNewSourceAccountingLine(TransactionalDocument transactionalDocument) {
        SourceAccountingLine sourceAccountingLine = super.createNewSourceAccountingLine(transactionalDocument);
        String objectCode = SpringServiceLocator.getKualiConfigurationService().getApplicationParameterValue(IndirectCostAdjustmentDocumentRuleConstants.INDIRECT_COST_ADJUSTMENT_DOCUMENT_SECURITY_GROUPING, IndirectCostAdjustmentDocumentRuleConstants.GRANT_OBJECT_CODE);

        sourceAccountingLine.setFinancialObjectCode(objectCode);
        return sourceAccountingLine;
    }

    /**
     * 
     * @see org.kuali.core.web.struts.form.KualiTransactionalDocumentFormBase#createNewTargetAccountingLine(org.kuali.core.document.TransactionalDocument)
     */
    @Override
    public TargetAccountingLine createNewTargetAccountingLine(TransactionalDocument transactionalDocument) {
        TargetAccountingLine targetAccountingLine = super.createNewTargetAccountingLine(transactionalDocument);
        String objectCode = SpringServiceLocator.getKualiConfigurationService().getApplicationParameterValue(IndirectCostAdjustmentDocumentRuleConstants.INDIRECT_COST_ADJUSTMENT_DOCUMENT_SECURITY_GROUPING, IndirectCostAdjustmentDocumentRuleConstants.RECEIPT_OBJECT_CODE);

        targetAccountingLine.setFinancialObjectCode(objectCode);
        return targetAccountingLine;
    }

    /**
     * @see org.kuali.core.web.struts.form.KualiTransactionalDocumentFormBase#getForcedReadOnlyFields()
     */
    @Override
    public Map getForcedReadOnlyFields() {
        Map map = super.getForcedReadOnlyFields();
        map.put(PropertyConstants.FINANCIAL_OBJECT_CODE, Boolean.TRUE);
        return map;
    }

}
