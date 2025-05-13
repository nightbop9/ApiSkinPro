package com.api.skinpro.dto;

import com.api.skinpro.entity.Jogo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class JogoDTO {
    private Long id;
    @NotBlank(message = "O nome do jogo é obrigatório.")
    @Size(max = 50, message = "O nome do jogo não deve ultrapassar 50 caracteres.")
    private String nome;
    private String imgLogoUrl;
    private String imgBackgroundUrl;

    public JogoDTO() {
    }

    public JogoDTO(String nome, String imgLogoUrl, String imgBackgroundUrl) {
        this.nome = nome;
        this.imgLogoUrl = imgLogoUrl;
        this.imgBackgroundUrl = imgBackgroundUrl;
    }

    public JogoDTO(Jogo jogo) {
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.imgLogoUrl = jogo.getImgLogoUrl();
        this.imgBackgroundUrl = jogo.getImgBackgroundUrl();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImgLogoUrl() {
        return imgLogoUrl;
    }

    public void setImgLogoUrl(String imgLogoUrl) {
        this.imgLogoUrl = imgLogoUrl;
    }

    public String getImgBackgroundUrl() {
        return imgBackgroundUrl;
    }

    public void setImgBackgroundUrl(String imgBackgroundUrl) {
        this.imgBackgroundUrl = imgBackgroundUrl;
    }
}
