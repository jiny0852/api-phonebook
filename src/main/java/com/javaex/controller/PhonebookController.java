package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PersonVo;

//@Controller REST-API 규칙을 따랐다 따를려고 했다
@RestController
public class PhonebookController {
	
	
	@Autowired
	private PhonebookService phonebookService;
	
	
	
	/*
	@GetMapping ( value="/api/persons" )
	public List<PersonVo> getList() {
		
		System.out.println("PhonebookController.getList()");
		
		List<PersonVo> personList =  phonebookService.exeGetPersonList();
		
		return personList;
		
	}*/
	
	@GetMapping ( value="/api/persons" )
	public JsonResult getList() {
		
		System.out.println("PhonebookController.getList()");
		
		List<PersonVo> personList =  phonebookService.exeGetPersonList();
		
		return JsonResult.success(personList);
		
	}
	
	
	
	
	
	
	@PostMapping ( value="/api/persons" )
	public int addPerson(@RequestBody PersonVo personVo) {
		
		System.out.println("PhonebookController.addPerson()");
		
		System.out.println(personVo);
		
		int count = phonebookService.exeWritePerson(personVo);
		
		System.out.println("count: " + count);
		
		return count;
		
	}
	
	
	
	
	
	@DeleteMapping ( value="/api/persons/{no}" )
	public JsonResult deletePerson( @PathVariable(value="no") int no ) {
		
		System.out.println("PhonebookController.deletePerson()");
		
		System.out.println(no);
		
		int count = phonebookService.exePersonDelete(no);
		
		System.out.println("count : " + count);
		
		if ( count != 1 ) { //삭제 안됨
			return JsonResult.fail("해당 번호가 없습니다");
			
		} else {   //if ( count == 1 ) { //삭제됨
			return JsonResult.success(count);
		}
		
		
	}
	
	
	
	@GetMapping ( value="/api/persons/{no}" )
	public JsonResult getPerson( @PathVariable(value="no") int no ) {
		
		System.out.println("PhonebookController.getPerson()");
		
		Map<String, Object> personVo = phonebookService.exeGetPersonOne2(no);
		
		if ( personVo == null ) { 
			return JsonResult.fail("해당 번호가 없습니다");
			
		} else {   
			return JsonResult.success(personVo);
		}
		
	}
	
	
	
	
	@PutMapping ( "/api/persons/{no}" )
	public JsonResult updatePerson( @PathVariable(value="no") int no, 
									@RequestBody PersonVo personVo ) {
		
		System.out.println("PhonebookController.updatePerson()");
		
		System.out.println(personVo);
		System.out.println(no);
		
		int count = phonebookService.exePersonEdit(personVo);
		
		System.out.println("count: " + count);
		
		if ( count != 1 ) { //삭제 안됨
			return JsonResult.fail("수정할 데이터가 없습니다");
			
		} else {   //if ( count == 1 ) { //삭제됨
			return JsonResult.success(count);
		}
		
	}
	
	
	
	

}
