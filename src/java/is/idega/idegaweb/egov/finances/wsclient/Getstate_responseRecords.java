/**
 * Getstate_responseRecords.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class Getstate_responseRecords  implements java.io.Serializable {
    private java.lang.String sf_id;

    private java.lang.String social_security;

    private java.lang.String type_id;

    private java.lang.String description;

    private java.math.BigDecimal balance;

    private java.lang.String oldest_unpaid_date;

    public Getstate_responseRecords() {
    }

    public Getstate_responseRecords(
           java.lang.String sf_id,
           java.lang.String social_security,
           java.lang.String type_id,
           java.lang.String description,
           java.math.BigDecimal balance,
           java.lang.String oldest_unpaid_date) {
           this.sf_id = sf_id;
           this.social_security = social_security;
           this.type_id = type_id;
           this.description = description;
           this.balance = balance;
           this.oldest_unpaid_date = oldest_unpaid_date;
    }


    /**
     * Gets the sf_id value for this Getstate_responseRecords.
     * 
     * @return sf_id
     */
    public java.lang.String getSf_id() {
        return sf_id;
    }


    /**
     * Sets the sf_id value for this Getstate_responseRecords.
     * 
     * @param sf_id
     */
    public void setSf_id(java.lang.String sf_id) {
        this.sf_id = sf_id;
    }


    /**
     * Gets the social_security value for this Getstate_responseRecords.
     * 
     * @return social_security
     */
    public java.lang.String getSocial_security() {
        return social_security;
    }


    /**
     * Sets the social_security value for this Getstate_responseRecords.
     * 
     * @param social_security
     */
    public void setSocial_security(java.lang.String social_security) {
        this.social_security = social_security;
    }


    /**
     * Gets the type_id value for this Getstate_responseRecords.
     * 
     * @return type_id
     */
    public java.lang.String getType_id() {
        return type_id;
    }


    /**
     * Sets the type_id value for this Getstate_responseRecords.
     * 
     * @param type_id
     */
    public void setType_id(java.lang.String type_id) {
        this.type_id = type_id;
    }


    /**
     * Gets the description value for this Getstate_responseRecords.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Getstate_responseRecords.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the balance value for this Getstate_responseRecords.
     * 
     * @return balance
     */
    public java.math.BigDecimal getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this Getstate_responseRecords.
     * 
     * @param balance
     */
    public void setBalance(java.math.BigDecimal balance) {
        this.balance = balance;
    }


    /**
     * Gets the oldest_unpaid_date value for this Getstate_responseRecords.
     * 
     * @return oldest_unpaid_date
     */
    public java.lang.String getOldest_unpaid_date() {
        return oldest_unpaid_date;
    }


    /**
     * Sets the oldest_unpaid_date value for this Getstate_responseRecords.
     * 
     * @param oldest_unpaid_date
     */
    public void setOldest_unpaid_date(java.lang.String oldest_unpaid_date) {
        this.oldest_unpaid_date = oldest_unpaid_date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Getstate_responseRecords)) return false;
        Getstate_responseRecords other = (Getstate_responseRecords) obj;
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
            ((this.social_security==null && other.getSocial_security()==null) || 
             (this.social_security!=null &&
              this.social_security.equals(other.getSocial_security()))) &&
            ((this.type_id==null && other.getType_id()==null) || 
             (this.type_id!=null &&
              this.type_id.equals(other.getType_id()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.balance==null && other.getBalance()==null) || 
             (this.balance!=null &&
              this.balance.equals(other.getBalance()))) &&
            ((this.oldest_unpaid_date==null && other.getOldest_unpaid_date()==null) || 
             (this.oldest_unpaid_date!=null &&
              this.oldest_unpaid_date.equals(other.getOldest_unpaid_date())));
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
        if (getSocial_security() != null) {
            _hashCode += getSocial_security().hashCode();
        }
        if (getType_id() != null) {
            _hashCode += getType_id().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getBalance() != null) {
            _hashCode += getBalance().hashCode();
        }
        if (getOldest_unpaid_date() != null) {
            _hashCode += getOldest_unpaid_date().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Getstate_responseRecords.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetStateResponse", "getstate_responseRecords"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type_id"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oldest_unpaid_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oldest_unpaid_date"));
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
