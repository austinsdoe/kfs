/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source: /opt/cvs/kfs/work/src/org/kuali/kfs/fp/businessobject/FunctionControlCode.java,v $
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

package org.kuali.module.financial.bo;

import java.util.LinkedHashMap;

import org.kuali.core.bo.BusinessObjectBase;

/**
 * 
 */
public class FunctionControlCode extends BusinessObjectBase {

    private String financialSystemFunctionControlCode;
    private boolean financialSystemFunctionDefaultIndicator;
    private String financialSystemFunctionDescription;

    /**
     * Default constructor.
     */
    public FunctionControlCode() {

    }

    /**
     * Gets the financialSystemFunctionControlCode attribute.
     * 
     * @return - Returns the financialSystemFunctionControlCode
     * 
     */
    public String getFinancialSystemFunctionControlCode() {
        return financialSystemFunctionControlCode;
    }

    /**
     * Sets the financialSystemFunctionControlCode attribute.
     * 
     * @param financialSystemFunctionControlCode The financialSystemFunctionControlCode to set.
     * 
     */
    public void setFinancialSystemFunctionControlCode(String financialSystemFunctionControlCode) {
        this.financialSystemFunctionControlCode = financialSystemFunctionControlCode;
    }


    /**
     * Gets the financialSystemFunctionDefaultIndicator attribute.
     * 
     * @return - Returns the financialSystemFunctionDefaultIndicator
     * 
     */
    public boolean isFinancialSystemFunctionDefaultIndicator() {
        return financialSystemFunctionDefaultIndicator;
    }


    /**
     * Sets the financialSystemFunctionDefaultIndicator attribute.
     * 
     * @param financialSystemFunctionDefaultIndicator The financialSystemFunctionDefaultIndicator to set.
     * 
     */
    public void setFinancialSystemFunctionDefaultIndicator(boolean financialSystemFunctionDefaultIndicator) {
        this.financialSystemFunctionDefaultIndicator = financialSystemFunctionDefaultIndicator;
    }


    /**
     * Gets the financialSystemFunctionDescription attribute.
     * 
     * @return - Returns the financialSystemFunctionDescription
     * 
     */
    public String getFinancialSystemFunctionDescription() {
        return financialSystemFunctionDescription;
    }

    /**
     * Sets the financialSystemFunctionDescription attribute.
     * 
     * @param financialSystemFunctionDescription The financialSystemFunctionDescription to set.
     * 
     */
    public void setFinancialSystemFunctionDescription(String financialSystemFunctionDescription) {
        this.financialSystemFunctionDescription = financialSystemFunctionDescription;
    }


    /**
     * @see org.kuali.core.bo.BusinessObjectBase#toStringMapper()
     */
    protected LinkedHashMap toStringMapper() {
        LinkedHashMap m = new LinkedHashMap();
        m.put("financialSystemFunctionControlCode", this.financialSystemFunctionControlCode);
        return m;
    }
}
