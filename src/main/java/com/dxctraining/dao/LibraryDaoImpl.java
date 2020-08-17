package com.dxctraining.dao;
import com.dxctraining.entities.*;
import com.dxctraining.exceptions.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public class LibraryDaoImpl implements LibraryDao {
	@PersistenceContext
	private EntityManager entityManager;

	 @Override
	    public Book findBookbyId(String id) {
	        Book book=entityManager.find(Book.class,id);
	        if(book==null)
	        {
	            throw new BookNotFoundException("Book not found");
	        }
	        return book;
	    }
	    public Book save(Book book) {
	        entityManager.persist(book);
	        return book;
	    }
	    public Book updateBookcost(Book book) {
	        book=entityManager.merge(book);
	       return book;
	    }
	    public void remove(String id) {
	        Book book=findBookbyId(id);
	        entityManager.remove(book);
	    }
	    public Book findBookByName(String bookName){
	        String jpaql="from book where name=:bookname";
	        Query query= entityManager.createQuery(jpaql);
	        query.setParameter("bookname",bookName);
	        List<Book>list=query.getResultList();
	        Book book=null;
	        if(!list.isEmpty()){
	           book=list.get(0);
	        }
	        return book;
	    }
}