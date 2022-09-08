package com.firstcase.javabootcamp.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
@SQLDelete(sql = "UPDATE Comment SET deleted=true WHERE ID = ?")
@Where(clause = "deleted=false")
@Table(name = "comment_table")
@Entity
public class Comment extends BaseEntity {

	@Column(name = "comment", length = 500 ,nullable = false)
	private String comment;

	@Column(name = "commentDate" ,nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar commentDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

}
