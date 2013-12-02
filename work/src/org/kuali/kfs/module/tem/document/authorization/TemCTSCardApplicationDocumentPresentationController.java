/*
 * Copyright 2013 The Kuali Foundation.
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
package org.kuali.kfs.module.tem.document.authorization;

import org.kuali.kfs.sys.document.authorization.FinancialSystemTransactionalDocumentPresentationControllerBase;
import org.kuali.rice.krad.document.Document;

/**
 *
 */
public class TemCTSCardApplicationDocumentPresentationController extends FinancialSystemTransactionalDocumentPresentationControllerBase {

    @Override
    public boolean canSave(Document document) {
        if (document.getDocumentHeader().getWorkflowDocument().isEnroute()) {
            return false;
        }
        return super.canSave(document);
    }

    /**
     * Blanket approve is not allowed on CTS Card application documents
     * @see org.kuali.rice.krad.document.DocumentPresentationControllerBase#canBlanketApprove(org.kuali.rice.krad.document.Document)
     */
    @Override
    public boolean canBlanketApprove(Document document) {
        return false;
    }
}
