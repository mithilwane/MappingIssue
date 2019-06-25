/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.example.demo.entity.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class representing KSATR_TYPES table
 *
 * @author 502359246
 *
 */

@Entity
@Table(name = "KSATR_TYPES")
public class KsatrType
        implements Serializable
{
    /**
     * generated id
     */
    private static final long                 serialVersionUID = 1L;

    /** K in Ksatr **/
    public static final int                   KNOWLEDGE        = 1;

    /** S in Ksatr **/
    public static final int                   SKILLS           = 2;

    /** A in Ksatr **/
    public static final int                   ABILITIES        = 3;

    /** T in Ksatr **/
    public static final int                   TOOLS            = 4;

    /** R in Ksatr **/
    public static final int                   RESOURCES        = 5;

    /** Mapping of Ksatr Id and Type **/
    private static final Map<String, Integer> idTypeMap;
    static
    {
        Map<String, Integer> aMap = new HashMap<String, Integer>();

        aMap.put("Knowledge", Integer.valueOf(KNOWLEDGE)); //$NON-NLS-1$
        aMap.put("Skills", Integer.valueOf(SKILLS)); //$NON-NLS-1$
        aMap.put("Abilities", Integer.valueOf(ABILITIES)); //$NON-NLS-1$
        aMap.put("Tools", Integer.valueOf(TOOLS)); //$NON-NLS-1$
        aMap.put("Resources", Integer.valueOf(RESOURCES)); //$NON-NLS-1$

        idTypeMap = Collections.unmodifiableMap(aMap);
    }

    @Id
    @GeneratedValue(generator = "ksatr_type_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ksatr_type_seq", sequenceName = "ksatr_types_seq", allocationSize = 1)
    @Column(name = "ksatr_type_id", nullable = false)
    private int                               id;

    @Column(name = "name")
    private String                            name;

    /**
     * Constructor
     */
    public KsatrType()
    {

    }

    /**
     *
     * @return the primary key
     */
    public final int getId()
    {
        return this.id;
    }

    /**
     *
     * @return text representing this type
     */
    public final String getName()
    {
        return this.name;
    }

    /**
     * Get the id associated to a given Ksatr type.
     *
     * @param type Ksatr type
     * @return Ksatr Id based on type
     */
    public static int getIdByType(String type)
    {
        return idTypeMap.get(type).intValue();
    }
}
