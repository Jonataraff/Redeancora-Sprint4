package br.com.fiap.redeancora.repository;

import br.com.fiap.redeancora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email); // <-- Adicione esta linha
}