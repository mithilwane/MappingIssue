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
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Class representing attr_data_resource_types table
 *
 * @author 50232808
 */

@Entity
@Table(name = "ATTR_DATA_RESOURCES")
@PrimaryKeyJoinColumn(name = "attr_data_value_id")
public class AttrDataResourceBasic extends AttributeDataValue
        implements Serializable
{
    /**
     * generated id
     */
    private static final long    serialVersionUID = 1700L;

    @Column(name = "attr_data_value_id", insertable = false, updatable = false)
    private int                  attrDataValueId;

    @OneToOne
    @JoinColumn(name = "attr_data_resource_type_id")
    private AttrDataResourceType attrDataResourceType;

    @Column(name = "part_number")
    private String               partNumber;

    @Column(name = "src")
    private String               source;

    /**
     * Constructor
     */
    public AttrDataResourceBasic()
    {

    }

    /**
     *
     * @return Attr Data Value Id
     */
    public int getAttrDataValueId()
    {
        return this.attrDataValueId;
    }

    /**
     *
     * @return Attr Data Resource Type
     */
    public AttrDataResourceType getAttrDataResourceType()
    {
        return this.attrDataResourceType;
    }

    /**
     *
     * @return Part Number
     */
    public String getPartNumber()
    {
        return this.partNumber;
    }

    /**
     *
     * @return Source
     */
    public String getSource()
    {
        return this.source;
    }
}
