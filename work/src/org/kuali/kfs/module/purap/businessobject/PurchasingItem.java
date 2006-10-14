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
package org.kuali.module.purap.bo;

import java.math.BigDecimal;


public interface PurchasingItem {

    /**
     * Gets the ItemIdentifier attribute.
     * 
     * @return - Returns the ItemIdentifier
     * 
     */
    public abstract Integer getItemIdentifier();

    /**
     * Sets the ItemIdentifier attribute.
     * 
     * @param - ItemIdentifier The ItemIdentifier to set.
     * 
     */
    public abstract void setItemIdentifier(Integer ItemIdentifier);

    /**
     * Gets the itemLineNumber attribute.
     * 
     * @return - Returns the itemLineNumber
     * 
     */
    public abstract Integer getItemLineNumber();

    /**
     * Sets the itemLineNumber attribute.
     * 
     * @param - itemLineNumber The itemLineNumber to set.
     * 
     */
    public abstract void setItemLineNumber(Integer itemLineNumber);

    /**
     * Gets the capitalAssetTransactionTypeCode attribute.
     * 
     * @return - Returns the capitalAssetTransactionTypeCode
     * 
     */
    public abstract String getCapitalAssetTransactionTypeCode();

    /**
     * Sets the capitalAssetTransactionTypeCode attribute.
     * 
     * @param - capitalAssetTransactionTypeCode The capitalAssetTransactionTypeCode to set.
     * 
     */
    public abstract void setCapitalAssetTransactionTypeCode(String capitalAssetTransactionTypeCode);

    /**
     * Gets the itemUnitOfMeasureCode attribute.
     * 
     * @return - Returns the itemUnitOfMeasureCode
     * 
     */
    public abstract String getItemUnitOfMeasureCode();

    /**
     * Sets the itemUnitOfMeasureCode attribute.
     * 
     * @param - itemUnitOfMeasureCode The itemUnitOfMeasureCode to set.
     * 
     */
    public abstract void setItemUnitOfMeasureCode(String itemUnitOfMeasureCode);

    /**
     * Gets the itemCatalogNumber attribute.
     * 
     * @return - Returns the itemCatalogNumber
     * 
     */
    public abstract String getItemCatalogNumber();

    /**
     * Sets the itemCatalogNumber attribute.
     * 
     * @param - itemCatalogNumber The itemCatalogNumber to set.
     * 
     */
    public abstract void setItemCatalogNumber(String itemCatalogNumber);

    /**
     * Gets the itemDescription attribute.
     * 
     * @return - Returns the itemDescription
     * 
     */
    public abstract String getItemDescription();

    /**
     * Sets the itemDescription attribute.
     * 
     * @param - itemDescription The itemDescription to set.
     * 
     */
    public abstract void setItemDescription(String itemDescription);

    /**
     * Gets the itemCapitalAssetNoteText attribute.
     * 
     * @return - Returns the itemCapitalAssetNoteText
     * 
     */
    public abstract String getItemCapitalAssetNoteText();

    /**
     * Sets the itemCapitalAssetNoteText attribute.
     * 
     * @param - itemCapitalAssetNoteText The itemCapitalAssetNoteText to set.
     * 
     */
    public abstract void setItemCapitalAssetNoteText(String itemCapitalAssetNoteText);

    /**
     * Gets the itemUnitPrice attribute.
     * 
     * @return - Returns the itemUnitPrice
     * 
     */
    public abstract BigDecimal getItemUnitPrice();

    /**
     * Sets the itemUnitPrice attribute.
     * 
     * @param - itemUnitPrice The itemUnitPrice to set.
     * 
     */
    public abstract void setItemUnitPrice(BigDecimal itemUnitPrice);

    /**
     * Gets the itemTypeCode attribute.
     * 
     * @return - Returns the itemTypeCode
     * 
     */
    public abstract String getItemTypeCode();

    /**
     * Sets the itemTypeCode attribute.
     * 
     * @param - itemTypeCode The itemTypeCode to set.
     * 
     */
    public abstract void setItemTypeCode(String itemTypeCode);

    /**
     * Gets the requisitionLineIdentifier attribute.
     * 
     * @return - Returns the requisitionLineIdentifier
     * 
     */
    public abstract String getRequisitionLineIdentifier();

    /**
     * Sets the LineIdentifier attribute.
     * 
     * @param - LineIdentifier The LineIdentifier to set.
     * 
     */
    public abstract void setRequisitionLineIdentifier(String requisitionLineIdentifier);

    /**
     * Gets the itemAuxiliaryPartIdentifier attribute.
     * 
     * @return - Returns the itemAuxiliaryPartIdentifier
     * 
     */
    public abstract String getItemAuxiliaryPartIdentifier();

    /**
     * Sets the itemAuxiliaryPartIdentifier attribute.
     * 
     * @param - itemAuxiliaryPartIdentifier The itemAuxiliaryPartIdentifier to set.
     * 
     */
    public abstract void setItemAuxiliaryPartIdentifier(String itemAuxiliaryPartIdentifier);

    /**
     * Gets the externalOrganizationB2bProductReferenceNumber attribute.
     * 
     * @return - Returns the externalOrganizationB2bProductReferenceNumber
     * 
     */
    public abstract String getExternalOrganizationB2bProductReferenceNumber();

    /**
     * Sets the externalOrganizationB2bProductReferenceNumber attribute.
     * 
     * @param - externalOrganizationB2bProductReferenceNumber The externalOrganizationB2bProductReferenceNumber to set.
     * 
     */
    public abstract void setExternalOrganizationB2bProductReferenceNumber(String externalOrganizationB2bProductReferenceNumber);

    /**
     * Gets the externalOrganizationB2bProductTypeName attribute.
     * 
     * @return - Returns the externalOrganizationB2bProductTypeName
     * 
     */
    public abstract String getExternalOrganizationB2bProductTypeName();

    /**
     * Sets the externalOrganizationB2bProductTypeName attribute.
     * 
     * @param - externalOrganizationB2bProductTypeName The externalOrganizationB2bProductTypeName to set.
     * 
     */
    public abstract void setExternalOrganizationB2bProductTypeName(String externalOrganizationB2bProductTypeName);

    /**
     * Gets the itemAssignedToTradeInIndicator attribute.
     * 
     * @return - Returns the itemAssignedToTradeInIndicator
     * 
     */
    public abstract boolean getItemAssignedToTradeInIndicator();

    /**
     * Sets the itemAssignedToTradeInIndicator attribute.
     * 
     * @param - itemAssignedToTradeInIndicator The itemAssignedToTradeInIndicator to set.
     * 
     */
    public abstract void setItemAssignedToTradeInIndicator(boolean itemAssignedToTradeInIndicator);

    /**
     * Gets the capitalAssetTransactionType attribute.
     * 
     * @return - Returns the capitalAssetTransactionType
     * 
     */
    public abstract CapitalAssetTransactionType getCapitalAssetTransactionType();

    /**
     * Sets the capitalAssetTransactionType attribute.
     * 
     * @param - capitalAssetTransactionType The capitalAssetTransactionType to set.
     * @deprecated
     */
    public abstract void setCapitalAssetTransactionType(CapitalAssetTransactionType capitalAssetTransactionType);

    /**
     * Gets the itemType attribute.
     * 
     * @return - Returns the itemType
     * 
     */
    public abstract ItemType getItemType();

    /**
     * Sets the itemType attribute.
     * 
     * @param - itemType The itemType to set.
     * @deprecated
     */
    public abstract void setItemType(ItemType itemType);

}