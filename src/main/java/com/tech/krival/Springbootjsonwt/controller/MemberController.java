package com.tech.krival.Springbootjsonwt.controller;

import com.tech.krival.Springbootjsonwt.exception.RecordNotFoundException;
import com.tech.krival.Springbootjsonwt.model.MemberEntity;
import com.tech.krival.Springbootjsonwt.service.MemberService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
@RequestMapping("/api/v1")

public class MemberController {
	@Autowired
    MemberService service;
	
	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String getEmployees() {
        return "Welcome!";
    }
	
	
    @GetMapping("/members")
    public ResponseEntity<List<MemberEntity>> getAllMembers() {
        List<MemberEntity> list = service.getAllMembers();
 
        return new ResponseEntity<List<MemberEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberEntity> getMemberById(@PathVariable("id") int id) 
                                                    throws RecordNotFoundException {
        MemberEntity entity = service.getMemberById(id);
 
        return new ResponseEntity<MemberEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping("/members")
    public ResponseEntity<MemberEntity> createOrUpdatemember(@RequestBody MemberEntity members)
                                                    throws RecordNotFoundException {
    	System.out.println(members);
        MemberEntity updated = service.createOrUpdateMember(members);
        return new ResponseEntity<MemberEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping("/members/{id}")
    public ResponseEntity<MemberEntity> updateEmployee(@PathVariable(value = "id")int id,
       @RequestBody MemberEntity MemberDetails) throws RecordNotFoundException {
    	MemberEntity member = service.getMemberById(id);
     

    	member.setEmail(MemberDetails.getEmail());
    	member.setAge(MemberDetails.getAge());
    	member.setName(MemberDetails.getName());
    	member.setPhone(MemberDetails.getPhone());
    	member.setCompany(MemberDetails.getCompany());
        final MemberEntity updatedEmployee = service.saveMember(member);
       return ResponseEntity.ok(updatedEmployee);
    }
 
    @DeleteMapping("/members/{id}")
    public HttpStatus deleteMemberById(@PathVariable("id") int id) 
                                                    throws RecordNotFoundException {
        service.deleteMemberById(id);
        return HttpStatus.FORBIDDEN;
    }

}
