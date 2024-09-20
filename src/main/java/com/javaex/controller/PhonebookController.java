package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {
	
	
	@Autowired
	private PhonebookService phonebookService;
	
	
	
	@ResponseBody
	@RequestMapping ( value="/api/persons", method=RequestMethod.GET )
	public List<PersonVo> getList() {
		
		System.out.println("PhonebookController.getList()");
		
		List<PersonVo> personList =  phonebookService.exeGetPersonList();
		
		return personList;
		
	}
	
	
	
	@ResponseBody
	@RequestMapping ( value="/api/persons", method=RequestMethod.POST )
	public int addPerson(@RequestBody PersonVo personVo) {
		
		System.out.println("PhonebookController.addPerson()");
		
		System.out.println(personVo);
		
		int count = phonebookService.exeWritePerson(personVo);
		
		System.out.println("count: " + count);
		
		return count;
		
	}
	
	
	@ResponseBody
	@RequestMapping ( value="/api/persons/{no}", method=RequestMethod.DELETE )
	public String deletePerson( @PathVariable(value="no") int no ) {
		
		System.out.println("PhonebookController.deletePerson()");
		
		System.out.println(no);
		
		int count = phonebookService.exePersonDelete(no);
		
		System.out.println("count : " + count);
		
		return "";
	}
	
	
	
	

}
