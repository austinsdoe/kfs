/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source$
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
package org.kuali.module.gl.web.optionfinder;

import java.util.ArrayList;
import java.util.List;

import org.kuali.core.bo.user.Options;
import org.kuali.core.lookup.keyvalues.KeyValuesBase;
import org.kuali.core.lookup.valueFinder.ValueFinder;
import org.kuali.core.service.OptionsService;
import org.kuali.core.util.SpringServiceLocator;
import org.kuali.core.web.uidraw.KeyLabelPair;

/**
 * This class...
 * 
 * 
 */
public class GLEncumbranceBalanceTypeOptionFinder extends KeyValuesBase implements ValueFinder {

    /**
     * @see org.kuali.core.lookup.valueFinder.ValueFinder#getValue()
     */
    public String getValue() {
        OptionsService os = SpringServiceLocator.getOptionsService();
        Options o = os.getCurrentYearOptions();

        return o.getExtrnlEncumFinBalanceTypCd();
    }

    /**
     * @see org.kuali.core.lookup.keyvalues.KeyValuesFinder#getKeyValues()
     */
    public List getKeyValues() {
        List labels = new ArrayList();

        OptionsService os = SpringServiceLocator.getOptionsService();
        Options o = os.getCurrentYearOptions();

        labels.add(new KeyLabelPair(o.getExtrnlEncumFinBalanceTypCd(), o.getExtrnlEncumFinBalanceTypCd() + " - " + o.getExtrnlEncumFinBalanceTyp().getFinancialBalanceTypeName()));
        labels.add(new KeyLabelPair(o.getIntrnlEncumFinBalanceTypCd(), o.getIntrnlEncumFinBalanceTypCd() + " - " + o.getIntrnlEncumFinBalanceTyp().getFinancialBalanceTypeName()));
        labels.add(new KeyLabelPair(o.getPreencumbranceFinBalTypeCd(), o.getPreencumbranceFinBalTypeCd() + " - " + o.getPreencumbranceFinBalType().getFinancialBalanceTypeName()));

        return labels;
    }
}
