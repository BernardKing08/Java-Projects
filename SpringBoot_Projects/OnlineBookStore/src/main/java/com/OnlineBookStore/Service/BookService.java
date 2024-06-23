package com.OnlineBookStore.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.OnlineBookStore.Model.Book;

@Service
public class BookService {
	List<Book> Books = new ArrayList<>(List.of(new Book("1", "NightMare on elmStreet", "elmStreet.jfif", "Stephen King", "A horror movie about dreams"),
										 		new Book("2", "Kung fu panda", "kingfu-Panda.jfif", "DreamWorks", "A fighting panda"),
												new Book("3", "James Bond", "jamesBond.jfif", "Fighting kittens", "Old man can fight")));
	
	public List<Book> getAllBooks(){
		return Books;
	}
	
	public Book getBook(String id) {		
		for(Book b: Books) {
			if(b.getId().equals(id))
				return b;
		}
		
		return null;
	}
}
