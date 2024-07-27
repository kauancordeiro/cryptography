package dev.cordeiro.Desafio_criptografia.controller.dtos;

public record CreateTransactionRequest(String userDocument,
                                       String creditCardToken,
                                       Long value){
}
