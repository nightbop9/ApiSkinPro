package com.api.skinpro.controller;

import com.api.skinpro.dto.ItemDTO;
import com.api.skinpro.repository.ItemRepository;
import com.api.skinpro.service.ItemService;
import com.api.skinpro.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> list() {
        return ResponseEntity.ok(itemService.list());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody ItemDTO itemDTO) {
        itemService.create(itemDTO);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Item criado.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        itemService.update(id ,itemDTO);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Item atualizado.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(Long id) {
        itemService.delete(id);
    return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Item excluído");
    }
}
