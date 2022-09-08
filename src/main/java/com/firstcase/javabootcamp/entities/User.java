package com.firstcase.javabootcamp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SQLDelete(sql = "UPDATE User SET deleted=true WHERE ID = ?")
@Where(clause = "deleted=false")
@Table(name = "user_table")
@Entity
public class User  extends BaseEntity{
  
	@Column(name = "name", length = 50 ,nullable = false)
	private String Name;

	@Column(name = "surname", length = 50 ,nullable = false)
	private String Surname;

	@Column(name = "email", length = 50 ,nullable = false)
	private String email;

	@Column(name = "phone", length = 15 ,nullable = false)
	private String phone;
	
	
}
