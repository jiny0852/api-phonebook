package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

//@Controller REST-API 규칙을 따랐다 따를려고 했다
@RestController
public class PhonebookController {
	
	
	@Autowired
	private PhonebookService phonebookService;
	
	
	
	//@ResponseBody
	//@RequestMapping ( value="/api/persons", method=RequestMethod.GET )
	@GetMapping ( value="/api/persons" )
	public List<PersonVo> getList() {
		
		System.out.println("PhonebookController.getList()");
		
		List<PersonVo> personList =  phonebookService.exeGetPersonList();
		
		return personList;
		
	}
	
	
	
	//@ResponseBody
	//@RequestMapping ( value="/api/persons", method=RequestMethod.POST )
	@PostMapping ( value="/api/persons" )
	public int addPerson(@RequestBody PersonVo personVo) {
		
		System.out.println("PhonebookController.addPerson()");
		
		System.out.println(personVo);
		
		int count = phonebookService.exeWritePerson(personVo);
		
		System.out.println("count: " + count);
		
		return count;
		
	}
	
	
	//@ResponseBody
	//@RequestMapping ( value="/api/persons/{no}", method=RequestMethod.DELETE )
	@DeleteMapping ( value="/api/persons/{no}" )
	public int deletePerson( @PathVariable(value="no") int no ) {
		
		System.out.println("PhonebookController.deletePerson()");
		
		System.out.println(no);
		
		int count = phonebookService.exePersonDelete(no);
		
		System.out.println("count : " + count);
		
		return count;
	}
	
	
	
	

}
