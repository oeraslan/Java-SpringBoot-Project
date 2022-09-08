package com.firstcase.javabootcamp.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstcase.javabootcamp.dao.ICommentDao;
import com.firstcase.javabootcamp.entities.Comment;

@Service
public class CommentServiceImpl implements ICommentService {

	private ICommentDao commentDal;

	@Autowired
	public CommentServiceImpl(ICommentDao commentDal) {
		this.commentDal = commentDal;
	}

	@Override
	@Transactional
	public List<Comment> getAll() {
		return this.commentDal.getAll();
	}

	@Override
	@Transactional
	public void add(Comment comment) {
		this.commentDal.add(comment);

	}

	@Override
	@Transactional
	public void update(Comment comment) {
		this.commentDal.update(comment);

	}

	@Override
	@Transactional
	public void delete(long id) {
		this.commentDal.delete(id);

	}

	@Override
	@Transactional
	public Comment getById(long id) {
		return this.commentDal.getById(id);

	}

	public List<Comment> getProductComments(long productId) {
		return this.commentDal.getProductComments(productId);
	}

	@Override
	public List<Comment> getcommentWithDate(long productID, Calendar start, Calendar finish) {
		 
		return this.commentDal.getcommentWithDate(productID, start, finish);
	}

	@Override
	public List<Comment> getUserComments(long userID) {
		return this.commentDal.getUserComments(userID);
	}

	@Override
	public List<Comment> getUserCommentsWithDate(long userID, Calendar start, Calendar finish) {
		return this.commentDal.getUserCommentsWithDate(userID,start,finish);
	}

}
