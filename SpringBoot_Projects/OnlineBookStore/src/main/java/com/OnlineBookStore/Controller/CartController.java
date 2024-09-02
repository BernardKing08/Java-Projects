package com.OnlineBookStore.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.OnlineBookStore.Model.Book;
import com.OnlineBookStore.Model.Cart;
import com.OnlineBookStore.Service.BookService;
import com.OnlineBookStore.Service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    private final CartService cartService;
    private final BookService bookService;

    CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @RequestMapping("/cart")
    public String displayCart(Model model) {
        List<Book> cartItems = cartService.getCart();
        
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("id") String bookId, HttpServletRequest request) {
        Book book = bookService.getBook(bookId);
        cartService.addBook(book);
        
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PostMapping("/removeItem")
    public String removeItem(@RequestParam("id") String bookId) {
        cartService.removeBook(bookId);
        return "redirect:/cart";
    }
}
