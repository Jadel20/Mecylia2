package com.mecylia.Demo;

import com.mecylia.Repository.CartRepository;
import com.mecylia.Repository.CustomerRepository;
import com.mecylia.Repository.ItemRepository;
import com.mecylia.Repository.SalesOrderRepository;
import com.mecylia.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final SalesOrderRepository salesOrderRepository;

    @Override
    public void run(String... args) throws Exception {

        itemRepository.saveAll(List.of(
                new Item("Culture Carry Bag", "A chic and adaptable accessory that effortlessly merges style, utility and cultural allure", ItemSize.ONE_SIZE, "Orange", 29.90, 15),
                new Item("Marrakech Mosaic Mailbag", "Artisan Made, cultural motifs, full grain leather", ItemSize.ONE_SIZE, "Beige", 28.44, 8),
                new Item("Marrakech Mosaic Mailbag", "Artisan Made, cultural motifs, full grain leather", ItemSize.ONE_SIZE, "Blue", 28.44, 8),
                new Item("Marrakech Mosaic Mailbag", "Artisan Made, cultural motifs, full grain leather", ItemSize.ONE_SIZE, "Burnished brown", 28.44, 8),
                new Item("Marrakech Mosaic Mailbag", "Artisan Made, cultural motifs, full grain leather", ItemSize.ONE_SIZE, "Camel sands", 28.44, 8),
                new Item("Artisan Atlas Belt", "Artisan made belt in full grain leather made in the pure Moroccan tradition", ItemSize.ONE_SIZE, "Black", 28.44, 5),
                new Item("Artisan Atlas Belt", "Artisan made belt in full grain leather made in the pure Moroccan tradition", ItemSize.ONE_SIZE, "Brown", 28.44, 5),
                new Item("Mystic Linen Grace", "Stunning blend of modern design and traditional craftmanship. This linen outfit is perfect for those who appreciate both comfort and elegence", ItemSize.MEDIUM, "Beige", 79.99, 3),
                new Item("Mystic Linen Grace", "Stunning blend of modern design and traditional craftmanship. This linen outfit is perfect for those who appreciata both comfort and elegence", ItemSize.LARGE, "Beige", 79.99, 6),
                new Item("Mystic Linen Grace", "Stunning blend of modern design and traditional craftmanship. This linen outfir is perfect for those who appreciate both comfort and elegence", ItemSize.EXTRA_LARGE, "Beige", 79.99, 10),
                new Item("Sapphire Djellaba", "Comfortable dress with moroccan accent, this handcrafted djellaba is the perfect summer outfit", ItemSize.ONE_SIZE, "Beige and blue", 59.99, 6),
                new Item("Aurora of Atlas", "Adjustable black velvet vest. Crafted with unparalleled artisty and attention to detail, this vest is a timeless expression of heritage and elegance", ItemSize.SMALL, "Black and red", 79.99, 4),
                new Item("Aurora of Atlas", "Adjustable black velvet vest. Crafted with unparalleled artisty and attention to detail, this vest is a timeless expression of heritage and elegance", ItemSize.MEDIUM, "Black and red", 79.99, 4),
                new Item("Aurora of Atlas", "Adjustable black velvet vest. Crafted with unparalleled artisty and attention to detail, this vest is a timeless expression of heritage and elegance", ItemSize.LARGE, "Black and red", 79.99, 4),
                new Item("Amazigh Artisty Belt Corset & Cuff Design Set", "Say farewell to sizing struggles with our multicolor waistbelt corset, ensuring a perfect fit for all body types", ItemSize.ONE_SIZE, "Multicolor", 89.90, 5),
                new Item("Vintage Vagabond Carryall XL", "Crafted for the spirited soul who traverse the globe, embracing diverse cultures and adorning themselves in the rich tapestry of ethnic accessories", ItemSize.ONE_SIZE, "Brown", 349.99, 2)


        ));

        customerRepository.saveAll(List.of(
                new Customer("Pauline", "Martin", 12 - 10 - 2000, "Pmartin@yahoo.fr", "20 avenue de le Republique", "Paris", 0612232345, 991),
                new Customer("Selma", "Ben Omar", 5 - 4 - 1989, "sbom@gmail.com", "10 rue de Tanger", "Casablanca", 677875087, 298765451),
                new Customer("Carmen", " Santos", 5 - 1 - 2001, "carmends@gmail.com", "Carrer de la Jonquera, 4", "Madrid", 666876543, 1228)
        ));

        SalesOrder order1 = new SalesOrder();
        order1.setCustomer(customerRepository.getOne(1L));
        order1.setAddress("Carrer de la Jonquera 4");
        order1.setTrackingNumber("DF#567T");
        order1.setStatus("In Transit");
        order1.setTotalPrice(28.44);
        salesOrderRepository.save(order1);

        SalesOrder order2 = new SalesOrder();
        order2.setCustomer(customerRepository.getReferenceById(1L));
        order2.setAddress("Carrer de la Jonquera 4");
        order2.setTrackingNumber("OG65!!4L");
        order2.setStatus("Delivered");
        order2.setTotalPrice(79.99);
        salesOrderRepository.save(order2);

        SalesOrder order3 = new SalesOrder();
        order3.setCustomer(customerRepository.getReferenceById(2L));
        order3.setAddress("10 rue de Tanger, Casablanca");
        order3.setTrackingNumber("MD1#6F12");
        order3.setStatus("In Transit");
        order3.setTotalPrice(159.98);
        salesOrderRepository.save(order3);

        SalesOrder order4 = new SalesOrder();
        order4.setCustomer(customerRepository.getReferenceById(3L));
        order4.setAddress("Carrer de la Jonquera,4, Madrid");
        order4.setTrackingNumber("MD567#T2");
        order4.setStatus("Delivered");
        order4.setTotalPrice(59.99);
        salesOrderRepository.save(order4);

        var cart1 = new Cart();
        cart1.setCustomer(customerRepository.getReferenceById(1L));
        cart1.setItemId(2);
        cart1.setItemName("Marrakech Mosaic Mailbag");
        cart1.setQuantity(1);
        cart1.setPrice(28.44);
        cartRepository.save(cart1);

        var cart2 = new Cart();
        cart2.setCustomer(customerRepository.getReferenceById(1L));
        cart2.setItemId(8);
        cart2.setItemName("Mystic Linen Grace");
        cart2.setQuantity(1);
        cart2.setPrice(79.99);
        cartRepository.save(cart2);

        var cart3 = new Cart();
        cart3.setCustomer(customerRepository.getReferenceById(2L));
        cart3.setItemId(14);
        cart3.setItemName("Aurora of Atlas");
        cart3.setQuantity(2);
        cart3.setPrice(79.99);
        cartRepository.save(cart3);

        var cart4 = new Cart();
        cart4.setCustomer(customerRepository.getReferenceById(3L));
        cart4.setItemId(11);
        cart4.setItemName("Sapphire Djellaba");
        cart4.setQuantity(1);
        cart4.setPrice(59.99);
        cartRepository.save(cart4);

    }
}

