package com.gradecalculator.gradecalculator.service.validationService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorServiceTest {
    @Test
    public void testIsEmailValid_withValidEmail_returnsTrue() {
        // Arrange
        String validEmail = "test@example.com";

        // Act
        boolean result = EmailValidator.isEmailValid(validEmail);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEmailValid_withInvalidEmail_returnsFalse() {
        // Arrange
        String invalidEmail = "invalid.email";

        // Act
        boolean result = EmailValidator.isEmailValid(invalidEmail);

        // Assert
        assertFalse(result);
    }
}
