package dev.cordeiro.Desafio_criptografia.entities;

import dev.cordeiro.Desafio_criptografia.service.CyptoService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_transactional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionalEntity {


    @Id
    @Column(name= "transactional_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "user_document")
    private String encryptedUserDocument;

    @Column(name = "credit_card_token")
    private String encryptedCreditCardToken;

    @Column(name = "transactional_value")
    private long transactionValue;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;

    @PrePersist
    public void prePersist(){
        this.encryptedUserDocument = CyptoService.encrypt(rawUserDocument);
        this.encryptedCreditCardToken = CyptoService.encrypt(rawCreditCardToken);
    }
    @PostLoad
    public void postLoad(){
        this.rawUserDocument = CyptoService.decrypt(encryptedUserDocument);
        this.rawCreditCardToken = CyptoService.decrypt(encryptedCreditCardToken);
    }

}
