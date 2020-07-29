package com.inter.desafiodigitounico.utils;

import lombok.extern.java.Log;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptionUtils {
    public static byte[] encryptString(byte[] string){

        try {
            Cipher encryption = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
            encryption.init(Cipher.ENCRYPT_MODE, generateKey().getPublic());
            return encryption.doFinal(string);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |  InvalidKeyException | IllegalBlockSizeException| BadPaddingException e) {
            return null;
        }
    }

    public static byte[] decryptString(byte[] string){
        try {
            Cipher decrypt = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
            decrypt.init(Cipher.DECRYPT_MODE, generateKey().getPrivate());
            return decrypt.doFinal(string);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |  InvalidKeyException | IllegalBlockSizeException| BadPaddingException e) {
            return null;
        }

    }

    public static PublicKey getPublicKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(key)));
    }

    public static PrivateKey getPrivateKey(String stringKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(stringKey)));
    }


    public static KeyPair generateKey() throws NoSuchAlgorithmException {
        final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, new SecureRandom());
        return keyGen.generateKeyPair();
    }

}
