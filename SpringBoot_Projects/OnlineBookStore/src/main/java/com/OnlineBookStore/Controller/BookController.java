package com.OnlineBookStore.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Service.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    //@Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping(value = {"/books", "/home"})
    public String getAllBooks(Model model){
    	List<Book> books = bookService.getAllBooks();
    	
    	model.addAttribute("books", books);
        return "books";
    }
    
    @GetMapping("/book-details/{id}")
    public String getBookDetails(@PathVariable String id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book); // Ensure the attribute name is "book"
        return "book-details"; // Ensure this matches the view template name
    }
  
}
