package com.api.skinpro.entity;

import com.api.skinpro.dto.ItemDTO;
import com.api.skinpro.enums.Categoria;
import com.api.skinpro.enums.Raridade;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 500)
    private String descricao;
    private String imgUrl;
    @Column(nullable = false)
    private Categoria categoria;
    @Column(nullable = false)
    private Raridade raridade;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    public Item() {
    }

    public Item(Jogo jogo, String nome, String descricao, String imgUrl, Categoria categoria, Raridade raridade) {
        this.jogo = jogo;
        this.nome = nome;
        this.descricao = descricao;
        this.imgUrl = imgUrl;
        this.categoria = categoria;
        this.raridade = raridade;
    }

    public Item(ItemDTO itemDTO) {
        id = itemDTO.getId();
        nome = itemDTO.getNome();
        descricao = itemDTO.getDescricao();
        imgUrl = itemDTO.getImgUrl();
        categoria = itemDTO.getCategoria();
        raridade = itemDTO.getRaridade();
    }

    public Long getId() {
        return id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
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
