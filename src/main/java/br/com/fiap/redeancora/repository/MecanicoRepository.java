package br.com.fiap.redeancora.repository;

import br.com.fiap.redeancora.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}