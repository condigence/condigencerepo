package com.condigence.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condigence.medicare.model.Permission;

@Repository("permissionRepository")
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	///Permission findByPermissionName(String permissionType);

}
