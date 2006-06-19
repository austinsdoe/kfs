/*
 * Copyright (c) 2004, 2005 The National Association of College and University Business Officers,
 * Cornell University, Trustees of Indiana University, Michigan State University Board of Trustees,
 * Trustees of San Joaquin Delta College, University of Hawai'i, The Arizona Board of Regents on
 * behalf of the University of Arizona, and the r*smart group.
 * 
 * Licensed under the Educational Community License Version 1.0 (the "License"); By obtaining,
 * using and/or copying this Original Work, you agree that you have read, understand, and will
 * comply with the terms and conditions of the Educational Community License.
 * 
 * You may obtain a copy of the License at:
 * 
 * http://kualiproject.org/license.html
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.kuali.module.gl.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kuali.module.gl.bo.OriginEntryGroup;
import org.kuali.module.gl.bo.Transaction;
import org.kuali.module.gl.service.impl.scrubber.DemergerReportData;
import org.kuali.module.gl.service.impl.scrubber.Message;
import org.kuali.module.gl.service.impl.scrubber.ScrubberReportData;

/**
 * @author Laran Evans <lc278@cornell.edu>
 * @version $Id$
 */

public interface ReportService {
    /**
     * Scrubber General Ledger Transaction Summary report
     * 
     * @param - runDate Run date of the report
     * @param - groups Groups to summarize for the report
     * @param - title Title of the report
     */
    public void generateScrubberLedgerSummaryReport(Date runDate, Collection groups, String title);

    /**
     * Scrubber Statistics report
     * 
     * @param - runDate Run date of the report
     * @param - scrubberReport Summary information
     * @param - scrubberReportErrors Map of transactions with errors or warnings
     */
    public void generateScrubberStatisticsReport(Date runDate, ScrubberReportData scrubberReport, Map<Transaction,List<Message>> scrubberReportErrors);

    /** 
     * Scrubber Demerger Statistics report
     * 
     * @param - runDate Run date of the report
     * @param - demergerReport Summary information
     */
    public void generateScrubberDemergerStatisticsReports(Date runDate, DemergerReportData demergerReport);

    /**
     * Scrubber Bad Balance listing report
     * 
     * @param - runDate Run date of the report
     * @param - groups Groups to summarize for the report
     */
    public void generateScrubberBadBalanceTypeListingReport(Date runDate, Collection groups);

    /**
     * Scrubber Removed Transactions report
     * 
     * @param - runDate Run date of the report
     * @param errorGroup Group with error transactions
     */
    public void generateScrubberRemovedTransactions(Date runDate,OriginEntryGroup errorGroup);


//    public void generateLedgerReport(Date runDate, Collection groupsToScrub, String title);
//    public void generateScrubberStatusReport(Date runDate, Collection groupsToScrub, ScrubberReportData scrubberReport);
//    public void generateDemergerStatusReport(Date runDate, DemergerReportData demergerReport);
//
//    public void generateIcrReports(Date runDate, List reportSummary, Map reportErrors, Map ledgerEntries);
//
//    public void generatePosterReports(Date runDate, List reportSummary, Map reportErrors, Map ledgerEntries, int mode);
//
//    /**
//     * @deprecated
//     */
//    public void generateScrubberReports(Date runDate, List reportSummary, Map<Transaction, List<Message>> reportErrors);   
//
//    public void generateYearEndEncumbranceForwardReports(Date runDate, List reportSummary, Map reportErrors, Map ledgerEntries);
//
//    public void generateYearEndBalanceForwardReports(Date runDate, List reportSummary, Map reportErrors, Map ledgerEntries);
//    
//    /**
//     * This method generates scrubber reports based on the given summary
//     * 
//     * @param runDate the execution time
//     * @param reportSummary the scrubber processing summary to be reported
//     * @param reportNamePrefix the prefix of report file name
//     */    
//    public void generateScrubberReports(Date runDate, List reportSummary, String reportNamePrefix);
//    
//    /**
//     * This method generates reports for the errors that occurs in the processing
//     * 
//     * @param runDate the execution time
//     * @param reportErrors the error messages to be reported
//     * @param reportNamePrefix the prefix of report file name
//     */
//    public void generateErrorReports(Date runDate, Map<Transaction, List<Message>> reportErrors, String reportNamePrefix);
//
//    /**
//     * This method generates ledger reports for the origin entries with the given group id
//     * 
//     * @param runDate the execution time
//     * @param originEntryGroupId the given group id of origin entries
//     * @param reportNamePrefix the prefix of report file name
//     */
//    public void generateLedgerReports(Date runDate,  Integer originEntryGroupId, String reportNamePrefix);
//
//    /**
//     * This method generates ledger reports for the origin entries whose group id are in the given group id list
//     * 
//     * @param runDate the execution time
//     * @param originEntryGroupIdList a list of origin entries group ids
//     * @param reportNamePrefix the prefix of report file name
//     */
//    public void generateLedgerReports(Date runDate, List originEntryGroupIdList, String reportNamePrefix);
}
