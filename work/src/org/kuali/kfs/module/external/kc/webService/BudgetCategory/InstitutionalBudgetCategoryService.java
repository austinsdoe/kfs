/*
 * Copyright 2011 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl2.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kfs.module.external.kc.webService.BudgetCategory;

import org.kuali.kfs.integration.kc.businessobject.BudgetCategoryDTO;
import org.kuali.kfs.integration.kc.dto.HashMapElement;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.10
 * Fri Jan 07 09:07:37 HST 2011
 * Generated source version: 2.2.10
 * 
 */
 
@WebService(targetNamespace = "KC", name = "budgetCategoryService")
public interface InstitutionalBudgetCategoryService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "lookupBudgetCategories", targetNamespace = "KC", className = "kc.LookupBudgetCategories")
    @WebMethod
    @ResponseWrapper(localName = "lookupBudgetCategoriesResponse", targetNamespace = "KC", className = "kc.LookupBudgetCategoriesResponse")
    public java.util.List<BudgetCategoryDTO> lookupBudgetCategories(
        @WebParam(name = "searchCriteria", targetNamespace = "")
        java.util.List<HashMapElement> searchCriteria
    );
}