package com.dxctraining.ui;
import com.dxctraining.entities.*;
import com.dxctraining.service.*;
import com.dxctraining.exceptions.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LibraryUi {
	@Autowired
    private LibraryService area; 
    
    @PostConstruct
    private void run() {
    	try {
        Author author1 = new Author("1a", "chinni");
        Author author2 = new Author("2a","naveen");
        Author author3 = new Author("3a","chotu");
        Book book1 = new Book("J1","java",250 ,author1);
        Book book2 = new Book("Jn2","c",380 ,author2);
        Book book3 = new Book("y3","hadoop",240 ,author3);
        area.save(book1);
        area.save(book2);
        area.save(book3);
        String id1 = book1.getId();
        Book fetched1 = area.findBookbyId(id1);
        System.out.println("book id =" + fetched1.getId() + " book name" + fetched1.getName() + "book cost " + fetched1.getCost());
        Book fetched2 = area.findBookbyId(id1);
        System.out.println("book id =" + fetched2.getId() + " book name" + fetched2.getName() + "book cost " + fetched2.getCost());
        Book fetched3 = area.findBookbyId(id1);
        System.out.println("book id =" + fetched3.getId() + " book name" + fetched3.getName() + "book cost " + fetched3.getCost());

    }
    		catch (BookNotFoundException exp) {
    	          exp.printStackTrace();
    	      } 
    	}
}

