package com.api.skinpro.service;

import com.api.skinpro.dto.ItemDTO;
import com.api.skinpro.dto.JogoDTO;
import com.api.skinpro.entity.Item;
import com.api.skinpro.exception.NotFoundException;
import com.api.skinpro.repository.ItemRepository;
import com.api.skinpro.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    JogoRepository jogoRepository;

    public List<ItemDTO> list() {
        return itemRepository.findAll().stream()
                .map(ItemDTO::new)
                .toList();
    }

    public void create(ItemDTO itemDTO) {
        Item item = new Item(itemDTO);
        item.setJogo(jogoRepository.findById(itemDTO.getJogoId()).orElseThrow(() -> new NotFoundException("associação")));
    }


}
