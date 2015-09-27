package com.em.expensemeter.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;

@JsonAutoDetect
@Entity
@Table(name="user_group")
public class UserGroup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id", columnDefinition="bigint")
	private BigInteger groupId;

	private String name;

	private String description;

	@Column(name="enabled" , columnDefinition="tinyint" )
	private int enabled;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "userGroups")
	private Set<User> groupUsers = new HashSet<User>();

	@JsonIgnore
	@Embedded
	private AuditDetails auditDetails;

	/**
	 * @return the groupId
	 */
	public BigInteger getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(BigInteger groupId) {
		this.groupId = groupId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the groupUsers
	 */
	public Set<User> getGroupUsers() {
		return groupUsers;
	}

	/**
	 * @param groupUsers the groupUsers to set
	 */
	public void setGroupUsers(Set<User> groupUsers) {
		this.groupUsers = groupUsers;
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
