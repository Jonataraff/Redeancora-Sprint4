package br.com.fiap.redeancora.repository;

import br.com.fiap.redeancora.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PecaRepository extends JpaRepository<Peca, Long> {
    List<Peca> findByNomeContainingIgnoreCase(String nome);}