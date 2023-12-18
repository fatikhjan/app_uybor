package com.uybor.component;

import com.uybor.entity.User;
import com.uybor.repo.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;

    private final PasswordEncoder encoder;
    private final AuthRepository authRepository;

    @Override
    public void run(String... args) throws Exception {
        if (init.equals("create-drop") || init.equals("create")) {
            authRepository.save(
                    User.builder()
                            .name("fotih")
                            .email("muhammad2004fotih@gmail.com")
                            .password("root123")
                            .role("ADMIN")
                            .build()
            );
        }


    }


}
