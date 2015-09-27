package com.em.expensemeter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

@JsonAutoDetect
@Entity
@Table(name="exp_type_dtl")
public class ExpTypeDtl implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_type_dtl_id")
	private int expTypeDtlId;
	
	private String name;
	
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name="exp_img")
	private byte[] expImg;
	
	@Column(name="enabled", columnDefinition="tinyint")
	private int enabled;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="exp_type_id", nullable=false) 
	private ExpType expType;

	/**
	 * @return the expTypeDtlId
	 */
	public int getExpTypeDtlId() {
		return expTypeDtlId;
	}

	/**
	 * @param expTypeDtlId the expTypeDtlId to set
	 */
	public void setExpTypeDtlId(int expTypeDtlId) {
		this.expTypeDtlId = expTypeDtlId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the expImg
	 */
	public byte[] getExpImg() {
		return expImg;
	}

	/**
	 * @param expImg the expImg to set
	 */
	public void setExpImg(byte[] expImg) {
		this.expImg = expImg;
	}

	/**
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the expType
	 */
	public ExpType getExpType() {
		return expType;
	}

	/**
	 * @param expType the expType to set
	 */
	public void setExpType(ExpType expType) {
		this.expType = expType;
	}
	
}
