/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source: /opt/cvs/kfs/work/src/org/kuali/kfs/gl/batch/service/impl/PostReversal.java,v $
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
/*
 * Created on Oct 12, 2005
 *
 */
package org.kuali.module.gl.batch.poster.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kuali.module.gl.batch.poster.PostTransaction;
import org.kuali.module.gl.batch.poster.VerifyTransaction;
import org.kuali.module.gl.bo.Reversal;
import org.kuali.module.gl.bo.Transaction;
import org.kuali.module.gl.dao.ReversalDao;

/**
 * 
 * 
 */
public class PostReversal implements PostTransaction {
    private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PostReversal.class);

    private ReversalDao reversalDao;

    public void setReversalDao(ReversalDao red) {
        reversalDao = red;
    }

    public PostReversal() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.kuali.module.gl.batch.poster.PostTransaction#post(org.kuali.module.gl.bo.Transaction)
     */
    public String post(Transaction t, int mode, Date postDate) {
        LOG.debug("post() started");

        if (t.getFinancialDocumentReversalDate() == null) {
            // No need to post this
            return "";
        }

        Reversal re = new Reversal(t);

        // Make sure the row will be unique when adding to the reversal table by
        // adjusting the transaction sequence id
        int maxSequenceId = reversalDao.getMaxSequenceNumber(t);
        re.setTransactionLedgerEntrySequenceNumber(new Integer(maxSequenceId + 1));

        reversalDao.save(re);

        return "I";
    }

    public String getDestinationName() {
        return "GL_REVERSAL_T";
    }
}
