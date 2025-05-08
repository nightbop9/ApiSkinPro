package com.api.skinpro.entity;

import com.api.skinpro.dto.JogoDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    private LocalDate lancamento;

    public Jogo() {
    }

    public Jogo(String nome, LocalDate lancamento) {
        this.nome = nome;
        this.lancamento = lancamento;
    }

    public Jogo(JogoDTO jogoDTO) {
        this.id = jogoDTO.getId();
        this.nome = jogoDTO.getNome();
        this.lancamento = jogoDTO.getLancamento();
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
