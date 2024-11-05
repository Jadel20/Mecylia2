package com.mecylia.Service;


import com.mecylia.Repository.CartRepository;
import com.mecylia.Repository.CustomerRepository;
import com.mecylia.Repository.ItemRepository;
import com.mecylia.Repository.SalesOrderRepository;
import com.mecylia.model.Item;
import com.mecylia.model.SalesOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SalesOrderService extends SalesOrder {

    private final SalesOrderRepository salesOrderRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    // Create an order
    public SalesOrder createSalesOrder (SalesOrder salesOrder) {
      return salesOrderRepository.save(salesOrder);
    }

    //Find all orders
    public List<SalesOrder> findAll () {
    return salesOrderRepository.findAll();
    }

    //Find sales order by ID
    public SalesOrder findById (Long id) {
    return salesOrderRepository.findById(id).orElse(null);
    }

    //Update sales order
    public SalesOrder updateSalesOrder (SalesOrder salesOrder, Long id) {
        var salesOrderToUpdate = salesOrderRepository.findById(id);
        if (salesOrderToUpdate.isEmpty()) {
            return null;
        } else {
            salesOrder.setId(id);
            return salesOrderRepository.save(salesOrder);
        }
    }

    //Add an item to an order
    public void addItemToCart (Item item) {
    this.itemRepository.save(item);
    item.getSalesOrders().add(this);
    }

    //Remove an item to the order
    public void removeItemFromCart (Item item) {
        this.itemRepository.delete(item);
        item.getSalesOrders().remove(this);
    }

    //Delete order
    public void deleteSalesOrderById (Long id) {
        salesOrderRepository.deleteById(id);
    }
}
