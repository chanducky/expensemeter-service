package com.em.expensemeter.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name = "exp_type")
public class ExpType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exp_type_id")
	private int expTypeId;

	@Column(name = "name")
	private String name;

	@Column(name = "enabled", columnDefinition = "tinyint")
	private int enabled;

	@OrderBy("expTypeDtlId")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "expType")
	Set<ExpTypeDtl> expTypedtls;

	@Embedded
	private AuditDetails auditDetails;

	/**
	 * @return the expTypeId
	 */
	public int getExpTypeId() {
		return expTypeId;
	}

	/**
	 * @param expTypeId the expTypeId to set
	 */
	public void setExpTypeId(int expTypeId) {
		this.expTypeId = expTypeId;
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
	 * @return the expTypedtls
	 */
	public Set<ExpTypeDtl> getExpTypedtls() {
		return expTypedtls;
	}

	/**
	 * @param expTypedtls the expTypedtls to set
	 */
	public void setExpTypedtls(Set<ExpTypeDtl> expTypedtls) {
		this.expTypedtls = expTypedtls;
	}

	/**
	 * @return the auditDetails
	 */
	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	/**
	 * @param auditDetails the auditDetails to set
	 */
	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}
	
}
