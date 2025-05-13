package br.com.fiap.redeancora.repository;

import br.com.fiap.redeancora.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}