package com.gradecalculator.gradecalculator.service.encryptorsService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EncryptorTest {
    @Test
    public void testEncrypt_and_Verify_withMatchingText_returnsTrue() {
        // Arrange
        String plainText = "password";

        // Act
        String encryptedText = Encryptor.encrypt(plainText);
        boolean result = Encryptor.verify(plainText, encryptedText);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testEncrypt_and_Verify_withNonMatchingText_returnsFalse() {
        // Arrange
        String plainText = "password";
        String incorrectText = "wrongpassword";

        // Act
        String encryptedText = Encryptor.encrypt(plainText);
        boolean result = Encryptor.verify(incorrectText, encryptedText);

        // Assert
        assertFalse(result);
    }
}
