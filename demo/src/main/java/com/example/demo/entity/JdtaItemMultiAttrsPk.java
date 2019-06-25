/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class representing jdta_item_multi_attrs table Id
 *
 * @author 50232808
 *
 */
@Embeddable
public class JdtaItemMultiAttrsPk
        implements Serializable
{
    /**
     * generated id
     */
    private static final long  serialVersionUID = 8002L;
    
    @Column(name = "attr_data_value_id")
    private int                attributeDataValueId;

    @Column(name = "jdta_item_id")
    private int                jdtaItemId;

    /**
     * Constructor
     */
    public JdtaItemMultiAttrsPk()
    {

    }

    /**
     *
     * @return the JDTA Item Id
     */
    public int getJdtaItemId()
    {
        return this.jdtaItemId;
    }

    /**
     *
     * @param jdtaItemId the JDTA Item Id
     */
    public void setJdtaItemId(int jdtaItemId)
    {
        this.jdtaItemId = jdtaItemId;
    }

    /**
     *
     * @return the Attribute Data Value Id
     */
    public int getAttributeDataValueId()
    {
        return this.attributeDataValueId;
    }

    /**
     *
     * @param attributeDataValueId the Attribute Data Value Id
     */
    public void setAttributeDataValueId(int attributeDataValueId)
    {

        this.attributeDataValueId = attributeDataValueId;
    }

    @Override
    public boolean equals(Object other)
    {
        if ( other == this )
        {
            return true;
        }

        if ( !(other instanceof JdtaItemMultiAttrsPk) )
        {
            return false;
        }

        JdtaItemMultiAttrsPk otherAttr = (JdtaItemMultiAttrsPk) other;

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
