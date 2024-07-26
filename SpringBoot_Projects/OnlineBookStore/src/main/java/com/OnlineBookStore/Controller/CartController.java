package com.OnlineBookStore.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
        List<Cart> cartItems = cartService.getCart();
        
        System.out.println("Items in cart: " + cartItems); // Debugging statement
        
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("id") String bookId, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Book book = bookService.getBook(bookId);
        System.out.println("Adding book to cart: " + book); // Debugging statement
        cartService.addBook(book);
        
        String referer = request.getHeader("Referer"); //gets current page url and refreshes back to it i.e /cart
        return "redirect:" + referer;
    }

    @PostMapping("/removeItem")
    public String removeItem(@RequestParam("id") int cartItemNo) {
        System.out.println("Removing cart item: " + cartItemNo); // Debugging statement
        cartService.removeBook(cartItemNo);
        return "redirect:/cart";
    }
}
