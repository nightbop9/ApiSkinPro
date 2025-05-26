package com.api.skinpro.service;

import com.api.skinpro.dto.JogoDTO;
import com.api.skinpro.entity.Jogo;
import com.api.skinpro.exception.NotFoundException;
import com.api.skinpro.repository.JogoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    ImageService imageService;

    @Autowired
    JogoRepository jogoRepository;

    //Todos os métodos daqui em diante são HTTP demandados a api

    /**
     * Método para listar todas as postagens.
     *
     * @return lista das postagens.
     */
    public List<JogoDTO> list() {
        return jogoRepository.findAll().stream()
            .map(JogoDTO::new)
            .toList();
    }

    /**
     * Método para criar uma nova postagem.
     *
     * @param jogoDTO com os dados da postagem a ser criada.
     * @param logo    arquivo de imagem
     */
    @Transactional
    public void create(JogoDTO jogoDTO, MultipartFile logo, MultipartFile bg) {
        Jogo jogo = new Jogo(jogoDTO);
        if (logo != null && !logo.isEmpty()) {
            jogo.setImgLogoUrl(imageService.uploadImage(logo));
        } else {
            jogo.setImgLogoUrl(null);
        }

        if (bg != null && !bg.isEmpty()) {
            jogo.setImgBackgroundUrl(imageService.uploadImage(bg));
        } else {
            jogo.setImgBackgroundUrl(null);
        }
        jogoRepository.save(jogo);
    }

    /**
     * Método para atualizar uma postagem.
     *
     * @param id      da entidade a ser atualizada
     * @param jogoDTO com os novos dados da entidade
     * @param logo    arquivo de imagem
     */
    @Transactional
    public void update(Long id, JogoDTO jogoDTO, MultipartFile logo, MultipartFile bg) {
        Jogo jogo = jogoRepository.findById(id).orElseThrow(() ->
            new NotFoundException("atualização."));
        jogo.setNome(jogoDTO.getNome());

        String imgLogoUrl = jogo.getImgLogoUrl();

        if (logo != null && !logo.isEmpty()) {
            if (imgLogoUrl == null || imgLogoUrl.isBlank()) {
                jogo.setImgLogoUrl(imageService.uploadImage(logo));
            } else {
                jogo.setImgLogoUrl(imageService.updateImage(imgLogoUrl, logo));
            }
        } else {
            imageService.deleteImage(imgLogoUrl);
            jogo.setImgLogoUrl(null);
        }

        String imgBackgroundUrl = jogo.getImgBackgroundUrl();

        if (bg != null && !bg.isEmpty()) {
            if (imgBackgroundUrl == null || imgBackgroundUrl.isBlank()) {
                jogo.setImgBackgroundUrl(imageService.uploadImage(bg));
            } else {
                jogo.setImgBackgroundUrl(imageService.updateImage(imgBackgroundUrl, bg));
            }
        } else {
            imageService.deleteImage(imgBackgroundUrl);
            jogo.setImgBackgroundUrl(null);
        }
        jogoRepository.save(jogo);
    }

    //    /**
//     * Método para excluir uma postagem.
//     *
//     * @param id da entidade a ser excluída.
//     */
    @Transactional
    public void delete(Long id) {
        Jogo jogo = jogoRepository.findById(id).orElseThrow(() ->
            new NotFoundException("exclusão."));
        if (jogo.getImgLogoUrl() != null) {
            imageService.deleteImage(jogo.getImgLogoUrl());
        }

        if (jogo.getImgBackgroundUrl() != null) {
            imageService.deleteImage(jogo.getImgBackgroundUrl());
        }
        jogoRepository.delete(jogo);
    }
}
