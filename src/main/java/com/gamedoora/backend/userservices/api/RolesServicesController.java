package com.gamedoora.backend.userservices.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamedoora.backend.userservices.assembler.RolesServicesAssembler;
import com.gamedoora.model.dto.RoleDTO;
import com.gamedoora.backend.userservices.exceptions.NotFoundException;

import java.text.MessageFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/roles")
public class RolesServicesController extends BaseController {

	@Autowired
	RolesServicesAssembler rolesServicesAssembler;

	@PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces =  {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<RoleDTO> createRoles(@RequestBody RoleDTO rolesDto) {
		return createResponse(rolesServicesAssembler.createRoles(rolesDto), HttpStatus.CREATED);

	}

	@PutMapping(value = "/{id}" , consumes = {MediaType.APPLICATION_JSON_VALUE}, produces =  {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RoleDTO> updateRoles(@PathVariable("id") long id, @RequestBody RoleDTO rolesDto) {
		RoleDTO roleDTO = rolesServicesAssembler.updateRoles(id, rolesDto);
    if(null == roleDTO){
      throw new NotFoundException(MessageFormat.format("Role by id {0} not found", id)); 
    }
    return createResponse(roleDTO, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") long id) {
		 rolesServicesAssembler.deleteRoles(id);
     return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/")
	public ResponseEntity<HttpStatus> deleteAllRoles() {
		rolesServicesAssembler.deleteAllRoles();
    return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/", produces =  {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<RoleDTO>> getAllRoles(@RequestParam(required = false) String name) {
		return createResponse(rolesServicesAssembler.getAllRoles(name), HttpStatus.OK);
	}
}
