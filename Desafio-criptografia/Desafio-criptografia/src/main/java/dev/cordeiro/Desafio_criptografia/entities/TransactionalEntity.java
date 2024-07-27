package dev.cordeiro.Desafio_criptografia.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_transactional")
public class TransactionalEntity {


    @Id
    @Column(name= "transactional_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionalId;

    @Column(name = "user_document")
    private String userDocument;

    @Column(name = "credit_card_token")
    private String creditCardToken;

    @Column(name = "transactional_value")
    private long transactionalValue;

}
