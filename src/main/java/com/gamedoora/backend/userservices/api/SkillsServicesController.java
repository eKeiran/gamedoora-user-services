package com.gamedoora.backend.userservices.api;

import java.text.MessageFormat;
import java.util.List;

import com.gamedoora.backend.userservices.exceptions.NotFoundException;
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

import com.gamedoora.backend.userservices.assembler.SkillsServicesAssembler;
import com.gamedoora.model.dto.SkillsDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/skills")
public class SkillsServicesController extends BaseController {

	@Autowired
	SkillsServicesAssembler skillsServicesAssembler;

	@PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces =  {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SkillsDTO> createSkills(@RequestBody SkillsDTO skillsDto) {
		return createResponse( skillsServicesAssembler.createSkills(skillsDto), HttpStatus.CREATED);

	}

	@PutMapping(value ="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces =  {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SkillsDTO> updateSkills(@PathVariable("id") long id, @RequestBody SkillsDTO skillsDto) {
		SkillsDTO result = skillsServicesAssembler.updateSkills(id, skillsDto);
		if(null == result){
			throw new NotFoundException(MessageFormat.format("Skill sby id {0} not found", id));
		}
		return createResponse(result, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteSkills(@PathVariable("id") long id) {
		skillsServicesAssembler.deleteSkills(id);
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

  @DeleteMapping("/")
  public ResponseEntity<HttpStatus> deleteAllSkills() {
		skillsServicesAssembler.deleteAllSkills();
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

  @GetMapping(
      value = "/",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<SkillsDTO>> getAllSkills(@RequestParam(required = false) String name) {
		return createResponse(skillsServicesAssembler.getAllSkills(name), HttpStatus.OK);
	}
}
