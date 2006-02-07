/**
 * Gettypes_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class Gettypes_response  implements java.io.Serializable {
    private java.lang.String sf_id;

    private is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes[] types;

    public Gettypes_response() {
    }

    public Gettypes_response(
           java.lang.String sf_id,
           is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes[] types) {
           this.sf_id = sf_id;
           this.types = types;
    }


    /**
     * Gets the sf_id value for this Gettypes_response.
     * 
     * @return sf_id
     */
    public java.lang.String getSf_id() {
        return sf_id;
    }


    /**
     * Sets the sf_id value for this Gettypes_response.
     * 
     * @param sf_id
     */
    public void setSf_id(java.lang.String sf_id) {
        this.sf_id = sf_id;
    }


    /**
     * Gets the types value for this Gettypes_response.
     * 
     * @return types
     */
    public is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes[] getTypes() {
        return types;
    }


    /**
     * Sets the types value for this Gettypes_response.
     * 
     * @param types
     */
    public void setTypes(is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes[] types) {
        this.types = types;
    }

    public is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes getTypes(int i) {
        return this.types[i];
    }

    public void setTypes(int i, is.idega.idegaweb.egov.finances.wsclient.Gettypes_responseTypes _value) {
        this.types[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Gettypes_response)) return false;
        Gettypes_response other = (Gettypes_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sf_id==null && other.getSf_id()==null) || 
             (this.sf_id!=null &&
              this.sf_id.equals(other.getSf_id()))) &&
            ((this.types==null && other.getTypes()==null) || 
             (this.types!=null &&
              java.util.Arrays.equals(this.types, other.getTypes())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSf_id() != null) {
            _hashCode += getSf_id().hashCode();
        }
        if (getTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Gettypes_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetTypesResponse", "gettypes_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sf_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sf_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("types");
        elemField.setXmlName(new javax.xml.namespace.QName("", "types"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetTypesResponse", "gettypes_responseTypes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
