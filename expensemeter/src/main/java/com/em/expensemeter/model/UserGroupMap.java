package com.em.expensemeter.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user_group_map")
public class UserGroupMap {

	@Id
	@Column(name="group_id")
	private BigInteger groupId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="enabled")
	private int enabled;

	public BigInteger getGroupId() {
		return groupId;
	}

	public void setGroupId(BigInteger groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
}
