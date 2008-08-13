/*
 * Copyright 2008 The Kuali Foundation.
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
package org.kuali.kfs.module.purap.document.web.struts;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.core.question.ConfirmationQuestion;
import org.kuali.core.service.BusinessObjectService;
import org.kuali.core.service.DataDictionaryService;
import org.kuali.core.service.PersistenceService;
import org.kuali.core.util.ObjectUtils;
import org.kuali.core.web.struts.action.KualiTransactionalDocumentActionBase;
import org.kuali.core.web.struts.form.KualiDocumentFormBase;
import org.kuali.kfs.module.purap.PurapConstants;
import org.kuali.kfs.module.purap.PurapPropertyConstants;
import org.kuali.kfs.module.purap.businessobject.BillingAddress;
import org.kuali.kfs.module.purap.document.BulkReceivingDocument;
import org.kuali.kfs.module.purap.document.PurchaseOrderDocument;
import org.kuali.kfs.module.purap.document.PurchasingDocument;
import org.kuali.kfs.module.purap.document.service.BulkReceivingService;
import org.kuali.kfs.module.purap.document.service.PurchaseOrderService;
import org.kuali.kfs.sys.KFSConstants;
import org.kuali.kfs.sys.KFSPropertyConstants;
import org.kuali.kfs.sys.context.SpringContext;
import org.kuali.kfs.vnd.VendorConstants;
import org.kuali.kfs.vnd.businessobject.VendorAddress;
import org.kuali.kfs.vnd.businessobject.VendorContract;
import org.kuali.kfs.vnd.document.service.VendorService;
import org.kuali.kfs.vnd.service.PhoneNumberService;

import edu.iu.uis.eden.exception.WorkflowException;

public class BulkReceivingAction extends KualiTransactionalDocumentActionBase {

    private static final Logger LOG = Logger.getLogger(BulkReceivingAction.class);
    
    protected void createDocument(KualiDocumentFormBase kualiDocumentFormBase) throws WorkflowException {       
        
        super.createDocument(kualiDocumentFormBase);

        BulkReceivingForm blkForm = (BulkReceivingForm)kualiDocumentFormBase;
        BulkReceivingDocument blkRecDoc = (BulkReceivingDocument)blkForm.getDocument();
        
        blkRecDoc.setPurchaseOrderIdentifier( blkForm.getPurchaseOrderId() );
        
        blkRecDoc.initiateDocument();
        
    }

    public ActionForward continueBulkReceiving(ActionMapping mapping, 
                                               ActionForm form, 
                                               HttpServletRequest request, 
                                               HttpServletResponse response) 
    throws Exception {
    
        BulkReceivingForm blkForm = (BulkReceivingForm)form;
        BulkReceivingDocument blkRecDoc = (BulkReceivingDocument)blkForm.getDocument();
        
        //perform duplicate check
        ActionForward forward = isDuplicateDocumentEntry(mapping, form, request, response, blkRecDoc);
        if( forward != null ){
            return forward;
        }
        
        //populate and save bulk Receiving Document from Purchase Order        
        SpringContext.getBean(BulkReceivingService.class).populateAndSaveBulkReceivingDocument(blkRecDoc);
        
        return mapping.findForward(KFSConstants.MAPPING_BASIC);
    }
    
    public ActionForward clearInitFields(ActionMapping mapping, 
                                         ActionForm form, 
                                         HttpServletRequest request, 
                                         HttpServletResponse response) 
    throws Exception {
        
        BulkReceivingForm blkRecForm = (BulkReceivingForm) form;
        BulkReceivingDocument blkRecDoc = (BulkReceivingDocument) blkRecForm.getDocument();
        blkRecDoc.clearInitFields();

        return mapping.findForward(KFSConstants.MAPPING_BASIC);
        
    }

    public ActionForward refreshDeliveryBuilding(ActionMapping mapping, 
                                                 ActionForm form, 
                                                 HttpServletRequest request, 
                                                 HttpServletResponse response) 
    throws Exception {
    
        BulkReceivingForm baseForm = (BulkReceivingForm) form;
        BulkReceivingDocument document = (BulkReceivingDocument) baseForm.getDocument();
        
        if (ObjectUtils.isNotNull(document.isDeliveryBuildingOther())) {
            if (document.isDeliveryBuildingOther()) {
                document.setDeliveryBuildingName(PurapConstants.DELIVERY_BUILDING_OTHER);
                document.setDeliveryBuildingCode(PurapConstants.DELIVERY_BUILDING_OTHER_CODE);
                document.setDeliveryBuildingLine1Address(null);
                document.setDeliveryBuildingLine2Address(null);
                document.setDeliveryBuildingRoomNumber(null);
                document.setDeliveryCityName(null);
                document.setDeliveryStateCode(null);
                document.setDeliveryCountryCode(null);
                document.setDeliveryPostalCode(null);
            } else {
                document.setDeliveryBuildingName(null);
                document.setDeliveryBuildingCode(null);
                document.setDeliveryBuildingLine1Address(null);
                document.setDeliveryBuildingLine2Address(null);
                document.setDeliveryBuildingRoomNumber(null);
                document.setDeliveryCityName(null);
                document.setDeliveryStateCode(null);
                document.setDeliveryCountryCode(null);
                document.setDeliveryPostalCode(null);
            }
        }
        
        return refresh(mapping, form, request, response);
    }
    
    private ActionForward isDuplicateDocumentEntry(ActionMapping mapping, 
                                                   ActionForm form, 
                                                   HttpServletRequest request, 
                                                   HttpServletResponse response, 
                                                   BulkReceivingDocument bulkReceivingDocument) 
    throws Exception {
        
        ActionForward forward = null;
        HashMap<String, String> duplicateMessages = SpringContext.getBean(BulkReceivingService.class).bulkReceivingDuplicateMessages(bulkReceivingDocument);
        
        if (duplicateMessages != null && 
            !duplicateMessages.isEmpty()) {
            Object question = request.getParameter(KFSConstants.QUESTION_INST_ATTRIBUTE_NAME);
            if (question == null) {

                return this.performQuestionWithoutInput(mapping, 
                                                        form, 
                                                        request, 
                                                        response, 
                                                        PurapConstants.BulkReceivingDocumentStrings.DUPLICATE_BULK_RECEIVING_DOCUMENT_QUESTION,
                                                        duplicateMessages.get(PurapConstants.BulkReceivingDocumentStrings.DUPLICATE_BULK_RECEIVING_DOCUMENT_QUESTION), 
                                                        KFSConstants.CONFIRMATION_QUESTION, KFSConstants.ROUTE_METHOD, "");
            }

            Object buttonClicked = request.getParameter(KFSConstants.QUESTION_CLICKED_BUTTON);
            if ((PurapConstants.BulkReceivingDocumentStrings.DUPLICATE_BULK_RECEIVING_DOCUMENT_QUESTION.equals(question)) && ConfirmationQuestion.NO.equals(buttonClicked)) {                
                forward = mapping.findForward(KFSConstants.MAPPING_BASIC);
            }
        }

        return forward;
    }
    
    public ActionForward printReceivingTicket(ActionMapping mapping, 
                                              ActionForm form, 
                                              HttpServletRequest request, 
                                              HttpServletResponse response) 
    throws Exception {
        
        String blkDocId = request.getParameter("docId");
        ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
        
        try {
            // will throw validation exception if errors occur
            SpringContext.getBean(BulkReceivingService.class).performPrintReceivingTicketPDF(blkDocId, baosPDF);

            response.setHeader("Cache-Control", "max-age=30");
            response.setContentType("application/pdf");
            StringBuffer sbContentDispValue = new StringBuffer();
            String useJavascript = request.getParameter("useJavascript");
            if (useJavascript == null || useJavascript.equalsIgnoreCase("false")) {
                sbContentDispValue.append("attachment");
            }
            else {
                sbContentDispValue.append("inline");
            }
            StringBuffer sbFilename = new StringBuffer();
            sbFilename.append("PURAP_RECEIVING_TICKET_");
            sbFilename.append(blkDocId);
            sbFilename.append("_");
            sbFilename.append(System.currentTimeMillis());
            sbFilename.append(".pdf");
            sbContentDispValue.append("; filename=");
            sbContentDispValue.append(sbFilename);

            response.setHeader("Content-disposition", sbContentDispValue.toString());

            response.setContentLength(baosPDF.size());

            ServletOutputStream sos = response.getOutputStream();
            baosPDF.writeTo(sos);
            sos.flush();

        }finally {
            if (baosPDF != null) {
                baosPDF.reset();
            }
        }

        return null;
    }
    
    public ActionForward printReceivingTicketPDF(ActionMapping mapping, 
                                                 ActionForm form, 
                                                 HttpServletRequest request, 
                                                 HttpServletResponse response) 
    throws Exception {
        
        BulkReceivingForm blkRecForm = (BulkReceivingForm) form;
        BulkReceivingDocument blkRecDoc = (BulkReceivingDocument) blkRecForm.getDocument();
        
        String basePath = getBasePath(request);
        String docId = blkRecDoc.getDocumentNumber();
        String methodToCallPrintPurchaseOrderPDF = "printReceivingTicket";
        String methodToCallDocHandler = "docHandler";
        String printReceivingTicketPDFUrl = getUrlForPrintReceivingTicket(basePath, docId, methodToCallPrintPurchaseOrderPDF);
        String displayReceivingDocTabbedPageUrl = getUrlForPrintReceivingTicket(basePath, docId, methodToCallDocHandler);
        request.setAttribute("printReceivingTicketPDFUrl", printReceivingTicketPDFUrl);
        request.setAttribute("displayReceivingDocTabbedPageUrl", displayReceivingDocTabbedPageUrl);
        String label = SpringContext.getBean(DataDictionaryService.class).getDocumentLabelByClass(BulkReceivingDocument.class);
        request.setAttribute("receivingDocLabel", label);

        return mapping.findForward("printReceivingTicketPDF");
    }
    
    private String getUrlForPrintReceivingTicket(String basePath, 
                                                 String docId, 
                                                 String methodToCall) {
        
        StringBuffer result = new StringBuffer(basePath);
        result.append("/purapBulkReceiving.do?methodToCall=");
        result.append(methodToCall);
        result.append("&docId=");
        result.append(docId);
        result.append("&command=displayDocSearchView");

        return result.toString();
    }
    
}    
