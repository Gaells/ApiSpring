package com.example.api_Java.service;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_Java.exception.ItemNotFoundException;
import com.example.api_Java.model.Item;
import com.example.api_Java.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
    return itemRepository.findAll().stream().collect(Collectors.toList());
}

    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item save(Item item) {
    CompletableFuture<Item> futureItem = CompletableFuture.supplyAsync(() -> itemRepository.save(item));
    return futureItem.join();
}

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}


