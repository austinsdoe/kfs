/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source: /opt/cvs/kfs/work/src/org/kuali/kfs/gl/Constant.java,v $
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
package org.kuali.module.gl.web;


/**
 * This class contains the constants being used by balance inquiry screens of general ledger
 * 
 * 
 */
public final class Constant {
    public static final String EMPTY_STRING = "";

    public static final String PENDING_ENTRY_OPTION = "dummyBusinessObject.pendingEntryOption";
    public static final String APPROVED_PENDING_ENTRY = "Approved";
    public static final String ALL_PENDING_ENTRY = "All";
    public static final String NO_PENDING_ENTRY = "No";

    public static final String CONSOLIDATION_OPTION = "dummyBusinessObject.consolidationOption";
    public static final String CONSOLIDATION = "Consolidation";
    public static final String DETAIL = "Detail";

    public static final String AMOUNT_VIEW_OPTION = "dummyBusinessObject.amountViewOption";
    public static final String MONTHLY = "Monthly";
    public static final String ACCUMULATE = "Accumulate";

    public static final String COST_SHARE_OPTION = "dummyBusinessObject.costShareOption";
    public static final String COST_SHARE_EXCLUDE = "Exclude";
    public static final String COST_SHARE_INCLUDE = "Include";
    public static final String COST_SHARE_VALUE = "CS";

    public static final String SUB_ACCOUNT_OPTION = "subAccountNumber";

    public static final String DOCUMENT_APPROVED_CODE_APPROVED = "A";
    public static final String DOCUMENT_APPROVED_CODE_PENDING = "N";
    public static final String DOCUMENT_APPROVED_CODE_PROCESSED = "X";

    public static final String BALANCE_TYPE_PE = "PE";
    public static final String BALANCE_TYPE_CB = "CB";

    public static final String CONSOLIDATED_SUB_ACCOUNT_NUMBER = "*ALL*";
    public static final String CONSOLIDATED_SUB_OBJECT_CODE = "*ALL*";
    public static final String CONSOLIDATED_OBJECT_TYPE_CODE = "*ALL*";

    public static final String GL_LOOKUPABLE_ACCOUNT_BALANCE = "glAccountBalanceLookupable";
    public static final String GL_LOOKUPABLE_ACCOUNT_BALANCE_BY_CONSOLIDATION = "glAccountBalanceByConsolidationLookupable";
    public static final String GL_LOOKUPABLE_ACCOUNT_BALANCE_BY_LEVEL = "glAccountBalanceByLevelLookupable";
    public static final String GL_LOOKUPABLE_ACCOUNT_BALANCE_BY_OBJECT = "glAccountBalanceByObjectLookupable";
    public static final String GL_LOOKUPABLE_BALANCE = "glBalanceLookupable";
    public static final String GL_LOOKUPABLE_CASH_BALANCE = "glCashBalanceLookupable";
    public static final String GL_LOOKUPABLE_ENCUMBRANCE = "glEncumbranceLookupable";
    public static final String GL_LOOKUPABLE_ENTRY = "glEntryLookupable";
    public static final String GL_LOOKUPABLE_PENDING_ENTRY = "glPendingEntryLookupable";
    public static final String GL_LOOKUPABLE_ACCOUNT_BALANCE_PENDING_ENTRY = "glAccountBalancePendingEntryLookupable";

    public static final String RETURN_LOCATION_VALUE = "portal.do";
    public static final String START_CHAR_OF_REPORTING_SORT_CODE_B = "B";
    public static final String LOOKUP_BUTTON_VALUE = "Drill Down";

    public static final String TOTAL_ACCOUNT_BALANCE_INCOME = "Income";
    public static final String TOTAL_ACCOUNT_BALANCE_EXPENSE_GROSS = "Expense (Gross)";
    public static final String TOTAL_ACCOUNT_BALANCE_EXPENSE_IN = "Expense (Net Transfer In)";
    public static final String TOTAL_ACCOUNT_BALANCE_AVAILABLE = "Avaliable Balance";


}