package com.w00k.rest.webservices.restwebservices.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping(value="/person/header", headers = "X-API-VERSION=1")
	public Personv1 headerV1() {
		return new Personv1("Bob Standfor");
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public Personv2 headerV2() {
		return new Personv2("Bob", "Standfor");
	}
	
	//in the Accept = application/vnd.company.app-v1+json
	@GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
	public Personv1 producesV1() {
		return new Personv1("Bob Standfor");
	}
	
	//in the Accept = application/vnd.company.app-v2+json
	@GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
	public Personv2 producesV2() {
		return new Personv2("Bob", "Standfor");
	}

}
