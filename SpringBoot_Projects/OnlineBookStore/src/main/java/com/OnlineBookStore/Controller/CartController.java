package com.OnlineBookStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {

	private final CartService cartService;
	
	CartController(CartService cartService){
		this.cartService = cartService;
		
	}
	
	@PostMapping("/addToCart")
    public String addToCart(@ModelAttribute Book book, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        cartService.addBook(book);

        // Capture the referring URL
        String referer = request.getHeader("Referer");

        // Redirect back to the referring URL
        return "redirect:" + referer;
    }
}
