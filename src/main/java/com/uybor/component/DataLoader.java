package com.uybor.component;

import com.uybor.entity.User;
import com.uybor.repo.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private String init;

    private final PasswordEncoder encoder;
    private final AuthRepository authRepository;

    private final Environment environment;

    @Override
    public void run(String... args) throws Exception {
        init = environment.getProperty("spring.jpa.hibernate.ddl-auto");
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
