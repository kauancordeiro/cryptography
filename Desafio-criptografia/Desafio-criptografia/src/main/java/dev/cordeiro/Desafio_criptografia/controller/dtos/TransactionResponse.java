package dev.cordeiro.Desafio_criptografia.controller.dtos;

import dev.cordeiro.Desafio_criptografia.entities.TransactionalEntity;

public record TransactionResponse(Long id,
                                  String userDocument,
                                  String creditCardToken,
                                  Long value) {

    public static TransactionResponse fromEntity(TransactionalEntity entity){
        return new TransactionResponse(
                entity.getTransactionId(),
                entity.getRawUserDocument(),
                entity.getRawCreditCardToken(),
                entity.getTransactionValue()
        );

    }
}
