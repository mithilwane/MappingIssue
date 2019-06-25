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
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.entity.model.KsatrType;

/**
 * Class representing ATTR_DATA_KSATRS table
 *
 * @author 502359246
 *
 */

@Entity
@Table(name = "ATTR_DATA_KSATRS")
public class AttributeDataKsatr extends JdtaItemMultiAttrs
        implements Serializable
{
    /**
     * generated id
     */
    private static final long  serialVersionUID = 1L;

    @Column(name = "attr_data_value_id", insertable=false, updatable = false)
    private int                id;
    
    @OneToOne
    @JoinColumn(name = "ksatr_type_id")
    private KsatrType          type;

    @OneToOne
    @JoinColumn(name = "attr_data_value_id", insertable=false, updatable = false)
    private AttributeDataValue attributeDataValue;

    /**
     * Constructor
     */
    public AttributeDataKsatr()
    {
    }

    /**
     *
     * @return the primary key for this item
     */
    public int getId()
    {
        return this.id;
    }

    /**
     *
     * @return the type
     */
    public KsatrType getType()
    {
        return this.type;
    }

    /**
     *
     * @return Attr Data Value
     */
    @Override
    public AttributeDataValue getAttributeDataValue()
    {
        return this.attributeDataValue;
    }	
}
