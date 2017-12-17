package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.dto.RolePermissionDTO;
import com.condigence.medicare.model.Permission;
import com.condigence.medicare.repository.PermissionRepository;
import com.condigence.medicare.repository.RoleRepository;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
public class PermissionController {

	public static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/permission/all")
	public ResponseEntity<List<RolePermissionDTO>> listAllPermissions(HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		List<Permission> permissionList = (ArrayList<Permission>) permissionRepository.findAll();
		
		List<RolePermissionDTO> rolePermissionList = new ArrayList<RolePermissionDTO>();
		
		
		if (permissionList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		} else {

			for (Permission p : permissionList) {
				RolePermissionDTO dto = new RolePermissionDTO();
                dto.setId(p.getId());
                dto.setRoleName(roleRepository.findOne(p.getRoleId()).getRole());
                dto.setPermissionType(p.getPermissionType());
                rolePermissionList.add(dto);
			}
		}

		return new ResponseEntity<List<RolePermissionDTO>>(rolePermissionList, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/permissions")
	public ResponseEntity<?> createPermission(@RequestBody RolePermissionDTO rolePermissionDTO, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Role Permission : {}", rolePermissionDTO);
		
		//System.out.println("Creating Role Permission :"+ rolePermissionDTO);

//		if (StringUtils.isEmpty(rolePermissionDTO.getRoleName()) && roleRepository.findByRole(rolePermissionDTO.getRoleName()).getId() != 0) {
//			//logger.error("Unable to User. A User with name {} already	 exist", patient.getFirstName());
//			
//		/*	return new ResponseEntity(
//					new CustomErrorType("Unable to create. A Role with name " + rolePermissionDTO.getRoleName() + " already exist."),
//					HttpStatus.CONFLICT);*/
//		}
		Permission p = new Permission();
		p.setRoleId(roleRepository.findByRole(rolePermissionDTO.getRoleName()).getId());
		p.setPermissionType(rolePermissionDTO.getPermissionType());
		
		permissionRepository.save(p);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/api/addAppointment/{id}").buildAndExpand(patient.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
}
