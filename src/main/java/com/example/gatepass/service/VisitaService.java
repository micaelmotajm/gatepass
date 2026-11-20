package com.example.gatepass.service;

import com.example.gatepass.model.Visita;
import com.example.gatepass.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitaService {

    private final VisitaRepository repository;

    public Visita cadastrar(Visita visita) {
        visita.setId(null);
        return repository.save(visita);
    }

    public List<Visita> listarTodas() {
        return repository.findAll();
    }

    public Visita buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Visita não encontrada"));
    }

    public Visita atualizar(Long id, Visita dados) {
        Visita existente = buscarPorId(id);
        existente.setNomeVisitante(dados.getNomeVisitante());
        existente.setSetorVisitado(dados.getSetorVisitado());
        existente.setMotivoVisita(dados.getMotivoVisita());
        existente.setDataVisita(dados.getDataVisita());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        Visita existente = buscarPorId(id);
        repository.delete(existente);
    }
}
