package com.api.skinpro.controller;

import com.api.skinpro.dto.JogoDTO;
import com.api.skinpro.service.JogoService;
import com.api.skinpro.util.CustomResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<Object> create(@Valid @ModelAttribute JogoDTO jogoDTO,
                                         @RequestParam(value = "logo", required = false) MultipartFile logo,
                                         @RequestParam(value = "bg", required = false) MultipartFile bg){
        jogoService.create(jogoDTO, logo, bg);
        return CustomResponseBuilder.ResponseBuild(HttpStatus.OK, "Jogo criado com sucesso.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update (@PathVariable Long id, @Valid @ModelAttribute JogoDTO jogoDTO,
                                          @RequestParam(value = "logo", required = false) MultipartFile logo,
                                          @RequestParam(value = "bg", required = false) MultipartFile bg) {
        jogoService.update(id, jogoDTO, logo, bg);
        return CustomResponseBuilder.ResponseBuild(HttpStatus.OK, "Jogo atualizado com sucesso.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        jogoService.delete(id);
        return CustomResponseBuilder.ResponseBuild(HttpStatus.OK, "Jogo excluído com sucesso.");
    }
}
