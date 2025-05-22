package com.api.skinpro.controller;

import com.api.skinpro.dto.ItemDTO;
import com.api.skinpro.repository.ItemRepository;
import com.api.skinpro.service.ImageService;
import com.api.skinpro.service.ItemService;
import com.api.skinpro.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ImageService imageService;

    @GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> list() {
        return ResponseEntity.ok(itemService.list());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @ModelAttribute ItemDTO itemDTO,
                                         @RequestParam (name = "image") MultipartFile file) {
        itemService.create(itemDTO, file);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Item criado.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @ModelAttribute ItemDTO itemDTO,
                                         @RequestParam (name = "image", required = false) MultipartFile file) {
        itemService.update(id ,itemDTO, file);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Item atualizado.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(Long id) {
        itemService.delete(id);
    return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Item excluído");
    }
}
