package com.mecylia.Service;

import com.mecylia.Repository.ItemRepository;
import com.mecylia.Repository.SalesOrderRepository;
import com.mecylia.model.Item;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SalesOrderRepository salesOrderRepository;

    // Create and save an item
    @Transactional
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    // Find all items
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    //Find items by Id
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    //Update item
    public Item updateItem(Long id, Item updateItemData) {
        Optional<Item> itemToUpdateOptional = itemRepository.findById(id);
        if (itemToUpdateOptional.isEmpty()){
            return null;
        }
        Item itemToUpdate = itemToUpdateOptional.get();

        itemToUpdate.setTitle(updateItemData.getTitle());
        itemToUpdate.setDescription(updateItemData.getDescription());
        itemToUpdate.getItemSize();
        itemToUpdate.getColor();
        itemToUpdate.setPrice(updateItemData.getPrice());
        itemToUpdate.getQuantityAvailable();

        return itemRepository.save(itemToUpdate);
    }

    // Delete item
    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

}