package com.tech.krival.Springbootjsonwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tech.krival.Springbootjsonwt.model.MemberEntity;

 
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
