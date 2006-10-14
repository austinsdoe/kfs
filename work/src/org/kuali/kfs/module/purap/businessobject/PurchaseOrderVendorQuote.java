/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
 * $Source: /opt/cvs/kfs/work/src/org/kuali/kfs/module/purap/businessobject/PurchaseOrderVendorQuote.java,v $
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

package org.kuali.module.purap.bo;

import java.sql.Date;
import java.util.LinkedHashMap;

import org.kuali.core.bo.BusinessObjectBase;

/**
 * @author Kuali Nervous System Team (kualidev@oncourse.iu.edu)
 */
public class PurchaseOrderVendorQuote extends BusinessObjectBase {

	private Integer purchaseOrderVendorQuoteIdentifier;
	private Integer purchaseOrderIdentifier;
	private Integer vendorHeaderGeneratedIdentifier;
	private Integer vendorDetailAssignedIdentifier;
	private String vendorName;
	private String vendorLine1Address;
	private String vendorLine2Address;
	private String vendorCityName;
	private String vendorStateCode;
	private String vendorPostalCode;
	private String vendorPhoneNumber;
	private String vendorFaxNumber;
	private String vendorEmailAddress;
	private String vendorAttentionName;
	private String purchaseOrderQuoteTransactionTypeCode;
	private Date purchaseOrderQuoteTransactionDate;
	private Date purchaseOrderQuotePriceExpirationDate;
	private String purchaseOrderQuoteStatusCode;
	private Date purchaseOrderQuoteAwardDate;
	private String purchaseOrderQuoteRankNumber;
    private String vendorCountryCode;
    
    private PurchaseOrder purchaseOrder;
	private PurchaseOrderQuoteStatus purchaseOrderQuoteStatus;

	/**
	 * Default constructor.
	 */
	public PurchaseOrderVendorQuote() {

	}

	/**
	 * Gets the purchaseOrderVendorQuoteIdentifier attribute.
	 * 
	 * @return - Returns the purchaseOrderVendorQuoteIdentifier
	 * 
	 */
	public Integer getPurchaseOrderVendorQuoteIdentifier() { 
		return purchaseOrderVendorQuoteIdentifier;
	}

	/**
	 * Sets the purchaseOrderVendorQuoteIdentifier attribute.
	 * 
	 * @param - purchaseOrderVendorQuoteIdentifier The purchaseOrderVendorQuoteIdentifier to set.
	 * 
	 */
	public void setPurchaseOrderVendorQuoteIdentifier(Integer purchaseOrderVendorQuoteIdentifier) {
		this.purchaseOrderVendorQuoteIdentifier = purchaseOrderVendorQuoteIdentifier;
	}


	/**
	 * Gets the purchaseOrderIdentifier attribute.
	 * 
	 * @return - Returns the purchaseOrderIdentifier
	 * 
	 */
	public Integer getPurchaseOrderIdentifier() { 
		return purchaseOrderIdentifier;
	}

	/**
	 * Sets the purchaseOrderIdentifier attribute.
	 * 
	 * @param - purchaseOrderIdentifier The purchaseOrderIdentifier to set.
	 * 
	 */
	public void setPurchaseOrderIdentifier(Integer purchaseOrderIdentifier) {
		this.purchaseOrderIdentifier = purchaseOrderIdentifier;
	}


	/**
	 * Gets the vendorHeaderGeneratedIdentifier attribute.
	 * 
	 * @return - Returns the vendorHeaderGeneratedIdentifier
	 * 
	 */
	public Integer getVendorHeaderGeneratedIdentifier() { 
		return vendorHeaderGeneratedIdentifier;
	}

	/**
	 * Sets the vendorHeaderGeneratedIdentifier attribute.
	 * 
	 * @param - vendorHeaderGeneratedIdentifier The vendorHeaderGeneratedIdentifier to set.
	 * 
	 */
	public void setVendorHeaderGeneratedIdentifier(Integer vendorHeaderGeneratedIdentifier) {
		this.vendorHeaderGeneratedIdentifier = vendorHeaderGeneratedIdentifier;
	}


	/**
	 * Gets the vendorDetailAssignedIdentifier attribute.
	 * 
	 * @return - Returns the vendorDetailAssignedIdentifier
	 * 
	 */
	public Integer getVendorDetailAssignedIdentifier() { 
		return vendorDetailAssignedIdentifier;
	}

	/**
	 * Sets the vendorDetailAssignedIdentifier attribute.
	 * 
	 * @param - vendorDetailAssignedIdentifier The vendorDetailAssignedIdentifier to set.
	 * 
	 */
	public void setVendorDetailAssignedIdentifier(Integer vendorDetailAssignedIdentifier) {
		this.vendorDetailAssignedIdentifier = vendorDetailAssignedIdentifier;
	}


	/**
	 * Gets the vendorName attribute.
	 * 
	 * @return - Returns the vendorName
	 * 
	 */
	public String getVendorName() { 
		return vendorName;
	}

	/**
	 * Sets the vendorName attribute.
	 * 
	 * @param - vendorName The vendorName to set.
	 * 
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	/**
	 * Gets the vendorLine1Address attribute.
	 * 
	 * @return - Returns the vendorLine1Address
	 * 
	 */
	public String getVendorLine1Address() { 
		return vendorLine1Address;
	}

	/**
	 * Sets the vendorLine1Address attribute.
	 * 
	 * @param - vendorLine1Address The vendorLine1Address to set.
	 * 
	 */
	public void setVendorLine1Address(String vendorLine1Address) {
		this.vendorLine1Address = vendorLine1Address;
	}


	/**
	 * Gets the vendorLine2Address attribute.
	 * 
	 * @return - Returns the vendorLine2Address
	 * 
	 */
	public String getVendorLine2Address() { 
		return vendorLine2Address;
	}

	/**
	 * Sets the vendorLine2Address attribute.
	 * 
	 * @param - vendorLine2Address The vendorLine2Address to set.
	 * 
	 */
	public void setVendorLine2Address(String vendorLine2Address) {
		this.vendorLine2Address = vendorLine2Address;
	}


	/**
	 * Gets the vendorCityName attribute.
	 * 
	 * @return - Returns the vendorCityName
	 * 
	 */
	public String getVendorCityName() { 
		return vendorCityName;
	}

	/**
	 * Sets the vendorCityName attribute.
	 * 
	 * @param - vendorCityName The vendorCityName to set.
	 * 
	 */
	public void setVendorCityName(String vendorCityName) {
		this.vendorCityName = vendorCityName;
	}


	/**
	 * Gets the vendorStateCode attribute.
	 * 
	 * @return - Returns the vendorStateCode
	 * 
	 */
	public String getVendorStateCode() { 
		return vendorStateCode;
	}

	/**
	 * Sets the vendorStateCode attribute.
	 * 
	 * @param - vendorStateCode The vendorStateCode to set.
	 * 
	 */
	public void setVendorStateCode(String vendorStateCode) {
		this.vendorStateCode = vendorStateCode;
	}


	/**
	 * Gets the vendorPostalCode attribute.
	 * 
	 * @return - Returns the vendorPostalCode
	 * 
	 */
	public String getVendorPostalCode() { 
		return vendorPostalCode;
	}

	/**
	 * Sets the vendorPostalCode attribute.
	 * 
	 * @param - vendorPostalCode The vendorPostalCode to set.
	 * 
	 */
	public void setVendorPostalCode(String vendorPostalCode) {
		this.vendorPostalCode = vendorPostalCode;
	}


	/**
	 * Gets the vendorPhoneNumber attribute.
	 * 
	 * @return - Returns the vendorPhoneNumber
	 * 
	 */
	public String getVendorPhoneNumber() { 
		return vendorPhoneNumber;
	}

	/**
	 * Sets the vendorPhoneNumber attribute.
	 * 
	 * @param - vendorPhoneNumber The vendorPhoneNumber to set.
	 * 
	 */
	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}


	/**
	 * Gets the vendorFaxNumber attribute.
	 * 
	 * @return - Returns the vendorFaxNumber
	 * 
	 */
	public String getVendorFaxNumber() { 
		return vendorFaxNumber;
	}

	/**
	 * Sets the vendorFaxNumber attribute.
	 * 
	 * @param - vendorFaxNumber The vendorFaxNumber to set.
	 * 
	 */
	public void setVendorFaxNumber(String vendorFaxNumber) {
		this.vendorFaxNumber = vendorFaxNumber;
	}


	/**
	 * Gets the vendorEmailAddress attribute.
	 * 
	 * @return - Returns the vendorEmailAddress
	 * 
	 */
	public String getVendorEmailAddress() { 
		return vendorEmailAddress;
	}

	/**
	 * Sets the vendorEmailAddress attribute.
	 * 
	 * @param - vendorEmailAddress The vendorEmailAddress to set.
	 * 
	 */
	public void setVendorEmailAddress(String vendorEmailAddress) {
		this.vendorEmailAddress = vendorEmailAddress;
	}


	/**
	 * Gets the vendorAttentionName attribute.
	 * 
	 * @return - Returns the vendorAttentionName
	 * 
	 */
	public String getVendorAttentionName() { 
		return vendorAttentionName;
	}

	/**
	 * Sets the vendorAttentionName attribute.
	 * 
	 * @param - vendorAttentionName The vendorAttentionName to set.
	 * 
	 */
	public void setVendorAttentionName(String vendorAttentionName) {
		this.vendorAttentionName = vendorAttentionName;
	}


	/**
	 * Gets the purchaseOrderQuoteTransactionTypeCode attribute.
	 * 
	 * @return - Returns the purchaseOrderQuoteTransactionTypeCode
	 * 
	 */
	public String getPurchaseOrderQuoteTransactionTypeCode() { 
		return purchaseOrderQuoteTransactionTypeCode;
	}

	/**
	 * Sets the purchaseOrderQuoteTransactionTypeCode attribute.
	 * 
	 * @param - purchaseOrderQuoteTransactionTypeCode The purchaseOrderQuoteTransactionTypeCode to set.
	 * 
	 */
	public void setPurchaseOrderQuoteTransactionTypeCode(String purchaseOrderQuoteTransactionTypeCode) {
		this.purchaseOrderQuoteTransactionTypeCode = purchaseOrderQuoteTransactionTypeCode;
	}


	/**
	 * Gets the purchaseOrderQuoteTransactionDate attribute.
	 * 
	 * @return - Returns the purchaseOrderQuoteTransactionDate
	 * 
	 */
	public Date getPurchaseOrderQuoteTransactionDate() { 
		return purchaseOrderQuoteTransactionDate;
	}

	/**
	 * Sets the purchaseOrderQuoteTransactionDate attribute.
	 * 
	 * @param - purchaseOrderQuoteTransactionDate The purchaseOrderQuoteTransactionDate to set.
	 * 
	 */
	public void setPurchaseOrderQuoteTransactionDate(Date purchaseOrderQuoteTransactionDate) {
		this.purchaseOrderQuoteTransactionDate = purchaseOrderQuoteTransactionDate;
	}


	/**
	 * Gets the purchaseOrderQuotePriceExpirationDate attribute.
	 * 
	 * @return - Returns the purchaseOrderQuotePriceExpirationDate
	 * 
	 */
	public Date getPurchaseOrderQuotePriceExpirationDate() { 
		return purchaseOrderQuotePriceExpirationDate;
	}

	/**
	 * Sets the purchaseOrderQuotePriceExpirationDate attribute.
	 * 
	 * @param - purchaseOrderQuotePriceExpirationDate The purchaseOrderQuotePriceExpirationDate to set.
	 * 
	 */
	public void setPurchaseOrderQuotePriceExpirationDate(Date purchaseOrderQuotePriceExpirationDate) {
		this.purchaseOrderQuotePriceExpirationDate = purchaseOrderQuotePriceExpirationDate;
	}


	/**
	 * Gets the purchaseOrderQuoteStatusCode attribute.
	 * 
	 * @return - Returns the purchaseOrderQuoteStatusCode
	 * 
	 */
	public String getPurchaseOrderQuoteStatusCode() { 
		return purchaseOrderQuoteStatusCode;
	}

	/**
	 * Sets the purchaseOrderQuoteStatusCode attribute.
	 * 
	 * @param - purchaseOrderQuoteStatusCode The purchaseOrderQuoteStatusCode to set.
	 * 
	 */
	public void setPurchaseOrderQuoteStatusCode(String purchaseOrderQuoteStatusCode) {
		this.purchaseOrderQuoteStatusCode = purchaseOrderQuoteStatusCode;
	}


	/**
	 * Gets the purchaseOrderQuoteAwardDate attribute.
	 * 
	 * @return - Returns the purchaseOrderQuoteAwardDate
	 * 
	 */
	public Date getPurchaseOrderQuoteAwardDate() { 
		return purchaseOrderQuoteAwardDate;
	}

	/**
	 * Sets the purchaseOrderQuoteAwardDate attribute.
	 * 
	 * @param - purchaseOrderQuoteAwardDate The purchaseOrderQuoteAwardDate to set.
	 * 
	 */
	public void setPurchaseOrderQuoteAwardDate(Date purchaseOrderQuoteAwardDate) {
		this.purchaseOrderQuoteAwardDate = purchaseOrderQuoteAwardDate;
	}


	/**
	 * Gets the purchaseOrderQuoteRankNumber attribute.
	 * 
	 * @return - Returns the purchaseOrderQuoteRankNumber
	 * 
	 */
	public String getPurchaseOrderQuoteRankNumber() { 
		return purchaseOrderQuoteRankNumber;
	}

	/**
	 * Sets the purchaseOrderQuoteRankNumber attribute.
	 * 
	 * @param - purchaseOrderQuoteRankNumber The purchaseOrderQuoteRankNumber to set.
	 * 
	 */
	public void setPurchaseOrderQuoteRankNumber(String purchaseOrderQuoteRankNumber) {
		this.purchaseOrderQuoteRankNumber = purchaseOrderQuoteRankNumber;
	}


	/**
	 * Gets the purchaseOrder attribute.
	 * 
	 * @return - Returns the purchaseOrder
	 * 
	 */
	public PurchaseOrder getPurchaseOrder() { 
		return purchaseOrder;
	}

	/**
	 * Sets the purchaseOrder attribute.
	 * 
	 * @param - purchaseOrder The purchaseOrder to set.
	 * @deprecated
	 */
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	/**
	 * Gets the purchaseOrderQuoteStatus attribute.
	 * 
	 * @return - Returns the purchaseOrderQuoteStatus
	 * 
	 */
	public PurchaseOrderQuoteStatus getPurchaseOrderQuoteStatus() { 
		return purchaseOrderQuoteStatus;
	}

	/**
	 * Sets the purchaseOrderQuoteStatus attribute.
	 * 
	 * @param - purchaseOrderQuoteStatus The purchaseOrderQuoteStatus to set.
	 * @deprecated
	 */
	public void setPurchaseOrderQuoteStatus(PurchaseOrderQuoteStatus purchaseOrderQuoteStatus) {
		this.purchaseOrderQuoteStatus = purchaseOrderQuoteStatus;
	}

    /**
     * Gets the vendorCountryCode attribute. 
     * @return Returns the vendorCountryCode.
     */
    public String getVendorCountryCode() {
        return vendorCountryCode;
    }

    /**
     * Sets the vendorCountryCode attribute value.
     * @param vendorCountryCode The vendorCountryCode to set.
     */
    public void setVendorCountryCode(String vendorCountryCode) {
        this.vendorCountryCode = vendorCountryCode;
    }

    /**
     * @see org.kuali.bo.BusinessObjectBase#toStringMapper()
     */
    protected LinkedHashMap toStringMapper() {
        LinkedHashMap m = new LinkedHashMap();      
        if (this.purchaseOrderVendorQuoteIdentifier != null) {
            m.put("purchaseOrderVendorQuoteIdentifier", this.purchaseOrderVendorQuoteIdentifier.toString());
        }
        return m;
    }

}
