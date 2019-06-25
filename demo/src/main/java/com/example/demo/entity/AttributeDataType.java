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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class representing attribute_data_types table
 *
 * @author 50232808
 */

@Entity
@Table(name = "ATTR_DATA_TYPES")
public class AttributeDataType
        implements Serializable
{
    /**
     * generated id
     */
    private static final long serialVersionUID  = 1300L;

    /** Verb attributes */
    public static final int   VERBS             = 1;

    /** Resource attributes */
    public static final int   RESOURCES         = 2;

    /** TTA Parent attributes */
    public static final int   TTA_PARENT        = 3;

    /** Publication attributes */
    public static final int   PUBLICATIONS      = 4;

    /** KSATR attributes */
    public static final int   KSATRS            = 5;

    /** TTA Options attributes */
    public static final int   TTA_OPTIONS       = 6;

    /** Component attributes */
    public static final int   COMPONENTS        = 7;

    /** Condition attributes */
    public static final int   CONDITIONS        = 8;

    /** Environmet attributes */
    public static final int   ENVIRONMENTS      = 9;

    /** Non-equipment attributes */
    public static final int   NON_EQUIPMENT     = 10;

    /** Platforms attributes */
    public static final int   PLATFORMS         = 11;

    /** Standards attributes */
    public static final int   STANDARDS         = 12;

    /** Sub-system attributes */
    public static final int   SUBSYSTEMS        = 13;

    /** Systems attributes */
    public static final int   SYSTEMS           = 14;

    /** Tools attributes */
    public static final int   TOOLS             = 15;

    /** Training Types attributes */
    public static final int   TYPES_OF_TRAINING = 16;

    /** Intervention Types attributes */
    public static final int   INTERVENTIONS     = 17;

    /** OPH codes **/
    public static final int   OPH               = 18;

    /** Reason codes **/
    public static final int   REASON_CODES      = 19;

    /** Regions **/
    public static final int   REGIONS           = 20;

    /** Planned Maintenance */
    public static final int   PLANNED_MAINT     = 21;

    /** Jobs */
    public static final int   JOBS              = 23;

    /** Duties */
    public static final int   DUTIES            = 24;

    /** Content types */
    public static final int   CONTENT_TYPES     = 25;

    /** Cognitive levels */
    public static final int   COGNITIVE_LEVELS  = 26;
	
    /** Classification */
    public static final int   CLASSIFICATION  = 27;
    
    /** Company */
    public static final int   COMPANY  = 28;
    
    /** Country */
    public static final int   COUNTRY  = 29;
    
    /** Regions : Used for User Management SIMS-AUTH**/
    public static final int   REGION   = 30;

    @Id
    @GeneratedValue(generator = "attr_data_type_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "attr_data_type_seq", sequenceName = "adt_seq1", allocationSize = 1)
    @Column(name = "attr_data_type_id", nullable = false)
    private int               id;

    @Column(name = "name")
    private String            name;

    /**
     * Constructor
     */
    public AttributeDataType()
    {

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

    /**
     * Make a camel case title into title case, e.g: ReasonCodes => Reason Codes
     * 
     * @param name camel case name
     * @return title case name
     */
    public static String makeAlternateName(String name)
    {
        String altName = ""; //$NON-NLS-1$
        for (int i = 0; i < name.length(); i++)
        {
            if ( Character.isUpperCase(name.charAt(i)) )
            {
                altName += " "; //$NON-NLS-1$
            }

            altName += name.charAt(i);
        }

        return altName.trim();
    }

    /**
     * @return a list of object attribute data type ids
     */
    public static List<Long> getObjectTypeIds()
    {
        List<Long> objTypeIds = new ArrayList<Long>();
        objTypeIds.add((long) AttributeDataType.COMPONENTS);
        objTypeIds.add((long) AttributeDataType.SUBSYSTEMS);
        objTypeIds.add((long) AttributeDataType.NON_EQUIPMENT);
        objTypeIds.add((long) AttributeDataType.ENVIRONMENTS);
        objTypeIds.add((long) AttributeDataType.TOOLS);

        return objTypeIds;
    }

}
