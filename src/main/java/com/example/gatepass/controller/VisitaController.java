package com.example.gatepass.controller;

import com.example.gatepass.model.Visita;
import com.example.gatepass.service.VisitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
@RequiredArgsConstructor
public class VisitaController {

    private final VisitaService service;

    @PostMapping
    public ResponseEntity<Visita> cadastrar(@Valid @RequestBody Visita visita) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(visita));
    }

    @GetMapping
    public ResponseEntity<List<Visita>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visita> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visita> atualizar(@PathVariable Long id, @Valid @RequestBody Visita visita) {
        return ResponseEntity.ok(service.atualizar(id, visita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
