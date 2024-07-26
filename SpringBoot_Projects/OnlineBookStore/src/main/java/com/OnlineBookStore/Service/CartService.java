package com.OnlineBookStore.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Model.Cart;

@Service
public class CartService {

	private List<Cart> cartBook = new ArrayList<>();

    public void addBook(Book book) {
        Random rand = new Random();
        int randomNum = rand.nextInt((1000 - 0) + 1) + 1; // generating a random number to serve as the UUId for now 
        cartBook.add(new Cart(book, randomNum));
    }
	
	public List<Cart> getCart() {
		return cartBook;
		
	}

	public void removeBook(int cartItemNo) {
        cartBook = cartBook.stream()
            .filter(cart -> cart.getCartItemNo() != cartItemNo)
            .collect(Collectors.toList());
    }
}
