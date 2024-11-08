package com.mecylia.Controller;

import com.mecylia.Service.CartService;
import com.mecylia.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor

public class CartController {
    private final CartService cartService;


    //Find all cart
    @GetMapping("/all")
    public List<Cart> findAll () {
        return cartService.findAll();
    }

    //Create a cart
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cart create (@RequestBody Cart cart) {
        return cartService.create(cart.getId());
    }

    //Delete a cart
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart (@PathVariable Long id) {
        cartService.deleteCartById(id);
    }
  }
