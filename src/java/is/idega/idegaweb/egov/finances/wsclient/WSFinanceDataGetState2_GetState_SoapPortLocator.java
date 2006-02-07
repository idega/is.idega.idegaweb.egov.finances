/**
 * WSFinanceDataGetState2_GetState_SoapPortLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class WSFinanceDataGetState2_GetState_SoapPortLocator extends org.apache.axis.client.Service implements is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPort {

/**
 * BizTalk assembly "WSFinanceDataGetState2, Version=1.0.0.0, Culture=neutral,
 * PublicKeyToken=01ce62a9bfeaf78f" published web service.
 */

    public WSFinanceDataGetState2_GetState_SoapPortLocator() {
    }


    public WSFinanceDataGetState2_GetState_SoapPortLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSFinanceDataGetState2_GetState_SoapPortLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSFinanceDataGetState2_GetState_SoapPortSoap
    private java.lang.String WSFinanceDataGetState2_GetState_SoapPortSoap_address = "http://213.167.155.148/WSFinanceDataGetState2/WSFinanceDataGetState2_GetState_SoapPort.asmx";

    public java.lang.String getWSFinanceDataGetState2_GetState_SoapPortSoapAddress() {
        return WSFinanceDataGetState2_GetState_SoapPortSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName = "WSFinanceDataGetState2_GetState_SoapPortSoap";

    public java.lang.String getWSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName() {
        return WSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName;
    }

    public void setWSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName(java.lang.String name) {
        WSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName = name;
    }

    public is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_PortType getWSFinanceDataGetState2_GetState_SoapPortSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSFinanceDataGetState2_GetState_SoapPortSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSFinanceDataGetState2_GetState_SoapPortSoap(endpoint);
    }

    public is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_PortType getWSFinanceDataGetState2_GetState_SoapPortSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_BindingStub _stub = new is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSFinanceDataGetState2_GetState_SoapPortSoapEndpointAddress(java.lang.String address) {
        WSFinanceDataGetState2_GetState_SoapPortSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_BindingStub _stub = new is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetState2_GetState_SoapPortSoap_BindingStub(new java.net.URL(WSFinanceDataGetState2_GetState_SoapPortSoap_address), this);
                _stub.setPortName(getWSFinanceDataGetState2_GetState_SoapPortSoapWSDDServiceName());
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
        if ("WSFinanceDataGetState2_GetState_SoapPortSoap".equals(inputPortName)) {
            return getWSFinanceDataGetState2_GetState_SoapPortSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WSFinanceDataGetState/", "WSFinanceDataGetState2_GetState_SoapPort");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WSFinanceDataGetState/", "WSFinanceDataGetState2_GetState_SoapPortSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSFinanceDataGetState2_GetState_SoapPortSoap".equals(portName)) {
            setWSFinanceDataGetState2_GetState_SoapPortSoapEndpointAddress(address);
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
