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
package org.kuali.kfs.module.purap.document.validation.event;

import org.kuali.kfs.sys.KFSConstants;
import org.kuali.kfs.sys.document.validation.event.AttributedSaveDocumentEvent;
import org.kuali.rice.kns.document.Document;
import org.kuali.rice.kns.rule.event.SaveEvent;

/**
 * Continue Event for Accounts Payable Document.
 * This could be triggered when a user presses the continue button to go to the next page.
 */
public final class AttributedChangeSystemPurapEvent extends AttributedSaveDocumentEvent implements SaveEvent {

    /**
     * Overridden constructor.
     * 
     * @param document the document for this event
     */
    public AttributedChangeSystemPurapEvent(Document document) {
        this(KFSConstants.EMPTY_STRING, document);
    }

    /**
     * Constructs a ContinuePurapEvent with the given errorPathPrefix and document.
     * 
     * @param errorPathPrefix the error path
     * @param document document the event was invoked upon
     */
    public AttributedChangeSystemPurapEvent(String errorPathPrefix, Document document) {
        super("changing system for document " + getDocumentId(document), errorPathPrefix, document);
    }
}
