package com.tech.krival.Springbootjsonwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_MEMBERS")
public class MemberEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="name")
    private String name;
     
    @Column(name="age")
    private int age;
     
    @Column(name="email", nullable=false, length=200)
    private String email;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="company")
    private String company;
     
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	
     
    
 
    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", Name=" + name + 
                ", age=" + age + ", email=" + email  + ", phone=" + phone  + ", company=" + company  + "]";
    }

}
