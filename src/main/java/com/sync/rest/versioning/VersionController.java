package com.sync.rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	// URI Versioning
	// Hit:- http://localhost:8081/SpringBootRest/person/v1
	// Hit:- http://localhost:8081/SpringBootRest/person/v2
	@GetMapping("/person/v1")
	public PersonV1 person1() {
		return new PersonV1("Rafael Nadal");
	}

	@GetMapping("/person/v2")
	public PersonV2 person2() {
		return new PersonV2(new Name("Roger", "Federer"));
	}

	// Parameter versioning
	// Hit:- http://localhost:8081/SpringBootRest/person/param?version=v1
	// Hit:- http://localhost:8081/SpringBootRest/person/param?version=v2
	@GetMapping(value = "/person/param", params = "version=v1")
	public PersonV1 personParam1() {
		return new PersonV1("Rafael Nadal");
	}

	@GetMapping(value = "/person/param", params = "version=v2")
	public PersonV2 personParam2() {
		return new PersonV2(new Name("Roger", "Federer"));
	}

	// Header versioning
	// Hit:- http://localhost:8081/SpringBootRest/person/header
	// Add header key/value as versionHeader / v1 or v2
	@GetMapping(value = "/person/header", headers = "versionHeader=v1")
	public PersonV1 personHeader1() {
		return new PersonV1("Rafael Nadal");
	}

	@GetMapping(value = "/person/header", headers = "versionHeader=v2")
	public PersonV2 personHeader2() {
		return new PersonV2(new Name("Roger", "Federer"));
	}

	// Mime Type versioning / Accept Header versioning
	// Hit:- http://localhost:8081/SpringBootRest/person/produces
	// Add header "Accept" with value "application/version-v1+json" or "application/version-v2+json"
	@GetMapping(value = "/person/produces", produces = "application/version-v1+json")
	public PersonV1 personProduces1() {
		return new PersonV1("Rafael Nadal");
	}

	@GetMapping(value = "/person/produces", produces = "application/version-v2+json")
	public PersonV2 personProduces2() {
		return new PersonV2(new Name("Roger", "Federer"));
	}

}
