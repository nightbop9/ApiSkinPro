package com.api.skinpro.repository;

import com.api.skinpro.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> id(Long id);
}
