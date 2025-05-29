package com.api.skinpro.service;

import com.api.skinpro.dto.ItemDTO;
import com.api.skinpro.entity.Item;
import com.api.skinpro.exception.NotFoundException;
import com.api.skinpro.repository.ItemRepository;
import com.api.skinpro.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    private ImageService imageService;

    public List<ItemDTO> list() {
        return itemRepository.findAll().stream()
                .map(ItemDTO::new)
                .toList();
    }

    public void create(ItemDTO itemDTO, MultipartFile file) {
        Item item = new Item(itemDTO);
        item.setJogo(jogoRepository.findById(itemDTO.getJogoId()).orElseThrow(() -> new NotFoundException("associação")));
        if (file != null && !file.isEmpty()) {
            item.setImgUrl(imageService.uploadImage(file));
        } else {
            item.setImgUrl(null);
        }
        itemRepository.save(item);
    }

    public void update(Long id, ItemDTO itemDTO, MultipartFile file) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new NotFoundException(("atualização")));
        item.setNome(itemDTO.getNome());
        item.setDescricao(itemDTO.getDescricao());
        item.setCategoria(itemDTO.getCategoria());
        item.setRaridade(itemDTO.getRaridade());
        item.setJogo(jogoRepository.findById(itemDTO.getJogoId()).orElseThrow(() -> new NotFoundException("associação")));
        String imgUrl = item.getImgUrl();
        if (file != null && !file.isEmpty()) {
            if (imgUrl == null || imgUrl.isBlank()) {
                item.setImgUrl(imageService.uploadImage(file));
            } else {
                item.setImgUrl(imageService.updateImage(imgUrl, file));
            }
        } else {
            if (imgUrl != null) {
                imageService.deleteImage(imgUrl);
            }
            item.setImgUrl(null);
        }
        itemRepository.save(item);
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new NotFoundException("exclusão"));
        imageService.deleteImage(item.getImgUrl());
        itemRepository.delete(item);
    }
}
