package com.OnlineBookStore.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Model.Cart;

@Service
public class CartService {

	//an arrayList of book 
    //private List<Book> cartBooks = new ArrayList<>();
	
	//getting an instance of cart pojo
	@Autowired
	private Cart cart; 

  
    // Method to add a book to the cart
    public void addBook(Book book) {
    	book.setQty(book.getQty() + 1); //increasing the book by 1
    	
    	if(cart.getBooksInCart().contains(book)) {
    		cart.getBooksInCart().set(cart.getBooksInCart().indexOf(book), book); //adding the book to the cart list 
    	}
    	else {
    		cart.getBooksInCart().add(book);
    	}
    }

    public void removeBook(String uuid) {
        // Find the book in the cart by UUID using streams
        cart.getBooksInCart().stream()
            .filter(book -> book.getUuid().equals(uuid))
            .findFirst()
            .ifPresent(book -> {
                if (book.getQty() > 1) {
                    // Decrease the quantity if more than 1
                    book.setQty(book.getQty() - 1);
                } else {
                    // Remove the book if quantity is 1 or less
                    cart.getBooksInCart().remove(book);
                }
            });
    }


    // Method to get all books in the cart
    public List<Book> getCart() {
        return cart.getBooksInCart();
    }
}
