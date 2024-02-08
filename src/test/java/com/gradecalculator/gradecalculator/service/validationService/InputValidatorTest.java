package com.gradecalculator.gradecalculator.service.validationService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {
    @Test
    public void testIsDouble_withValidDouble_returnsTrue() {
        // Arrange
        String validDouble = "3.14";

        // Act
        boolean result = InputValidator.isDouble(validDouble);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsDouble_withInvalidDouble_returnsFalse() {
        // Arrange
        String invalidDouble = "abc";

        // Act
        boolean result = InputValidator.isDouble(invalidDouble);

        // Assert
        assertFalse(result);
    }
}
