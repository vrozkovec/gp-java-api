/**
 * AxisEPaymentProviderV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.gopay.api.v2.axis;

import cz.gopay.api.v2.EBuyerCreate;
import cz.gopay.api.v2.EBuyerCreateResult;
import cz.gopay.api.v2.EPaymentCommand;
import cz.gopay.api.v2.EPaymentMethod;
import cz.gopay.api.v2.EPaymentResult;
import cz.gopay.api.v2.EPaymentSessionInfo;
import cz.gopay.api.v2.EPaymentStatus;
import cz.gopay.api.v2.ERecurrenceRequest;
import cz.gopay.api.v2.ERefundRequest;

public interface AxisEPaymentProviderV2 extends java.rmi.Remote {
    public EPaymentStatus createPayment(EPaymentCommand paymentCommand) throws java.rmi.RemoteException;
    public EPaymentStatus createRecurrentPayment(ERecurrenceRequest recurrenceRequest) throws java.rmi.RemoteException;
    public EPaymentStatus paymentStatus(EPaymentSessionInfo paymentSessionInfo) throws java.rmi.RemoteException;
    public EBuyerCreateResult createBuyer(EBuyerCreate buyerCreate) throws java.rmi.RemoteException;
    public EPaymentResult refundPayment(EPaymentSessionInfo sessionInfo) throws java.rmi.RemoteException;
    public EPaymentResult refundPayment(ERefundRequest refundRequest) throws java.rmi.RemoteException;
    public EPaymentResult capturePayment(EPaymentSessionInfo sessionInfo) throws java.rmi.RemoteException;
    public EPaymentResult voidAuthorization(EPaymentSessionInfo sessionInfo) throws java.rmi.RemoteException;
    public EPaymentResult voidRecurrentPayment(EPaymentSessionInfo sessionInfo) throws java.rmi.RemoteException;
    

    public EPaymentMethod[] paymentMethodList() throws java.rmi.RemoteException;
    public String touch() throws java.rmi.RemoteException;
    
}
