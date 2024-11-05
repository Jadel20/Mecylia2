package com.mecylia.Controller;

import com.mecylia.Service.ItemService;
import com.mecylia.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
@RequiredArgsConstructor

public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public List<Item> findAllItems(){
        return itemService.findAllItems();
    }

    @GetMapping ("/{id}")
    public Item findById(@PathVariable Long id){
        return itemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody Item item){
        return itemService.create(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item){
        return itemService.updateItem(id, item);
    }

    @DeleteMapping ("/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

}
