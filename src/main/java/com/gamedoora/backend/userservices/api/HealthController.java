package com.gamedoora.backend.userservices.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController extends BaseController {

	@GetMapping(value = "/health",produces =  {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<String> provideHealthStatus() {
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}