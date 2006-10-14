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
package org.kuali.module.gl.util;

import org.kuali.module.gl.bo.OriginEntry;

/**
 */

public class OriginEntryOffsetPair {
    private OriginEntry entry;
    private OriginEntry offset;
    private boolean fatalErrorFlag;

    /**
     * @return Returns the fatalErrorFlag.
     */
    public boolean isFatalErrorFlag() {
        return fatalErrorFlag;
    }

    /**
     * @param fatalErrorFlag The fatalErrorFlag to set.
     */
    public void setFatalErrorFlag(boolean fatalErrorFlag) {
        this.fatalErrorFlag = fatalErrorFlag;
    }

    /**
     * @return Returns the entry.
     */
    public OriginEntry getEntry() {
        return entry;
    }

    /**
     * @param entry The entry to set.
     */
    public void setEntry(OriginEntry entry) {
        this.entry = entry;
    }

    /**
     * @return Returns the offset.
     */
    public OriginEntry getOffset() {
        return offset;
    }

    /**
     * @param offset The offset to set.
     */
    public void setOffset(OriginEntry offset) {
        this.offset = offset;
    }


}
