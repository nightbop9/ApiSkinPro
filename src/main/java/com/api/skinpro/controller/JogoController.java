package com.api.skinpro.controller;

import com.api.skinpro.dto.JogoDTO;
import com.api.skinpro.service.JogoService;
import com.api.skinpro.util.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jogo")
public class JogoController {
    @Autowired
    JogoService jogoService;

    @GetMapping("/list")
    public ResponseEntity<List<JogoDTO>> list() {
        return ResponseEntity.ok(jogoService.list());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody JogoDTO jogoDTO){
        jogoService.create(jogoDTO);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Jogo criado com sucesso.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update (@PathVariable Long id, @Valid @RequestBody JogoDTO jogoDTO) {
        jogoService.update(id, jogoDTO);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Jogo atualizado com sucesso.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        jogoService.delete(id);
        return ResponseBuilder.ResponseBuild(HttpStatus.OK, "Jogo excluído com sucesso.");
    }
}
