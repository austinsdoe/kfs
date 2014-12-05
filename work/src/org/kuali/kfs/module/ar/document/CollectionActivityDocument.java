/*
 * The Kuali Financial System, a comprehensive financial management system for higher education.
 *
 * Copyright 2005-2014 The Kuali Foundation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kfs.module.ar.document;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.kuali.kfs.integration.cg.ContractsAndGrantsBillingAward;
import org.kuali.kfs.module.ar.ArConstants;
import org.kuali.kfs.module.ar.businessobject.CollectionEvent;
import org.kuali.kfs.module.ar.businessobject.Customer;
import org.kuali.kfs.module.ar.document.service.ContractsGrantsInvoiceDocumentService;
import org.kuali.kfs.sys.FinancialSystemModuleConfiguration;
import org.kuali.kfs.sys.context.SpringContext;
import org.kuali.kfs.sys.document.FinancialSystemTransactionalDocumentBase;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.kew.framework.postprocessor.DocumentRouteStatusChange;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.bo.ModuleConfiguration;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.KualiModuleService;
import org.kuali.rice.krad.util.ObjectUtils;

/**
 * Collection Activity Document class. This transactional document is used to store events related to customers.
 */
public class CollectionActivityDocument extends FinancialSystemTransactionalDocumentBase {

    protected static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CollectionActivityDocument.class);

    private Long proposalNumber;
    private String agencyNumber;
    private String agencyName;
    private String customerNumber;
    private String customerName;
    protected String selectedInvoiceDocumentNumber;
    protected String newInvoiceDocumentNumber;

    protected transient ContractsAndGrantsBillingAward award;
    protected transient Customer customer;
    protected CollectionEvent newCollectionEvent;
    protected CollectionEvent globalCollectionEvent;
    private String selectedInvoiceDocumentNumberList;

    private List<ContractsGrantsInvoiceDocument> invoices;
    private List<CollectionEvent> collectionEvents;

    /**
     * Default constructor for CollectionActivityDocument.
     */
    public CollectionActivityDocument() {
        super();
        globalCollectionEvent = new CollectionEvent();
        invoices = new ArrayList<ContractsGrantsInvoiceDocument>();
        collectionEvents = new ArrayList<CollectionEvent>();
    }

    /**
     * Gets the proposalNumber attribute.
     *
     * @return Returns the proposalNumber.
     */
    public Long getProposalNumber() {
        return proposalNumber;
    }

    /**
     * Sets the proposalNumber attribute.
     *
     * @param proposalNumber The proposalNumber to set.
     */
    public void setProposalNumber(Long proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    /**
     * Gets the agencyNumber attribute.
     *
     * @return Returns the agency number.
     */
    public String getAgencyNumber() {
        return agencyNumber;
    }

    /**
     * Sets the agencyNumber attribute.
     *
     * @param agencyNumber The agency number to set.
     */
    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    /**
     * Gets the agencyName attribute.
     *
     * @return Returns the agency name.
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * Sets the agencyName attribute.
     *
     * @param agencyName The agency name to set.
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * Gets the customerNumber attribute.
     *
     * @return Returns the customer number.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the customerNumber attribute.
     *
     * @param customerNumber The customer number to set.
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Gets the customerName attribute.
     *
     * @return Returns the customer name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customerName attribute.
     *
     * @param customerName The customerName attribute to set.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the customer attribute.
     *
     * @return Returns the customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer attribute.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the award attribute.
     *
     * @return Returns the award.
     */
    public ContractsAndGrantsBillingAward getAward() {
        return award;
    }

    /**
     * Sets the award attribute.
     *
     * @param award The award to set.
     */
    public void setAward(ContractsAndGrantsBillingAward award) {
        this.award = award;
    }

    /**
     * @return Returns true if document is in final state.
     */
    public boolean isFinal() {
        return isApproved();
    }

    /**
     *
     * @return Returns true if document is in Approved.
     */
    public boolean isApproved() {
        return getDocumentHeader().getWorkflowDocument().isApproved();
    }

    /**
     * Gets the invoices attribute.
     *
     * @return Returns the invoices.
     */
    public List<ContractsGrantsInvoiceDocument> getInvoices() {
        return invoices;
    }

    /**
     * Sets the invoices attribute.
     *
     * @param invoices The invoices to set.
     */
    public void setInvoices(List<ContractsGrantsInvoiceDocument> invoices) {
        this.invoices = invoices;
    }

    /**
     * Gets the collectionEvents attribute.
     *
     * @return Returns the collectionEvents.
     */
    public List<CollectionEvent> getCollectionEvents() {
        return collectionEvents;
    }

    /**
     * Sets the collectionEvents attribute.
     *
     * @param events The collectionEvents to set.
     */
    public void setCollectionEvents(List<CollectionEvent> collectionEvents) {
        this.collectionEvents = collectionEvents;
    }

    /**
     * Sets the events from invoices list of this class.
     */
    public void setEventsFromCGInvoices() {
        if (ObjectUtils.isNotNull(invoices) && !invoices.isEmpty()) {
            collectionEvents = new ArrayList<CollectionEvent>();
            for (ContractsGrantsInvoiceDocument invoice : invoices) {
                List<CollectionEvent> invoiceEvents = invoice.getCollectionEvents();
                if (ObjectUtils.isNotNull(invoiceEvents) && !invoiceEvents.isEmpty()) {
                    collectionEvents.addAll(invoiceEvents);
                }
            }
        }
    }

    /**
     * Gets the newCollectionEvent attribute.
     *
     * @return Returns the newCollectionEvent.
     */
    public CollectionEvent getNewCollectionEvent() {
        return newCollectionEvent;
    }

    /**
     * Sets the newCollectionEvent attribute.
     *
     * @param newCollectionEvent The newCollectionEvent to set.
     */
    public void setNewCollectionEvent(CollectionEvent newCollectionEvent) {
        this.newCollectionEvent = newCollectionEvent;
    }

    /**
     * Gets the selectedInvoiceDocumentNumber attribute.
     *
     * @return Returns the selectedInvoiceDocumentNumber.
     */
    public String getSelectedInvoiceDocumentNumber() {
        return selectedInvoiceDocumentNumber;
    }

    /**
     * Sets the selectedInvoiceDocumentNumber attribute.
     *
     * @param selectedInvoiceDocumentNumber The selectedInvoiceDocumentNumber to set.
     */
    public void setSelectedInvoiceDocumentNumber(String selectedInvoiceDocumentNumber) {
        this.selectedInvoiceDocumentNumber = selectedInvoiceDocumentNumber;
    }

    public String getNewInvoiceDocumentNumber() {
        return newInvoiceDocumentNumber;
    }

    public void setNewInvoiceDocumentNumber(String newInvoiceDocumentNumber) {
        this.newInvoiceDocumentNumber = newInvoiceDocumentNumber;
    }

    public CollectionEvent getGlobalCollectionEvent() {
        return globalCollectionEvent;
    }

    public void setGlobalCollectionEvent(CollectionEvent globalCollectionEvent) {
        this.globalCollectionEvent = globalCollectionEvent;
    }

    /**
     * @return Returns the selected invoice application.
     */
    public ContractsGrantsInvoiceDocument getSelectedInvoiceApplication() {
        String docNumber = getSelectedInvoiceDocumentNumber();
        if (ObjectUtils.isNotNull(docNumber)) {
            return getInvoiceApplicationsByDocumentNumber().get(docNumber);
        }
        else {
            List<ContractsGrantsInvoiceDocument> i = invoices;
            if (CollectionUtils.isEmpty(i)) {
                return null;
            }
            else {
                return invoices.get(0);
            }
        }
    }

    /**
     * Gets the map of invoices with documentNumber as key.
     *
     * @return Returns the map of invoices with documentNumber as key.
     */
    public Map<String, ContractsGrantsInvoiceDocument> getInvoiceApplicationsByDocumentNumber() {
        Map<String, ContractsGrantsInvoiceDocument> m = new HashMap<String, ContractsGrantsInvoiceDocument>();
        for (ContractsGrantsInvoiceDocument i : invoices) {
            m.put(i.getDocumentNumber(), i);
        }
        return m;
    }

    /**
     * Gets the events of selected invoice.
     *
     * @return Returns the events.
     */
    public List<CollectionEvent> getSelectedInvoiceEvents() {
        List<CollectionEvent> selectedEvents = new ArrayList<CollectionEvent>();
        for (CollectionEvent event : collectionEvents) {
            if (ObjectUtils.isNotNull(collectionEvents) && !collectionEvents.isEmpty()) {
                if (event.getInvoiceNumber().equals(getSelectedInvoiceDocumentNumber())) {
                    selectedEvents.add(event);
                }
            }
        }
        return selectedEvents;
    }

    /**
     * @see org.kuali.kfs.sys.document.FinancialSystemTransactionalDocumentBase#doRouteStatusChange(org.kuali.rice.kew.dto.DocumentRouteStatusChangeDTO)
     */

    @Override
    public void doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) {
        super.doRouteStatusChange(statusChangeEvent);
        if (getDocumentHeader().getWorkflowDocument().isFinal()) {
            BusinessObjectService boService = SpringContext.getBean(BusinessObjectService.class);
            this.setInvoiceListByProposalNumber(this.getProposalNumber());
            this.setEventsFromCGInvoices();
            if (ObjectUtils.isNotNull(collectionEvents) && !collectionEvents.isEmpty()) {
                for (CollectionEvent event : collectionEvents) {
                    if (ObjectUtils.isNull(event.getCollectionEventCode())) {
                        event.setCollectionEventCode(event.getInvoiceDocument().getNextCollectionEventCode());
                    }
                    boService.save(event);
                }
            }
        }
    }

    /**
     * Sets the invoices list for this class from given proposal number.
     *
     * @param proposalNumber The proposal number for which invoices list to be fetched.
     */
    public void setInvoiceListByProposalNumber(Long proposalNumber) {
        DateTimeService dateTimeService = SpringContext.getBean(DateTimeService.class);

        // To retrieve the batch file directory name as "reports/ar"
        ModuleConfiguration systemConfiguration = SpringContext.getBean(KualiModuleService.class).getModuleServiceByNamespaceCode(ArConstants.AR_NAMESPACE_CODE).getModuleConfiguration();

        // Set destination folder path
        String destinationFolderPath = StringUtils.EMPTY;
        List <String> batchDirectories = ((FinancialSystemModuleConfiguration) systemConfiguration).getBatchFileDirectories();
        if (CollectionUtils.isNotEmpty(batchDirectories)){
            destinationFolderPath = batchDirectories.get(0);
        }

        String runtimeStamp = dateTimeService.toDateTimeStringForFilename(new java.util.Date());

        String errOutputFile = destinationFolderPath + File.separator + ArConstants.BatchFileSystem.EVT_CREATION_CLN_ACT_ERROR_OUTPUT_FILE + "_" + runtimeStamp + ArConstants.BatchFileSystem.EXTENSION;
        ContractsGrantsInvoiceDocumentService contractsGrantsInvoiceDocumentService = SpringContext.getBean(ContractsGrantsInvoiceDocumentService.class);

        Collection<ContractsGrantsInvoiceDocument> cgInvoices = contractsGrantsInvoiceDocumentService.retrieveOpenAndFinalCGInvoicesByProposalNumber(proposalNumber);

        if (!CollectionUtils.isEmpty(cgInvoices)) {
            setInvoices(new ArrayList<ContractsGrantsInvoiceDocument>(cgInvoices));
        }
        else {
            LOG.error("There were no invoices retreived. Please refer to the log file " + ArConstants.BatchFileSystem.EVT_CREATION_CLN_ACT_ERROR_OUTPUT_FILE + ArConstants.BatchFileSystem.EXTENSION + " for more details.");
            this.setInvoices(new ArrayList<ContractsGrantsInvoiceDocument>());
        }
    }

    /**
     * @see org.kuali.rice.krad.bo.BusinessObjectBase#toStringMapper()
     */
    @SuppressWarnings("unchecked")
    protected LinkedHashMap toStringMapper_RICE20_REFACTORME() {
        LinkedHashMap m = new LinkedHashMap();
        m.put("documentNumber", this.documentNumber);
        return m;
    }

    public String getFinancialDocumentTypeCode() {
        return SpringContext.getBean(DataDictionaryService.class).getDocumentTypeNameByClass(this.getClass());
    }

    public String getSelectedInvoiceDocumentNumberList() {
        return selectedInvoiceDocumentNumberList;
    }

    public void setSelectedInvoiceDocumentNumberList(String selectedInvoiceDocumentNumberList) {
        this.selectedInvoiceDocumentNumberList = selectedInvoiceDocumentNumberList;
    }
}
