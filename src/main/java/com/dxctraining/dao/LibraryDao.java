package com.dxctraining.dao;
import com.dxctraining.entities.Book;
import java.util.*;
public interface LibraryDao {
	Book findBookbyId(String id);
	Book findBookByName(String bookName);
	Book save(Book book);
	Book updateBookcost(Book book);
	void remove(String id);

}
