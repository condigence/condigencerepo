package com.condigence.medicare.dto;

public class RolePermissionDTO {

	private int id;

	private String roleName;

	private String permissionType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	@Override
	public String toString() {
		return "RolePermissionDTO [id=" + id + ", roleName=" + roleName + ", permissionType=" + permissionType + "]";
	}
	
	

}
