package br.com.fiap.redeancora.repository;

import br.com.fiap.redeancora.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecaRepository extends JpaRepository<Peca, Long> {
}