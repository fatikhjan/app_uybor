package com.uybor.service;

import com.uybor.entity.User;
import com.uybor.exeptions.DuplicateUserException;
import com.uybor.exeptions.PasswordMatchExemption;
import com.uybor.payload.SignInDTO;
import com.uybor.repo.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public HttpEntity<Boolean> register(SignInDTO signInDTO) {
        if (authRepository.existUserByUserName(signInDTO.userName())) {
            throw new DuplicateUserException("UserName exist , try user another one");
        }
        if (!signInDTO.password().equals(signInDTO.rePassword()))
            throw new PasswordMatchExemption("Passwords are not equal");

        User user = User.builder()
                .name(signInDTO.name())
                .userName(signInDTO.userName())
                .email(signInDTO.email())
                .password(signInDTO.password())
                .role("USER")
                .build();

        authRepository.save(user);
        return new HttpEntity<>(true);
    }
}
