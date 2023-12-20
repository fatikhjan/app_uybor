package com.uybor.exeptions;

public class PasswordMatchExemption extends RuntimeException {
    public PasswordMatchExemption(String mes) {
        super(mes);
    }
}
