package com.api.skinpro.dto;

import com.api.skinpro.entity.Item;
import com.api.skinpro.enums.Categoria;
import com.api.skinpro.enums.Raridade;

public class ItemDTO {
    private Long id;
    private Long jogoId;
    private String nome;
    private String descricao;
    private String imgUrl;
    private Categoria categoria;
    private Raridade raridade;

    public ItemDTO() {
    }

    public ItemDTO(Long jogoId, String nome, String descricao, String imgUrl, Categoria categoria, Raridade raridade) {
        this.jogoId = jogoId;
        this.nome = nome;
        this.descricao = descricao;
        this.imgUrl = imgUrl;
        this.categoria = categoria;
        this.raridade = raridade;
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.jogoId = item.getJogo().getId();
        this.nome = item.getNome();
        this.descricao = item.getDescricao();
        this.imgUrl = item.getImgUrl();
        this.categoria = item.getCategoria();
        this.raridade = item.getRaridade();
    }

    public Long getId() {
        return id;
    }

    public Long getJogoId() {
        return jogoId;
    }

    public void setJogoId(Long jogoId) {
        this.jogoId = jogoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }
}
