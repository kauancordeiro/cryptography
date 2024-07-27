package dev.cordeiro.Desafio_criptografia.repository;

import dev.cordeiro.Desafio_criptografia.entities.TransactionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionalEntity,Long> {
}
