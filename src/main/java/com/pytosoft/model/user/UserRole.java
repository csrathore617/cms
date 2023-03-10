package com.pytosoft.model.user;

import java.io.Serializable;


import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
@FetchProfile(name = "fp_userRole_role", fetchOverrides = { @FetchProfile.FetchOverride(entity = UserRole.class, association = "role", mode = FetchMode.JOIN) })
public class UserRole implements Serializable
{
	private static final long serialVersionUID = -4831446844386411726L;

	public static final String FP_USER_ROLE_ROLE = "fp_userRole_role";

	public static final String APP_USER = "appUser";

	public static final String ROLE = "role";

	private Long id;
//
//	private AppUser appUser;

	private Role role;

	public UserRole()
	{

	}

	public UserRole(Role role)
	{
		super();
		this.role = role;
	}

//	@ManyToOne(optional = false, fetch = FetchType.LAZY)
//	@JoinColumn(name = "App_User_Id", referencedColumnName = "Id")
//	public AppUser getAppUser()
//	{
//		return appUser;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public Long getId()
	{
		return id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "Role_Id", referencedColumnName = "Id")
	public Role getRole()
	{
		return role;
	}
//
//	public void setAppUser(AppUser appUser)
//	{
//		this.appUser = appUser;
//	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

}
