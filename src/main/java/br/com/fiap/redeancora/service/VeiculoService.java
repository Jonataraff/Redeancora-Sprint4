package br.com.fiap.redeancora.service;

import br.com.fiap.redeancora.model.Veiculo;
import br.com.fiap.redeancora.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}