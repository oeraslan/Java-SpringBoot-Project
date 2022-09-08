package com.firstcase.javabootcamp.entities;



import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "product_table")
@SQLDelete(sql = "UPDATE Product SET deleted=true WHERE ID = ?")
@Where(clause = "deleted=false")
@Entity
public class Product extends BaseEntity{
 
	
	
	@Column(name = "name",nullable = false)
	private String productName;

	@Column(name = "price",nullable = false)
	private float price;

	@Column(name = "expireDate", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar expireDate;

}
