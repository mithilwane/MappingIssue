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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class representing ATTR_DATA_KSATRS table
 *
 * @author 502359246
 *
 */

@Entity
@Table(name = "ATTR_DATA_KSATRS")
public class AttributeDataKsatrText
        implements Serializable
{
    /**
     * generated id
     */
    private static final long  serialVersionUID = 1L;

    @Id
    @Column(name = "attr_data_value_id")
    private int                id;

    @Column(name = "ksatr_type_id")
    private int                type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "attr_data_value_id")
    private AttributeDataValue attributeDataValue;

    /**
     * Constructor
     */
    public AttributeDataKsatrText()
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
    public int getType()
    {
        return this.type;
    }

    /**
     * @return the attributeDataValues
     */
    public AttributeDataValue getAttributeDataValue()
    {
        return this.attributeDataValue;
    }

}
