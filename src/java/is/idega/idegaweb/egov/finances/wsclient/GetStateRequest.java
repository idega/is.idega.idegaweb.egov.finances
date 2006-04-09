/**
 * GetStateRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class GetStateRequest  implements java.io.Serializable {
    private java.lang.String sf_id;

    private java.lang.String social_security;

    public GetStateRequest() {
    }

    public GetStateRequest(
           java.lang.String sf_id,
           java.lang.String social_security) {
           this.sf_id = sf_id;
           this.social_security = social_security;
    }


    /**
     * Gets the sf_id value for this GetStateRequest.
     * 
     * @return sf_id
     */
    public java.lang.String getSf_id() {
        return this.sf_id;
    }


    /**
     * Sets the sf_id value for this GetStateRequest.
     * 
     * @param sf_id
     */
    public void setSf_id(java.lang.String sf_id) {
        this.sf_id = sf_id;
    }


    /**
     * Gets the social_security value for this GetStateRequest.
     * 
     * @return social_security
     */
    public java.lang.String getSocial_security() {
        return this.social_security;
    }


    /**
     * Sets the social_security value for this GetStateRequest.
     * 
     * @param social_security
     */
    public void setSocial_security(java.lang.String social_security) {
        this.social_security = social_security;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStateRequest)) {
					return false;
				}
        GetStateRequest other = (GetStateRequest) obj;
        if (obj == null) {
					return false;
				}
        if (this == obj) {
					return true;
				}
        if (this.__equalsCalc != null) {
            return (this.__equalsCalc == obj);
        }
        this.__equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sf_id==null && other.getSf_id()==null) || 
             (this.sf_id!=null &&
              this.sf_id.equals(other.getSf_id()))) &&
            ((this.social_security==null && other.getSocial_security()==null) || 
             (this.social_security!=null &&
              this.social_security.equals(other.getSocial_security())));
        this.__equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (this.__hashCodeCalc) {
            return 0;
        }
        this.__hashCodeCalc = true;
        int _hashCode = 1;
        if (getSf_id() != null) {
            _hashCode += getSf_id().hashCode();
        }
        if (getSocial_security() != null) {
            _hashCode += getSocial_security().hashCode();
        }
        this.__hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStateRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetStateRequest", "GetStateRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sf_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sf_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("social_security");
        elemField.setXmlName(new javax.xml.namespace.QName("", "social_security"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
