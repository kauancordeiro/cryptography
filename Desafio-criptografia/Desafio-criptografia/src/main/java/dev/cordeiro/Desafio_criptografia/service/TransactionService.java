package dev.cordeiro.Desafio_criptografia.service;

import dev.cordeiro.Desafio_criptografia.controller.dtos.CreateTransactionRequest;
import dev.cordeiro.Desafio_criptografia.controller.dtos.TransactionResponse;
import dev.cordeiro.Desafio_criptografia.entities.TransactionalEntity;
import dev.cordeiro.Desafio_criptografia.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;


    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }


    public void create(CreateTransactionRequest request){
        var entity = new TransactionalEntity();
        entity.setTransactionValue(request.value());
        entity.setRawUserDocument(request.userDocument());
        entity.setRawCreditCardToken(request.creditCardToken());

        repository.save(entity);
    }

    public Page<TransactionResponse> listAll (int page, int pageSize){
        var content = repository.findAll(PageRequest.of(page,pageSize));

        return content.map(TransactionResponse::fromEntity);


    }
}
