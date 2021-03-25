package com.tech.krival.Springbootjsonwt.service;

import com.tech.krival.Springbootjsonwt.exception.RecordNotFoundException;
import com.tech.krival.Springbootjsonwt.model.MemberEntity;
import com.tech.krival.Springbootjsonwt.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
    MemberRepository repository;
     
    public List<MemberEntity> getAllMembers()
    {
        List<MemberEntity> memberList = repository.findAll();
         
        if(memberList.size() > 0) {
            return memberList;
        } else {
            return new ArrayList<MemberEntity>();
        }
    }
     
    public MemberEntity getMemberById(int id) throws RecordNotFoundException 
    {
        Optional<MemberEntity> member = repository.findById(id);
         
        if(member.isPresent()) {
            return member.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public MemberEntity createOrUpdateMember(MemberEntity entity) throws RecordNotFoundException 
    {
        Optional<MemberEntity> member = repository.findById(entity.getId());
         
        if(member.isPresent()) 
        {
            MemberEntity newEntity = member.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setPhone(entity.getPhone());
            newEntity.setName(entity.getName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteMemberById(int id) throws RecordNotFoundException 
    {
        Optional<MemberEntity> member = repository.findById(id);
         
        if(member.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

	public MemberEntity saveMember(MemberEntity memberEntity) {
		Optional<MemberEntity> member = repository.findById(memberEntity.getId());
        
        if(member.isPresent()) 
        {
        	memberEntity = repository.save(memberEntity);
        }
		return memberEntity;
	} 

}
