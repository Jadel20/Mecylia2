package com.mecylia.Service;


import com.mecylia.Repository.CartRepository;
import com.mecylia.Repository.CustomerRepository;
import com.mecylia.Repository.ItemRepository;
import com.mecylia.model.Cart;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;


    //Create a cart
    public Cart create (Long Id) {
        Optional<Cart> ExistingCart = cartRepository.findById(Id);

        if (ExistingCart.isPresent()) {
            return ExistingCart.get(); //retrieve existing cart
        }
        // or else create and save a new cart
        Cart newCart = new Cart();
        newCart.setId(Id);
        return cartRepository.save(newCart);
    }

    //Find all carts
    public List <Cart> findAll(){
        return cartRepository.findAll();
    }

//    // Find cart by Id
//    @Transactional
//    public Cart findCartById(Long Id) {
//        return cartRepository.findById(Id).orElse(null);
//    }

    //Update a cart
    @Transactional
    public Cart updateCart (Cart cartToUpdate, Long id) {
        var Cart = cartRepository.findById(cartToUpdate.getId());
                if (Cart.isEmpty()){
                    return null;
                }else
                    cartToUpdate.setId(id);
                return cartRepository.save(cartToUpdate);
    }

    //Add an item to cart
    public Cart addItemToCart(Long Id, Long itemId, int quantity) {
//        Optional<Item> ItemOptional = itemRepository.findById(itemId);
//        if (ItemOptional.isPresent()) {
//            Item item = ItemOptional.get();
//            item.setQuantityAvailable(quantity);
//            itemRepository.save(item);
//        }
//        return cartRepository.save(createCartForCustomer(Id));

//        find the cart
//        check if the cart has already the item, if so add quatity by 1
//        else
//        find the item
//        add it to the cart with a + 1
//        save the cart
//        id you dont find the cart or the idem return null
        return null;
    }

    public void deleteCartById(Long Id) {
        cartRepository.deleteById(Id);
    }
}