package com.api.skinpro.service;

import com.api.skinpro.dto.JogoDTO;
import com.api.skinpro.entity.Jogo;
import com.api.skinpro.exception.NotFoundException;
import com.api.skinpro.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    @Autowired
    JogoRepository jogoRepository;

    public List<JogoDTO> list() {
        return jogoRepository.findAll().stream()
                .map(JogoDTO::new)
                .toList();
    }

    public void create(JogoDTO jogoDTO) {
        Jogo jogo = new Jogo(jogoDTO);
        jogoRepository.save(jogo);
    }

    public void update(Long id, JogoDTO jogoDTO) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("atualização." +
                        ""));
        jogo.setNome(jogoDTO.getNome());
        jogo.setImgBackgroundUrl(jogoDTO.getImgBackgroundUrl());
        jogo.setImgLogoUrl(jogoDTO.getImgLogoUrl());
        jogoRepository.save(jogo);
    }

    public void delete(Long id){
        Jogo jogo = jogoRepository.findById(id).orElseThrow(() -> new NotFoundException("exclusão."));
        jogoRepository.delete(jogo);
    }
}
