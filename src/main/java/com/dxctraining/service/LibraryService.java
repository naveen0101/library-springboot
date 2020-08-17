package com.dxctraining.service;
import com.dxctraining.entities.Book;
import java.util.*;
public interface LibraryService {
	Book findBookbyId(String id);
	Book findBookByName(String bookName);
	Book save(Book book);
	Book updateBookcost(Book book);
	void remove(String id);
	

}
