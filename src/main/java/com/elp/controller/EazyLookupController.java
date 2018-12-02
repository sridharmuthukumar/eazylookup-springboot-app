package com.elp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elp.model.Person;
import com.elp.model.ResponseContainer;

@Controller
@RequestMapping("eazylookup")
public class EazyLookupController {

	private static Map<String, Person> byFirstName = new HashMap<String, Person>();
	private static Map<Long, Person> byId = new HashMap<Long, Person>();

	static {
		Person sundar = new Person();
		sundar.setId(1001l);
		sundar.setFirstName("Sundar");
		sundar.setLastName("Pichai");

		Person satya = new Person();
		satya.setId(1002l);
		satya.setFirstName("Satya");
		satya.setLastName("Nadella");

		byFirstName.put(sundar.getFirstName().toLowerCase(), sundar);
		byFirstName.put(satya.getFirstName().toLowerCase(), satya);

		byId.put(sundar.getId(), sundar);
		byId.put(satya.getId(), satya);
	}

	@GetMapping(value = "/findByFirstName")
	@ResponseBody
	public ResponseContainer findByFirstName(@RequestParam("firstName") String firstName) {
		ResponseContainer response = new ResponseContainer();
		Person person = byFirstName.get(firstName.toLowerCase());
		response.setPerson(person);
		if (person == null) {
			response.setMessage("Person not found!!!");
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseContainer findById(@PathVariable("id") long id) {
		ResponseContainer response = new ResponseContainer();
		Person person = byId.get(id);
		response.setPerson(person);
		if (person == null) {
			response.setMessage("Person not found!!!");
		}
		return response;
	}

}
