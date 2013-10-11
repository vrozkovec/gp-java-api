/**
 * AxisEPaymentProviderV2ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.gopay.api.v2.axis;

public class AxisEPaymentProviderV2ServiceLocator extends org.apache.axis.client.Service implements cz.gopay.api.v2.axis.AxisEPaymentProviderV2Service {

    public AxisEPaymentProviderV2ServiceLocator() {
    }


    public AxisEPaymentProviderV2ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AxisEPaymentProviderV2ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EPaymentServiceV2
    private java.lang.String EPaymentServiceV2_address = "http://gopay-gateways:8180/gp/axis/EPaymentServiceV2";

    public java.lang.String getEPaymentServiceV2Address() {
        return EPaymentServiceV2_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EPaymentServiceV2WSDDServiceName = "EPaymentServiceV2";

    public java.lang.String getEPaymentServiceV2WSDDServiceName() {
        return EPaymentServiceV2WSDDServiceName;
    }

    public void setEPaymentServiceV2WSDDServiceName(java.lang.String name) {
        EPaymentServiceV2WSDDServiceName = name;
    }

    public cz.gopay.api.v2.axis.AxisEPaymentProviderV2 getEPaymentServiceV2() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EPaymentServiceV2_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEPaymentServiceV2(endpoint);
    }

    public cz.gopay.api.v2.axis.AxisEPaymentProviderV2 getEPaymentServiceV2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cz.gopay.api.v2.axis.EPaymentServiceV2SoapBindingStub _stub = new cz.gopay.api.v2.axis.EPaymentServiceV2SoapBindingStub(portAddress, this);
            _stub.setPortName(getEPaymentServiceV2WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEPaymentServiceV2EndpointAddress(java.lang.String address) {
        EPaymentServiceV2_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cz.gopay.api.v2.axis.AxisEPaymentProviderV2.class.isAssignableFrom(serviceEndpointInterface)) {
                cz.gopay.api.v2.axis.EPaymentServiceV2SoapBindingStub _stub = new cz.gopay.api.v2.axis.EPaymentServiceV2SoapBindingStub(new java.net.URL(EPaymentServiceV2_address), this);
                _stub.setPortName(getEPaymentServiceV2WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EPaymentServiceV2".equals(inputPortName)) {
            return getEPaymentServiceV2();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://gate.gopay.cz/ws", "AxisEPaymentProviderV2Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://gate.gopay.cz/ws", "EPaymentServiceV2"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EPaymentServiceV2".equals(portName)) {
            setEPaymentServiceV2EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
