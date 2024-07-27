package dev.cordeiro.Desafio_criptografia.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CyptoService {

    private static final StrongTextEncryptor encryptor;

    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("ENCRYPT_KEY"));
    }

    public static  String encrypt(String rawText){
        return encryptor.encrypt(rawText);
    }

    public static  String decrypt(String rawText){
        return encryptor.decrypt(rawText);
    }
}
