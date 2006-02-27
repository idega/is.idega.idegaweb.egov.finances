/**
 * Getmovements_responseMovements.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.finances.wsclient;

public class Getmovements_responseMovements  implements java.io.Serializable {
    private int sf_id;

    private java.lang.String social_security;

    private java.lang.String description;

    private java.lang.String type_id;

    private java.lang.String type;

    private java.math.BigDecimal movement;

    private java.math.BigDecimal balance;

    private java.lang.String publish_date;

    private java.lang.String payment_date;

    public Getmovements_responseMovements() {
    }

    public Getmovements_responseMovements(
           int sf_id,
           java.lang.String social_security,
           java.lang.String description,
           java.lang.String type_id,
           java.lang.String type,
           java.math.BigDecimal movement,
           java.math.BigDecimal balance,
           java.lang.String publish_date,
           java.lang.String payment_date) {
           this.sf_id = sf_id;
           this.social_security = social_security;
           this.description = description;
           this.type_id = type_id;
           this.type = type;
           this.movement = movement;
           this.balance = balance;
           this.publish_date = publish_date;
           this.payment_date = payment_date;
    }


    /**
     * Gets the sf_id value for this Getmovements_responseMovements.
     * 
     * @return sf_id
     */
    public int getSf_id() {
        return sf_id;
    }


    /**
     * Sets the sf_id value for this Getmovements_responseMovements.
     * 
     * @param sf_id
     */
    public void setSf_id(int sf_id) {
        this.sf_id = sf_id;
    }


    /**
     * Gets the social_security value for this Getmovements_responseMovements.
     * 
     * @return social_security
     */
    public java.lang.String getSocial_security() {
        return social_security;
    }


    /**
     * Sets the social_security value for this Getmovements_responseMovements.
     * 
     * @param social_security
     */
    public void setSocial_security(java.lang.String social_security) {
        this.social_security = social_security;
    }


    /**
     * Gets the description value for this Getmovements_responseMovements.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Getmovements_responseMovements.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the type_id value for this Getmovements_responseMovements.
     * 
     * @return type_id
     */
    public java.lang.String getType_id() {
        return type_id;
    }


    /**
     * Sets the type_id value for this Getmovements_responseMovements.
     * 
     * @param type_id
     */
    public void setType_id(java.lang.String type_id) {
        this.type_id = type_id;
    }


    /**
     * Gets the type value for this Getmovements_responseMovements.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Getmovements_responseMovements.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the movement value for this Getmovements_responseMovements.
     * 
     * @return movement
     */
    public java.math.BigDecimal getMovement() {
        return movement;
    }


    /**
     * Sets the movement value for this Getmovements_responseMovements.
     * 
     * @param movement
     */
    public void setMovement(java.math.BigDecimal movement) {
        this.movement = movement;
    }


    /**
     * Gets the balance value for this Getmovements_responseMovements.
     * 
     * @return balance
     */
    public java.math.BigDecimal getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this Getmovements_responseMovements.
     * 
     * @param balance
     */
    public void setBalance(java.math.BigDecimal balance) {
        this.balance = balance;
    }


    /**
     * Gets the publish_date value for this Getmovements_responseMovements.
     * 
     * @return publish_date
     */
    public java.lang.String getPublish_date() {
        return publish_date;
    }


    /**
     * Sets the publish_date value for this Getmovements_responseMovements.
     * 
     * @param publish_date
     */
    public void setPublish_date(java.lang.String publish_date) {
        this.publish_date = publish_date;
    }


    /**
     * Gets the payment_date value for this Getmovements_responseMovements.
     * 
     * @return payment_date
     */
    public java.lang.String getPayment_date() {
        return payment_date;
    }


    /**
     * Sets the payment_date value for this Getmovements_responseMovements.
     * 
     * @param payment_date
     */
    public void setPayment_date(java.lang.String payment_date) {
        this.payment_date = payment_date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Getmovements_responseMovements)) return false;
        Getmovements_responseMovements other = (Getmovements_responseMovements) obj;
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
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.type_id==null && other.getType_id()==null) || 
             (this.type_id!=null &&
              this.type_id.equals(other.getType_id()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.movement==null && other.getMovement()==null) || 
             (this.movement!=null &&
              this.movement.equals(other.getMovement()))) &&
            ((this.balance==null && other.getBalance()==null) || 
             (this.balance!=null &&
              this.balance.equals(other.getBalance()))) &&
            ((this.publish_date==null && other.getPublish_date()==null) || 
             (this.publish_date!=null &&
              this.publish_date.equals(other.getPublish_date()))) &&
            ((this.payment_date==null && other.getPayment_date()==null) || 
             (this.payment_date!=null &&
              this.payment_date.equals(other.getPayment_date())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getType_id() != null) {
            _hashCode += getType_id().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getMovement() != null) {
            _hashCode += getMovement().hashCode();
        }
        if (getBalance() != null) {
            _hashCode += getBalance().hashCode();
        }
        if (getPublish_date() != null) {
            _hashCode += getPublish_date().hashCode();
        }
        if (getPayment_date() != null) {
            _hashCode += getPayment_date().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Getmovements_responseMovements.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://WSGetFinanceData.GetMovementsResponse", "getmovements_responseMovements"));
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
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
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
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "movement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publish_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "publish_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payment_date"));
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
