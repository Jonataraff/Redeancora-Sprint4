package br.com.fiap.redeancora.service;

import br.com.fiap.redeancora.model.Peca;
import br.com.fiap.redeancora.repository.PecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PecaService {

    private final PecaRepository repository;

    public PecaService(PecaRepository repository) {
        this.repository = repository;
    }

    public List<Peca> listarTodos() {
        return repository.findAll();
    }

    public Peca salvar(Peca peca) {
        return repository.save(peca);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Peca buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}