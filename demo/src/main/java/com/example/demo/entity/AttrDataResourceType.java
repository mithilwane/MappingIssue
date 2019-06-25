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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class representing attr_data_resource_types table
 *
 * @author 50232808
 */

@Entity
@Table(name = "ATTR_DATA_RESOURCE_TYPES")
public class AttrDataResourceType
        implements Serializable
{
    /**
     * generated id
     */
    private static final long serialVersionUID  = 1400L;

    /** Calibration attributes */
    public static final int   CALIBRATION       = 1;

    /** Equipment attributes */
    public static final int   EQUIPMENT         = 2;

    /** Hand Tools attributes */
    public static final int   HAND_TOOLS        = 3;

    /** IMI attributes */
    public static final int   IMI               = 4;

    /** Publications attributes */
    public static final int   PUBLICATIONS      = 5;

    /** Software attributes */
    public static final int   SOFTWARE          = 6;

    /** Special Tools attributes */
    public static final int   SPECIAL_TOOLS     = 7;

    /** Test Equipment attributes */
    public static final int   TEST_EQUIPMENT    = 8;

    /** Trainer Materials attributes */
    public static final int   TRAINER_MATERIALS = 9;

    /** Training Device attributes */
    public static final int   TRAINING_DEVICE   = 10;

    /** Computers resource type **/
    public static final int   COMPUTERS         = 11;

    /** Consumables resource type **/
    public static final int   CONSUMABLES       = 12;

    /** Films resource type **/
    public static final int   FILMS             = 13;

    /** Task-Source resource type **/
    public static final int   TASK_SOURCE       = 14;

    /** Training equip resource types **/
    public static final int   TRAINING_EQUIP    = 15;

    @Id
    @GeneratedValue(generator = "attr_data_res_type_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "attr_data_res_type_seq", sequenceName = "attr_data_resource_types_seq",
            allocationSize = 1)
    @Column(name = "attr_data_resource_type_id", nullable = false)
    private int               id;

    @Column(name = "name")
    private String            name;

    /**
     * Constructor
     */
    public AttrDataResourceType()
    {

    }

    /**
     * 
     * Constructor
     * 
     * @param id resource type id
     * @param name resource type name
     */
    public AttrDataResourceType(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return the primary key
     */
    public int getId()
    {
        return this.id;
    }

    /**
     *
     * @return text representing this type
     */
    public String getName()
    {
        return this.name;
    }
}
