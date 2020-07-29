package com.inter.desafiodigitounico.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

@Slf4j
public class EncryptionUtils {
    public static byte[] encryptString(byte[] string){

        try {
            Cipher encryption = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
            encryption.init(Cipher.ENCRYPT_MODE, generateKey().getPublic());
            return encryption.doFinal(string);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |  InvalidKeyException | IllegalBlockSizeException| BadPaddingException e) {
            log.error("Erro ao encriptografar o nome/email deste usuário ou usuário não existente!");
            return null;
        }
    }

    public static byte[] decryptString(byte[] string){
        try {
            Cipher decrypt = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
            decrypt.init(Cipher.DECRYPT_MODE, generateKey().getPrivate());
            return decrypt.doFinal(string);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |  InvalidKeyException | IllegalBlockSizeException| BadPaddingException e) {
            log.error("Erro ao decriptografar o nome/email deste usuário ou usuário não existente!");
            return null;
        }

    }

    public static KeyPair generateKey() throws NoSuchAlgorithmException {
        final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, new SecureRandom());
        return keyGen.generateKeyPair();
    }

}
