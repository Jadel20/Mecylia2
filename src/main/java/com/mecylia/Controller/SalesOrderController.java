package com.mecylia.Controller;

import com.mecylia.Service.SalesOrderService;
import com.mecylia.model.SalesOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor

public class SalesOrderController {
private final SalesOrderService salesOrderService;

//To return all the sale orders
@GetMapping()
public List<SalesOrder> findAll() {
    return salesOrderService.findAll();
}

//To get sale orders by ID
@GetMapping ("/{id}")
public SalesOrder findById(@PathVariable Long id) {
return salesOrderService.findById(id);
}

// To update Sales Order by Id
@PostMapping ("/{id}")
public SalesOrder updateSalesOrder (@RequestBody SalesOrder salesOrder, @PathVariable Long id) {
 return salesOrderService.updateSalesOrder(salesOrder,id);
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSalesOrder (@PathVariable Long id) {
    salesOrderService.deleteSalesOrderById(id);
}
}

