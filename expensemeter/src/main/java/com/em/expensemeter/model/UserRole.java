package com.em.expensemeter.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;

@JsonAutoDetect
@Entity
@Table(name="user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="role_id")
	private String roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "userRoles")
	private Set<User> roleUsers = new HashSet<User>();

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleUsers
	 */
	public Set<User> getRoleUsers() {
		return roleUsers;
	}

	/**
	 * @param roleUsers the roleUsers to set
	 */
	public void setRoleUsers(Set<User> roleUsers) {
		this.roleUsers = roleUsers;
	}
	
}
