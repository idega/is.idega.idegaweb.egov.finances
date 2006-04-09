/**
 * Gettypes_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class Gettypes_request  implements java.io.Serializable {
    private java.lang.String sf_id;

    public Gettypes_request() {
    }

    public Gettypes_request(
           java.lang.String sf_id) {
           this.sf_id = sf_id;
    }


    /**
     * Gets the sf_id value for this Gettypes_request.
     * 
     * @return sf_id
     */
    public java.lang.String getSf_id() {
        return this.sf_id;
    }


    /**
     * Sets the sf_id value for this Gettypes_request.
     * 
     * @param sf_id
     */
    public void setSf_id(java.lang.String sf_id) {
        this.sf_id = sf_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Gettypes_request)) {
					return false;
				}
        Gettypes_request other = (Gettypes_request) obj;
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
              this.sf_id.equals(other.getSf_id())));
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
        this.__hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Gettypes_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetTypesRequest", "gettypes_request"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sf_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sf_id"));
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
