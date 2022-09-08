package com.firstcase.javabootcamp.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firstcase.javabootcamp.entities.Comment;

@Repository
public class CommentDao implements ICommentDao {

	private EntityManager entityManager;

	@Autowired
	public CommentDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // Aspect oriented programming
	public List<Comment> getAll() {
		System.out.println("---------------------getdao");
		Session session = entityManager.unwrap(Session.class);
		List<Comment> comments = session.createQuery("from Comment", Comment.class).getResultList();
		return comments;
	}

	@Override
	public void add(Comment comment) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(comment);

	}

	@Override
	public void update(Comment comment) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(comment);

	}

	@Override
	public void delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		Comment delComment = session.get(Comment.class, id);
		delComment.setDeleted(true);
	}

	@Override
	public Comment getById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Comment comment = session.get(Comment.class, id);
		return comment;
	}

	@Override
	public List<Comment> getcommentWithDate(long productID, Calendar start, Calendar finish) {

		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Comment> tq = session.createQuery(
				"select c from Comment c Where c.product.id=:productID and c.commentDate between :startDate and :finishDate",
				Comment.class);
		tq.setParameter("startDate", start, TemporalType.DATE);
		tq.setParameter("finishDate", finish, TemporalType.DATE);
		tq.setParameter("productID", productID);
		List<Comment> comments = tq.getResultList();

		return comments;
	}

	@Override
	@Transactional // Aspect oriented programming
	public List<Comment> getProductComments(long productID) {
		Session session = entityManager.unwrap(Session.class);
		List<Comment> comments = session
				.createQuery("select c from Comment c Where c.product.id= :productID ", Comment.class)
				.setParameter("productID", productID).getResultList();
		return comments;
	}

	@Override
	@Transactional
	public List<Comment> getUserComments(long userID) {
		Session session = entityManager.unwrap(Session.class);
		List<Comment> comments = session
				.createQuery("select c from Comment c Where c.user.id= :userID ", Comment.class)
				.setParameter("userID", userID).getResultList();
		return comments;
	}

	@Override
	@Transactional
	public List<Comment> getUserCommentsWithDate(long userID, Calendar start, Calendar finish) {
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Comment> tq = session.createQuery(
				"select c from Comment c Where c.user.id=:userID and c.commentDate between :startDate and :finishDate",
				Comment.class);
		tq.setParameter("startDate", start, TemporalType.DATE);
		tq.setParameter("finishDate", finish, TemporalType.DATE);
		tq.setParameter("userID", userID);
		List<Comment> comments = tq.getResultList();

		return comments;
	}
	


}
