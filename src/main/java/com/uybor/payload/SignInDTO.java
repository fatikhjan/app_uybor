package com.uybor.payload;

public record SignInDTO(
        String name,
        String userName,
        String email,
        String password,
        String rePassword

) {
}
