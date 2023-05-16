/*
 * This work was created by participants in the DataONE project, and is jointly copyrighted by
 * participating institutions in DataONE. For more information on DataONE, see our web site at
 * http://dataone.org.
 *
 * Copyright 2019. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.dataone.bookkeeper.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 
 * Payment represents the payment information received from a payment processor. Successful receipt
 * of payment information indicates whether a payment was approved or not, and thus whether an Order
 * can transition from created to paid state.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Payment {

    @NotEmpty
    @NotNull
    private String accountId;
    private String timestamp;
    private String count;
    private String hash;
    private String transactionId;
    private String authorizationCode;
    private String authorizationMessage;
    private String requestAmount;
    private String transactionAmount;
    private String orderId;
    private String products;
    private String transactionApproved;
    private String transactionTimestamp;

    // private String tenderType;
    // private String cardBrand;
    // private String transactionType;
    // private String last4;
    // private String cardExpiration;
    // private String fid;
    // private String ipAddress;
    // private String firstName;
    // private String lastName;
    // private String keyed;
    // private String swiped;
    // private String entryMode;
    // private String avsResponse;
    // private String reasonCode;
    // private String traceNumber;
    // private String network;
    // private String currency;
    // private String error;
    // private String errorCode;
    // private String errorMessage;
    // private String errorMsg;
    // private String firstLastName;
    // private String gRecaptchaResponse;
    // private String hiddenRecaptcha;
    // private String hostedPaymentSignal;
    // private String callbackMethod;
    // private String expressCheckOutPayload;
    // private String description;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Payment() {}

    /**
     *
     * @param fid
     * @param last4
     * @param lastName
     * @param gRecaptchaResponse
     * @param traceNumber
     * @param authorizationCode
     * @param authorizationMessage
     * @param errorCode
     * @param description
     * @param requestAmount
     * @param error
     * @param transactionTimestamp
     * @param network
     * @param products
     * @param tenderType
     * @param swiped
     * @param firstLastName
     * @param transactionAmount
     * @param currency
     * @param callbackMethod
     * @param reasonCode
     * @param cardBrand
     * @param cardExpiration
     * @param entryMode
     * @param orderId
     * @param hostedPaymentSignal
     * @param ipAddress
     * @param errorMessage
     * @param keyed
     * @param transactionId
     * @param avsResponse
     * @param expressCheckOutPayload
     * @param errorMsg
     * @param transactionType
     * @param firstName
     * @param transactionApproved
     * @param hiddenRecaptcha
     */
    public Payment(@NotEmpty @NotNull String accountId, @NotEmpty @NotNull String timestamp,
            @NotEmpty @NotNull String count, @NotEmpty @NotNull String hash, String transactionId,
            // String tenderType,
            String transactionTimestamp,
            // String cardBrand,
            // String transactionType, String last4, String cardExpiration,
            String authorizationCode, String authorizationMessage, String requestAmount,
            String transactionAmount,
            // String fid, String ipAddress,
            // String firstName, String lastName, String keyed, String swiped, String entryMode,
            String transactionApproved,
            // String avsResponse, String reasonCode, String traceNumber, String network,
            // String currency, String error, String errorCode, String errorMessage, String
            // errorMsg,
            String orderId, String products
    // String firstLastName, String gRecaptchaResponse, String hiddenRecaptcha,
    // String hostedPaymentSignal, String callbackMethod, String expressCheckOutPayload, String
    // description
    ) {
        super();
        this.accountId = accountId;
        this.timestamp = timestamp;
        this.count = count;
        this.hash = hash;

        this.transactionId = transactionId;
        // this.tenderType = tenderType;
        this.transactionTimestamp = transactionTimestamp;
        // this.cardBrand = cardBrand;
        // this.transactionType = transactionType;
        // this.last4 = last4;
        // this.cardExpiration = cardExpiration;
        this.authorizationCode = authorizationCode;
        this.authorizationMessage = authorizationMessage;
        this.requestAmount = requestAmount;
        this.transactionAmount = transactionAmount;
        // this.fid = fid;
        // this.ipAddress = ipAddress;
        // this.firstName = firstName;
        // this.lastName = lastName;
        // this.keyed = keyed;
        // this.swiped = swiped;
        // this.entryMode = entryMode;
        this.transactionApproved = transactionApproved;
        // this.avsResponse = avsResponse;
        // this.reasonCode = reasonCode;
        // this.traceNumber = traceNumber;
        // this.network = network;
        // this.currency = currency;
        // this.error = error;
        // this.errorCode = errorCode;
        // this.errorMessage = errorMessage;
        // this.errorMsg = errorMsg;
        this.orderId = orderId;
        this.products = products;
        // this.firstLastName = firstLastName;
        // this.gRecaptchaResponse = gRecaptchaResponse;
        // this.hiddenRecaptcha = hiddenRecaptcha;
        // this.hostedPaymentSignal = hostedPaymentSignal;
        // this.callbackMethod = callbackMethod;
        // this.expressCheckOutPayload = expressCheckOutPayload;
        // this.description = description;
    }

    @JsonProperty
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty
    public String getCount() {
        return count;
    }

    @JsonProperty
    public void setCount(String count) {
        this.count = count;
    }

    @JsonProperty
    public String getHash() {
        return hash;
    }

    @JsonProperty
    public void setHash(String hash) {
        this.hash = hash;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("responses")
    private void unpackFirstElement(ArrayList<Object> responses) {
        Map<String, String> firstResponse = (Map<String, String>) responses.get(0);
        this.transactionId = (String) firstResponse.get("transaction_id");
        this.authorizationCode = (String) firstResponse.get("authorization_code");
        this.authorizationMessage = (String) firstResponse.get("authorization_message");
        this.requestAmount = (String) firstResponse.get("request_amount");
        this.transactionAmount = (String) firstResponse.get("transaction_amount");
        this.orderId = (String) firstResponse.get("orderid");
        this.products = (String) firstResponse.get("products");
        this.transactionApproved = (String) firstResponse.get("transaction_approved");
        this.transactionTimestamp = (String) firstResponse.get("transaction_timestamp");
    }

    @JsonProperty
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    // public String getTenderType() {
    // return tenderType;
    // }

    // public void setTenderType(String tenderType) {
    // this.tenderType = tenderType;
    // }

    @JsonProperty
    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    @JsonProperty
    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    // public String getCardBrand() {
    // return cardBrand;
    // }

    // public void setCardBrand(String cardBrand) {
    // this.cardBrand = cardBrand;
    // }

    // public String getTransactionType() {
    // return transactionType;
    // }

    // public void setTransactionType(String transactionType) {
    // this.transactionType = transactionType;
    // }

    // public String getLast4() {
    // return last4;
    // }

    // public void setLast4(String last4) {
    // this.last4 = last4;
    // }

    // public String getCardExpiration() {
    // return cardExpiration;
    // }

    // public void setCardExpiration(String cardExpiration) {
    // this.cardExpiration = cardExpiration;
    // }

    @JsonProperty
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    @JsonProperty
    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    @JsonProperty
    public String getAuthorizationMessage() {
        return authorizationMessage;
    }

    @JsonProperty
    public void setAuthorizationMessage(String authorizationMessage) {
        this.authorizationMessage = authorizationMessage;
    }

    @JsonProperty
    public String getRequestAmount() {
        return requestAmount;
    }

    @JsonProperty
    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    @JsonProperty
    public String getTransactionAmount() {
        return transactionAmount;
    }

    @JsonProperty
    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    // public String getFid() {
    // return fid;
    // }

    // public void setFid(String fid) {
    // this.fid = fid;
    // }

    // public String getIpAddress() {
    // return ipAddress;
    // }

    // public void setIpAddress(String ipAddress) {
    // this.ipAddress = ipAddress;
    // }

    // public String getFirstName() {
    // return firstName;
    // }

    // public void setFirstName(String firstName) {
    // this.firstName = firstName;
    // }

    // public String getLastName() {
    // return lastName;
    // }

    // public void setLastName(String lastName) {
    // this.lastName = lastName;
    // }

    // public String getKeyed() {
    // return keyed;
    // }

    // public void setKeyed(String keyed) {
    // this.keyed = keyed;
    // }

    // public String getSwiped() {
    // return swiped;
    // }

    // public void setSwiped(String swiped) {
    // this.swiped = swiped;
    // }

    // public String getEntryMode() {
    // return entryMode;
    // }

    // public void setEntryMode(String entryMode) {
    // this.entryMode = entryMode;
    // }

    @JsonProperty
    public String getTransactionApproved() {
        return transactionApproved;
    }

    @JsonProperty
    public void setTransactionApproved(String transactionApproved) {
        this.transactionApproved = transactionApproved;
    }

    // public String getAvsResponse() {
    // return avsResponse;
    // }

    // public void setAvsResponse(String avsResponse) {
    // this.avsResponse = avsResponse;
    // }

    // public String getReasonCode() {
    // return reasonCode;
    // }

    // public void setReasonCode(String reasonCode) {
    // this.reasonCode = reasonCode;
    // }

    // public String getTraceNumber() {
    // return traceNumber;
    // }

    // public void setTraceNumber(String traceNumber) {
    // this.traceNumber = traceNumber;
    // }

    // public String getNetwork() {
    // return network;
    // }

    // public void setNetwork(String network) {
    // this.network = network;
    // }

    // public String getCurrency() {
    // return currency;
    // }

    // public void setCurrency(String currency) {
    // this.currency = currency;
    // }

    // public String getError() {
    // return error;
    // }

    // public void setError(String error) {
    // this.error = error;
    // }

    // public String getErrorCode() {
    // return errorCode;
    // }

    // public void setErrorCode(String errorCode) {
    // this.errorCode = errorCode;
    // }

    // public String getErrorMessage() {
    // return errorMessage;
    // }

    // public void setErrorMessage(String errorMessage) {
    // this.errorMessage = errorMessage;
    // }

    // public String getErrorMsg() {
    // return errorMsg;
    // }

    // public void setErrorMsg(String errorMsg) {
    // this.errorMsg = errorMsg;
    // }

    @JsonProperty
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty
    public String getProducts() {
        return products;
    }

    @JsonProperty
    public void setProducts(String products) {
        this.products = products;
    }

    // public String getFirstLastName() {
    // return firstLastName;
    // }

    // public void setFirstLastName(String firstLastName) {
    // this.firstLastName = firstLastName;
    // }

    // public String getgRecaptchaResponse() {
    // return gRecaptchaResponse;
    // }

    // public void setgRecaptchaResponse(String gRecaptchaResponse) {
    // this.gRecaptchaResponse = gRecaptchaResponse;
    // }

    // public String getHiddenRecaptcha() {
    // return hiddenRecaptcha;
    // }

    // public void setHiddenRecaptcha(String hiddenRecaptcha) {
    // this.hiddenRecaptcha = hiddenRecaptcha;
    // }

    // public String getHostedPaymentSignal() {
    // return hostedPaymentSignal;
    // }

    // public void setHostedPaymentSignal(String hostedPaymentSignal) {
    // this.hostedPaymentSignal = hostedPaymentSignal;
    // }

    // public String getCallbackMethod() {
    // return callbackMethod;
    // }

    // public void setCallbackMethod(String callbackMethod) {
    // this.callbackMethod = callbackMethod;
    // }

    // public String getExpressCheckOutPayload() {
    // return expressCheckOutPayload;
    // }

    // public void setExpressCheckOutPayload(String expressCheckOutPayload) {
    // this.expressCheckOutPayload = expressCheckOutPayload;
    // }

    // public String getDescription() {
    // return description;
    // }

    // public void setDescription(String description) {
    // this.description = description;
    // }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
