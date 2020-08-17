package com.dxctraining.ui;
import com.dxctraining.entities.*;
import com.dxctraining.service.*;
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
        Author author1 = new Author( "chinni");
        Author author2 = new Author("naveen");
        Author author3 = new Author("chotu");
        Book book1 = new Book("J1","java",250 ,author1);
        Book book2 = new Book("Jn2","c",380 ,author2);
        Book book3 = new Book("y3","hadoop",240 ,author3);
        area.addBook(book1);
        area.addBook(book2);
        area.addBook(book3);
        showAll();
    }
    private void  showAll() {
        List<Book> list=area.displayAll();
        for(Book books:list)
        {
            booksdisplay(books);
        }
    }
    private void booksdisplay(Book book) {
        System.out.println("books display");
        Author authorname=book.getAuthor();
        System.out.println(" author "+authorname.getName()+" book name "+authorname.getName()+ "book price "+book.getCost());
    }
}
