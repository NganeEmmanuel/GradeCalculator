package com.gradecalculator.gradecalculator.service.encryptors;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Encryptor {
    String encryptedText;

    public Encryptor(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    /**
     *
     * @param text the text to be encrypted
     * @return a string of encrypted text
     */
    public static String encrypt(String text){
        return BCrypt.withDefaults().hashToString(12, text.toCharArray());
    }

    /**
     *
     * @param text plain text you wish to check against the encrypted text
     * @param encryptedText encrypted text you need to check against the plain text
     * @return true if text are the same and false if not
     */
    public static boolean verify(String text, String encryptedText){
        return BCrypt.verifyer().verify(text.toCharArray(), encryptedText).verified;
    }
}
