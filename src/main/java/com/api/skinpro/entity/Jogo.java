package com.api.skinpro.entity;

import com.api.skinpro.dto.JogoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_jogo")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    private String imgLogoUrl;
    private String imgBackgroundUrl;

    public Jogo() {
    }

    public Jogo(String nome, String imgLogoUrl, String imgBackgroundUrl) {
        this.nome = nome;
        this.imgLogoUrl = imgLogoUrl;
        this.imgBackgroundUrl = imgBackgroundUrl;
    }

    public Jogo(JogoDTO jogoDTO) {
        this.id = jogoDTO.getId();
        this.nome = jogoDTO.getNome();
        this.imgLogoUrl = jogoDTO.getImgLogoUrl();
        this.imgBackgroundUrl = jogoDTO.getImgBackgroundUrl();
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
