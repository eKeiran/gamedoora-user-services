package com.gamedoora.backend.userservices.api;

import com.gamedoora.backend.userservices.assembler.SourcesServicesAssembler;
import com.gamedoora.model.dto.SourceDTO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sources")
public class SourcesServicesController extends BaseController {

	@Autowired
	SourcesServicesAssembler sourcesServicesAssembler;

  @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces =  {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SourceDTO> createSources(@RequestBody SourceDTO sourcesDto) {
    return createResponse(sourcesServicesAssembler.createSources(sourcesDto), HttpStatus.CREATED);
	}

  @PutMapping(value="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces =  {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SourceDTO> updateSources(
      @PathVariable("id") long id, @RequestBody SourceDTO sourceDTO) {
    return createResponse(sourcesServicesAssembler.updateSources(id, sourceDTO), HttpStatus.OK);
	}

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<HttpStatus> deleteSources(@PathVariable("id") long id) {
    sourcesServicesAssembler.deleteSources(id);
    return createResponse(null, HttpStatus.NO_CONTENT);
	}

  @DeleteMapping(value = "/")
  public ResponseEntity<HttpStatus> deleteAllSources() {
    sourcesServicesAssembler.deleteAllSources();
    return createResponse(null, HttpStatus.NO_CONTENT);
	}

  @GetMapping(
      value = "/",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<SourceDTO>> getAllSources(@RequestParam(required = false) String name) {
    return createResponse(sourcesServicesAssembler.getAllSources(name), HttpStatus.OK);
	}
}
