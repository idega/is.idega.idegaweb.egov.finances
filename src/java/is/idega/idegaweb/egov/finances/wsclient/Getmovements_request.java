/**
 * Getmovements_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class Getmovements_request  implements java.io.Serializable {
    private int sf_id;

    private java.lang.String social_security;

    private java.lang.String date_from;

    private java.lang.String date_to;

    private int type_id;

    public Getmovements_request() {
    }

    public Getmovements_request(
           int sf_id,
           java.lang.String social_security,
           java.lang.String date_from,
           java.lang.String date_to,
           int type_id) {
           this.sf_id = sf_id;
           this.social_security = social_security;
           this.date_from = date_from;
           this.date_to = date_to;
           this.type_id = type_id;
    }


    /**
     * Gets the sf_id value for this Getmovements_request.
     * 
     * @return sf_id
     */
    public int getSf_id() {
        return sf_id;
    }


    /**
     * Sets the sf_id value for this Getmovements_request.
     * 
     * @param sf_id
     */
    public void setSf_id(int sf_id) {
        this.sf_id = sf_id;
    }


    /**
     * Gets the social_security value for this Getmovements_request.
     * 
     * @return social_security
     */
    public java.lang.String getSocial_security() {
        return social_security;
    }


    /**
     * Sets the social_security value for this Getmovements_request.
     * 
     * @param social_security
     */
    public void setSocial_security(java.lang.String social_security) {
        this.social_security = social_security;
    }


    /**
     * Gets the date_from value for this Getmovements_request.
     * 
     * @return date_from
     */
    public java.lang.String getDate_from() {
        return date_from;
    }


    /**
     * Sets the date_from value for this Getmovements_request.
     * 
     * @param date_from
     */
    public void setDate_from(java.lang.String date_from) {
        this.date_from = date_from;
    }


    /**
     * Gets the date_to value for this Getmovements_request.
     * 
     * @return date_to
     */
    public java.lang.String getDate_to() {
        return date_to;
    }


    /**
     * Sets the date_to value for this Getmovements_request.
     * 
     * @param date_to
     */
    public void setDate_to(java.lang.String date_to) {
        this.date_to = date_to;
    }


    /**
     * Gets the type_id value for this Getmovements_request.
     * 
     * @return type_id
     */
    public int getType_id() {
        return type_id;
    }


    /**
     * Sets the type_id value for this Getmovements_request.
     * 
     * @param type_id
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Getmovements_request)) return false;
        Getmovements_request other = (Getmovements_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.sf_id == other.getSf_id() &&
            ((this.social_security==null && other.getSocial_security()==null) || 
             (this.social_security!=null &&
              this.social_security.equals(other.getSocial_security()))) &&
            ((this.date_from==null && other.getDate_from()==null) || 
             (this.date_from!=null &&
              this.date_from.equals(other.getDate_from()))) &&
            ((this.date_to==null && other.getDate_to()==null) || 
             (this.date_to!=null &&
              this.date_to.equals(other.getDate_to()))) &&
            this.type_id == other.getType_id();
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
        _hashCode += getSf_id();
        if (getSocial_security() != null) {
            _hashCode += getSocial_security().hashCode();
        }
        if (getDate_from() != null) {
            _hashCode += getDate_from().hashCode();
        }
        if (getDate_to() != null) {
            _hashCode += getDate_to().hashCode();
        }
        _hashCode += getType_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Getmovements_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetMovementsRequest", "getmovements_request"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sf_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sf_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("social_security");
        elemField.setXmlName(new javax.xml.namespace.QName("", "social_security"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_from");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date_from"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_to");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date_to"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
