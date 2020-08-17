package com.dxctraining.service;
import com.dxctraining.dao.*;
import com.dxctraining.entities.*;
import com.dxctraining.exceptions.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
		private LibraryDao dao;
		public List<Book> displayAll() {
		       List<Book>list=dao.displayAll();
		       return list;
		    }
		 public Book findBookbyId(String id) {
		       checkbookId(id);
		        Book books=dao.findBookbyId(id);
		        return books;
		    }
		 private void checkbookId(String id) {
		        if(id==null || id.isEmpty())
		        {
		            throw new InvalidArgumentException("null or empty id");
		        }
		    }
		 public Book updateBookcost(String id, double cost) {
		        checkbookId(id);
		        checkbookCost(cost);
		        Book books=dao.updateBookcost(id,cost);
		        return books;
		    }

		    private void checkbookCost(double cost) {
		        if(cost==0|| cost<0)
		        {
		            throw new InvalidBookCostException("invalid cost");
		        }
		    }
		    public void removeBook(String id) {
		        checkbookId(id);
		        dao.removeBook(id);

		    }

		    @Override
		    public void addBook(Book book) {
		        dao.addBook(book);
		    }
		    
		}
