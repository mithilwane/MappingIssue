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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class representing attr_data_values table
 *
 * @author 50232808
 */
@Entity
@Table(name = "ATTR_DATA_VALUES")
@Inheritance(strategy = InheritanceType.JOINED)
public class AttributeDataValue
        implements Serializable
{
    /**
     * generated id
     */
    private static final long  serialVersionUID           = 8001L;

    /**
     * Ref field for task level
     */
    public static final String REF_TASK_LEVEL             = "taskLevel";       //$NON-NLS-1$

    /**
     * Ref field for estimated time to complete
     */
    public static final String REF_EST_TIME_COMPLETE      = "timeToAccomplish"; //$NON-NLS-1$

    /**
     * Constant to representing non deprecated state
     */
    public static final char   NOT_DEPRECATED             = '0';

    /**
     * Constant representing deprecated state
     */
    public static final char   DEPRECATED                 = '1';

    /**
     * Constant to representing non LUT
     */
    public static final int    NON_LUT                    = 0;

    /**
     * Constant representing LUT
     */
    public static final int    IS_LUT                     = 1;

    /**
     * constant used to indicate a new item reason code
     */
    public static final String NEW_ITEM_REASON_CODE       = "New Entry";       //$NON-NLS-1$

    /**
     * constant used to indicate a deleted item reason code
     */
    public static final String DELETE_ITEM_REASON_CODE    = "Delete Entry";    //$NON-NLS-1$

    /**
     * constant used to indicate a move item reason code
     */
    public static final String MOVE_ITEM_REASON_CODE      = "Move Entry";      //$NON-NLS-1$

    /**
     * constant used to indicate an edit reason code (default)
     */
    public static final String EDIT_REASON_CODE           = "Edit";            //$NON-NLS-1$

    /**
     * constant used to indicate an un-approve item reason code
     */
    public static final String UNAPPROVE_ITEM_REASON_CODE = "Un-Approve Entry";      //$NON-NLS-1$

    /**
     * constant to indicate future update is not allowed
     */
    public static final int IGNORE_FUTURE_UPDATE = 1;      //$NON-NLS-1$
    
    /**
     * constant to indicate future update is allowed
     */
    public static final int ALLOW_FUTURE_UPDATE = 0;      //$NON-NLS-1$
    
    /**
     * constant to indicate user action is pending on OSH imported data
     */
    public static final String OSH_IMPORT_USER_ACTION_PENDING="-1";
    
    /**
     * constant to indicate user action is pending on OSH imported data
     */
    public static final String OSH_IMPORT_USER_ACTION_DONE="-2";
    
    /**
     * constant to indicate user action is pending on OSH imported data
     */
    public static final String OSH_IMPORT_USER_ACTION_REJECT="3";
    
    public static final int OSH_IMPORT_USER_ACTION_REJECT_VAL =3;
    
    public static final String OSH_IMPORT_USER_ACTION_MOVEREJECT_VAL = "-3";
    

    

    @Id
    @GeneratedValue(generator = "attr_data_value_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "attr_data_value_seq", sequenceName = "adv_seq1", allocationSize = 1)
    @Column(name = "attr_data_value_id", nullable = false)
    private int                id;

    @Column(name = "attr_data_type_id")
    private int                attributeDataTypeId;

    @OneToOne
    @JoinColumn(name = "attr_data_type_id", insertable = false, updatable = false)
    private AttributeDataType  attributeDataType;

    @Column(name = "val")
    private String             val;

    @Column(name = "date_mod")
    private Date               dateModified;

    @Column(name = "deprecated", insertable = false)
    private String             deprecated;

    @Column(name = "seq", insertable = false, updatable = false)
    private int                sequence;

    @Column(name = "parent_id", nullable = true)
    private Integer            parentId;

    @Column(name = "ref_field")
    private String             refField;

    @Column(name = "weight")
    private int                weight;

    @Column(name = "external_id")
    private String             externalId;

    @Column(name = "is_lut")
    private Integer            isLut;

    @Column(name = "is_non_standard")
    private Integer            isNonStandard;
    
    @Column(name = "allow_future_update")
    private Integer            futureUpdate;

    @Column(name = "cdp_val")
    private String             cdp_val;
    
    /**
     * Constructor
     */
    public AttributeDataValue()
    {

    }

    /**
     * 
     * Copy Constructor
     * 
     * @param src instance to copy
     */
    public AttributeDataValue(AttributeDataValue src)
    {
        this.id = src.getId();
        this.attributeDataTypeId = src.getAttributeDataTypeId();

        this.val = src.getValue();

        this.dateModified = src.getModifiedDate();
        this.deprecated = src.getDeprecated();
        this.sequence = src.getSequence();
        this.parentId = src.getParentId();
        this.refField = src.getRefField();
        this.weight = src.getWeight();
        this.externalId = src.getExternalId();
        this.isLut = src.getIsLut();
        this.isNonStandard = src.getIsNonStandard();
        this.futureUpdate = src.getFutureUpdate();
        this.cdp_val = src.getCdp_val();
        // these two fields run into issues with OphImportManager.toExtIdAttrDataValueMap()
        // this.attributeDataType = src.getAttributeDataType();
        // this.modUser = src.getModifiedBy();
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
     * @param id new id val
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     *
     * @return the Attribute Data Type id
     */
    public int getAttributeDataTypeId()
    {
        return this.attributeDataTypeId;
    }

    /**
     *
     * @param attributeDataTypeId the new attr data type
     */
    public void setAttributeDataTypeId(int attributeDataTypeId)
    {
        this.attributeDataTypeId = attributeDataTypeId;
    }

    /**
     *
     * @return the associated attributeDataType record
     */
    public AttributeDataType getAttributeDataType()
    {
        return this.attributeDataType;
    }

    /**
     * @return the value for this item
     */
    public String getValue()
    {
        return this.val;
    }

    /**
     * @param newVal new val
     */
    public void setValue(String newVal)
    {
        this.val = newVal;
    }

    /**
     *
     * @return the modified date
     */
    public Date getModifiedDate()
    {
        return this.dateModified;
    }

    /**
     * Set the modified date to current time
     */
    public void setModifiedDate()
    {
        this.dateModified = new Date();
    }

    /**
     * @return the deprecation status
     */
    public String getDeprecated()
    {
        return this.deprecated;
    }

    /**
     *
     * @return the sequence of this attribute
     */
    public int getSequence()
    {
        return this.sequence;
    }

    /**
     *
     * @return the parent id of this attribute
     */
    public Integer getParentId()
    {
        return this.parentId;
    }

    /**
     * @param parentId the new parent id
     */
    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    /**
     *
     * @return the ref field of this attribute
     */
    public String getRefField()
    {
        return this.refField;
    }

    /**
     *
     * @return the weight for this item
     */
    public int getWeight()
    {
        return this.weight;
    }

    /**
     *
     * @param weight new weight val
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    /**
     * @return the externalId
     */
    public String getExternalId()
    {
        return this.externalId;
    }

    /**
     * @param externalId the externalId to set
     */
    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    /**
     * 
     * @return is this data sourced from the LUT
     */
    public boolean isLut()
    {
        return this.isLut == 1;
    }

    /**
     * @return the isLut
     */
    public Integer getIsLut()
    {
        return this.isLut;
    }

    /**
     * @param isLut the isLut to set
     */
    public void setIsLut(Integer isLut)
    {
        this.isLut = isLut;
    }

    /**
     * 
     * @return is non standard
     */
    public boolean isNonStandard()
    {
        return this.isNonStandard == 1;
    }

    /**
     * 
     * @return is non standard
     */
    public Integer getIsNonStandard()
    {
        return this.isNonStandard;
    }

    /**
     * 
     * @param isNonStandard is non standard
     */
    public void setIsNonStandard(Integer isNonStandard)
    {
        this.isNonStandard = isNonStandard;
    }

    /**
     * 
     * @param isNonStandard is non standard
     */
    public void setIsNonStandard(boolean isNonStandard)
    {
        this.isNonStandard = (isNonStandard) ? 1 : 0;
    }

    /**
     * 
     * @param deprecated the new deprecated state
     */
    public void setDeprecated(boolean deprecated)
    {
        if ( deprecated )
        {
            this.deprecated = String.valueOf(AttributeDataValue.DEPRECATED);
        }
        else
        {
            this.deprecated = String.valueOf(AttributeDataValue.NOT_DEPRECATED);
        }
    }

    /**
     * 
     * @param deprecated the new deprecated state
     */
    public void setDeprecated(String deprecated)
    {
        if ( deprecated.equals(String.valueOf(AttributeDataValue.DEPRECATED))
                || deprecated.equals(String.valueOf(AttributeDataValue.NOT_DEPRECATED)) )
        {
            this.deprecated = deprecated;
        }
        else
        {
        }
    }

    /**
     * @return if the attribute is deprecated
     */
    public boolean isDeprecated()
    {
        return (this.deprecated != null && !this.deprecated.isEmpty() && this.deprecated.charAt(0) == AttributeDataValue.DEPRECATED);
    }

    @Override
    public boolean equals(Object obj)
    {
        return (obj instanceof AttributeDataValue && ((AttributeDataValue) obj).getId() == this.getId());
    }

    @Override
    public int hashCode()
    {
        return this.getId();
    }

	public Integer getFutureUpdate() {
		return futureUpdate;
	}

	public void setFutureUpdate(Integer futureUpdate) {
		this.futureUpdate = futureUpdate;
	}

	/**
	 * @return the cdp_val
	 */
	public String getCdp_val() {
		return this.cdp_val;
	}

	/**
	 * @param cdp_val the cdp_val to set
	 */
	public void setCdp_val(String cdp_val) {
		this.cdp_val = cdp_val;
	}
    
    
}
