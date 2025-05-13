package br.com.fiap.redeancora.service;

import br.com.fiap.redeancora.model.Mecanico;
import br.com.fiap.redeancora.repository.MecanicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoService {

    private final MecanicoRepository repository;

    public MecanicoService(MecanicoRepository repository) {
        this.repository = repository;
    }

    public List<Mecanico> listarTodos() {
        return repository.findAll();
    }

    public Mecanico salvar(Mecanico mecanico) {
        return repository.save(mecanico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Mecanico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}