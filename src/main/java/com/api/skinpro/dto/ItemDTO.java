package com.api.skinpro.dto;

import com.api.skinpro.entity.Item;
import com.api.skinpro.enums.Categoria;
import com.api.skinpro.enums.Raridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ItemDTO {
    private Long id;
    @NotBlank(message = "Escolha um jogo para associação.")
    private Long jogoId;
    @NotBlank(message = "O nome do item é obrigatório.")
    @Size(max = 50, message = "O nome do item não deve ultrapassar 50 caracteres.")
    private String nome;
    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 500, message = "A descrição não deve ultrapassar 500 caracteres.")
    private String descricao;
    private String imgUrl;
    @NotNull(message = "Escolha uma categoria.")
    private Categoria categoria;
    @NotNull(message = "Escolha uma raridade.")
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
