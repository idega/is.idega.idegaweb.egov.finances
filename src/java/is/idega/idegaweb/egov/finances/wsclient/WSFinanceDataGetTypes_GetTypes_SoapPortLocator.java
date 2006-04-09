/**
 * WSFinanceDataGetTypes_GetTypes_SoapPortLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class WSFinanceDataGetTypes_GetTypes_SoapPortLocator extends org.apache.axis.client.Service implements is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPort {

/**
 * BizTalk assembly "WSFinanceDataGetTypes, Version=1.0.0.0, Culture=neutral,
 * PublicKeyToken=a3421246387e0892" published web service.
 */

    public WSFinanceDataGetTypes_GetTypes_SoapPortLocator() {
    }


    public WSFinanceDataGetTypes_GetTypes_SoapPortLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSFinanceDataGetTypes_GetTypes_SoapPortLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSFinanceDataGetTypes_GetTypes_SoapPortSoap
    private java.lang.String WSFinanceDataGetTypes_GetTypes_SoapPortSoap_address = "http://213.167.155.148/WSFinanceDataGetTypes/WSFinanceDataGetTypes_GetTypes_SoapPort.asmx";

    public java.lang.String getWSFinanceDataGetTypes_GetTypes_SoapPortSoapAddress() {
        return this.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName = "WSFinanceDataGetTypes_GetTypes_SoapPortSoap";

    public java.lang.String getWSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName() {
        return this.WSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName;
    }

    public void setWSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName(java.lang.String name) {
        this.WSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName = name;
    }

    public is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_PortType getWSFinanceDataGetTypes_GetTypes_SoapPortSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(this.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSFinanceDataGetTypes_GetTypes_SoapPortSoap(endpoint);
    }

    public is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_PortType getWSFinanceDataGetTypes_GetTypes_SoapPortSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_BindingStub _stub = new is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_BindingStub(portAddress, this);
            _stub.setPortName(getWSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSFinanceDataGetTypes_GetTypes_SoapPortSoapEndpointAddress(java.lang.String address) {
        this.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_BindingStub _stub = new is.idega.idegaweb.egov.finances.wsclient.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_BindingStub(new java.net.URL(this.WSFinanceDataGetTypes_GetTypes_SoapPortSoap_address), this);
                _stub.setPortName(getWSFinanceDataGetTypes_GetTypes_SoapPortSoapWSDDServiceName());
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
        if ("WSFinanceDataGetTypes_GetTypes_SoapPortSoap".equals(inputPortName)) {
            return getWSFinanceDataGetTypes_GetTypes_SoapPortSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WSFinanceDataGetTypes/", "WSFinanceDataGetTypes_GetTypes_SoapPort");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new java.util.HashSet();
            this.ports.add(new javax.xml.namespace.QName("http://WSFinanceDataGetTypes/", "WSFinanceDataGetTypes_GetTypes_SoapPortSoap"));
        }
        return this.ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSFinanceDataGetTypes_GetTypes_SoapPortSoap".equals(portName)) {
            setWSFinanceDataGetTypes_GetTypes_SoapPortSoapEndpointAddress(address);
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
