package com.example.api_Java.controller;
import com.example.api_Java.model.Item;
import com.example.api_Java.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Item createItem(@Valid @RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @Valid @RequestBody Item itemDetails) {
        Item item = itemService.findById(id);
        item.setNome(itemDetails.getNome());
        item.setDescricao(itemDetails.getDescricao());
        item.setPreco(itemDetails.getPreco());
        return itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}