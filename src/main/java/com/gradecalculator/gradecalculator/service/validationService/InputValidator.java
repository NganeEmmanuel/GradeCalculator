package com.gradecalculator.gradecalculator.service.validationService;

public class InputValidator {
    public static boolean isDouble(String value){
        try {
            Double.parseDouble(value);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
