package dev.cordeiro.Desafio_criptografia.service;

import dev.cordeiro.Desafio_criptografia.controller.dtos.CreateTransactionRequest;
import dev.cordeiro.Desafio_criptografia.controller.dtos.TransactionResponse;
import dev.cordeiro.Desafio_criptografia.controller.dtos.UpdateTransactionRequest;
import dev.cordeiro.Desafio_criptografia.entities.TransactionalEntity;
import dev.cordeiro.Desafio_criptografia.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public TransactionResponse findById (Long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return TransactionResponse.fromEntity(entity);
    }

    public void update(Long id, UpdateTransactionRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity.setTransactionValue(request.value());
       repository.save(entity);
    }
    public void deleteById(Long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(entity.getTransactionId());
    }


}
