package com.api.skinpro.dto;

import com.api.skinpro.entity.Jogo;

import java.time.LocalDate;

public class JogoDTO {
    private Long id;
    private String nome;
    private LocalDate lancamento;

    public JogoDTO() {
    }

    public JogoDTO(String nome, LocalDate lancamento) {
        this.nome = nome;
        this.lancamento = lancamento;
    }

    public JogoDTO(Jogo jogo) {
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.lancamento = jogo.getLancamento();
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

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }
}
