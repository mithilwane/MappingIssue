package com.example.demo.entity;

/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class representing jdta_item_multi_attrs table
 *
 * @author 50232808
 *
 */

@Entity
@Table(name = "JDTA_ITEM_MULTI_ATTRS")
@Inheritance(strategy = InheritanceType.JOINED)
public class JdtaItemMultiAttrs
        implements Serializable
{
    /**
     * generated id
     */
    private static final long  serialVersionUID = 8002L;

    @EmbeddedId
    private JdtaItemMultiAttrsPk jdtaItemMultiAttrsPk;

    @OneToOne
    @JoinColumn(name = "attr_data_value_id", insertable = false, updatable = false)
    private AttributeDataValue attributeDataValue;

    @Column(name = "attr_data_type_id")
    private int                attributeDataTypeId;

    /**
     * Constructor
     */
    public JdtaItemMultiAttrs()
    {

    }

    /**
     * 
     * Copy Constructor
     * 
     * @param src instance to copy
     */
    public JdtaItemMultiAttrs(JdtaItemMultiAttrs src)
    {
        this.setJdtaItemId(src.getJdtaItemId());
        this.setAttributeDataTypeId(src.getAttributeDataTypeId());
        this.setAttributeDataValueId(src.getAttributeDataValueId());
    }

    public JdtaItemMultiAttrsPk getJdtaItemMultiAttrsPk() {
		return jdtaItemMultiAttrsPk;
	}

	public void setJdtaItemMultiAttrsPk(JdtaItemMultiAttrsPk jdtaItemMultiAttrsPk) {
		this.jdtaItemMultiAttrsPk = jdtaItemMultiAttrsPk;
	}

	/**
     *
     * @return the JDTA Item Id
     */
    public int getJdtaItemId()
    {
        return this.getJdtaItemMultiAttrsPk().getJdtaItemId();
    }

    /**
     *
     * @param jdtaItemId the JDTA Item Id
     */
    public void setJdtaItemId(int jdtaItemId)
    {
        this.getJdtaItemMultiAttrsPk().setJdtaItemId(jdtaItemId);
    }

    /**
     *
     * @return the Attribute Data Value Id
     */
    public int getAttributeDataValueId()
    {
        return this.getJdtaItemMultiAttrsPk().getAttributeDataValueId();
    }

    /**
     *
     * @param attributeDataValueId the Attribute Data Value Id
     */
    public void setAttributeDataValueId(int attributeDataValueId)
    {
        this.getJdtaItemMultiAttrsPk().setAttributeDataValueId(attributeDataValueId);
    }

    /**
     *
     * @return the Attribute Data Value
     */
    public AttributeDataValue getAttributeDataValue()
    {
        return this.attributeDataValue;
    }

    /**
     * @param attributeDataValue attribute data value
     */
    public void setAttributeDataValue(AttributeDataValue attributeDataValue)
    {
        this.attributeDataValue = attributeDataValue;
    }

    /**
     *
     * @return the Attribute Data Type Id
     */
    public int getAttributeDataTypeId()
    {
        return this.attributeDataTypeId;
    }

    /**
     *
     * @param attributeDataTypeId the Attribute Data Type Id
     */
    public void setAttributeDataTypeId(int attributeDataTypeId)
    {
        this.attributeDataTypeId = attributeDataTypeId;
    }

    @Override
    public boolean equals(Object other)
    {
        if ( other == this )
        {
            return true;
        }

        if ( !(other instanceof JdtaItemMultiAttrs) )
        {
            return false;
        }

        JdtaItemMultiAttrs otherAttr = (JdtaItemMultiAttrs) other;

        if ( (this.getJdtaItemId() == otherAttr.getJdtaItemId())
                && (this.getAttributeDataValueId() == otherAttr.getAttributeDataValueId()) )
        {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        Integer j = this.getJdtaItemId();
        Integer a = this.getAttributeDataValueId();

        return (j.hashCode() ^ a.hashCode());
    }
}
