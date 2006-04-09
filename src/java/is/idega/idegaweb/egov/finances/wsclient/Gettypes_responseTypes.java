/**
 * Gettypes_responseTypes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class Gettypes_responseTypes  implements java.io.Serializable {
    private java.lang.String type_id;

    private java.lang.String type;

    private java.lang.String description;

    public Gettypes_responseTypes() {
    }

    public Gettypes_responseTypes(
           java.lang.String type_id,
           java.lang.String type,
           java.lang.String description) {
           this.type_id = type_id;
           this.type = type;
           this.description = description;
    }


    /**
     * Gets the type_id value for this Gettypes_responseTypes.
     * 
     * @return type_id
     */
    public java.lang.String getType_id() {
        return this.type_id;
    }


    /**
     * Sets the type_id value for this Gettypes_responseTypes.
     * 
     * @param type_id
     */
    public void setType_id(java.lang.String type_id) {
        this.type_id = type_id;
    }


    /**
     * Gets the type value for this Gettypes_responseTypes.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return this.type;
    }


    /**
     * Sets the type value for this Gettypes_responseTypes.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the description value for this Gettypes_responseTypes.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return this.description;
    }


    /**
     * Sets the description value for this Gettypes_responseTypes.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Gettypes_responseTypes)) {
					return false;
				}
        Gettypes_responseTypes other = (Gettypes_responseTypes) obj;
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
            ((this.type_id==null && other.getType_id()==null) || 
             (this.type_id!=null &&
              this.type_id.equals(other.getType_id()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription())));
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
        if (getType_id() != null) {
            _hashCode += getType_id().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        this.__hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Gettypes_responseTypes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetTypesResponse", "gettypes_responseTypes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
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
