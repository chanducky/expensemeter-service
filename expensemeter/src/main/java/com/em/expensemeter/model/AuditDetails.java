package com.em.expensemeter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.em.expensemeter.config.JsonDateSerializer;

@Embeddable
public class AuditDetails {

	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="modify_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modify_by")
	private String modifyBy;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

		
}
