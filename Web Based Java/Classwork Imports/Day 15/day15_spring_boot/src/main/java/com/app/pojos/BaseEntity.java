package com.app.pojos;

import javax.persistence.*;

@MappedSuperclass //to tell hibernate : no associated table BUT will be used as common super class for all
//other entities
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//later will contain private int version : will be used for optimistic locking
	
	public BaseEntity() {
		System.out.println("in base entity ctor");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
