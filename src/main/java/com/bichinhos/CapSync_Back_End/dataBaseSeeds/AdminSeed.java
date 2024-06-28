package com.bichinhos.CapSync_Back_End.dataBaseSeeds;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.bichinhos.CapSync_Back_End.enumFields.Status.ATIVO;

@Configuration
@Component
public class AdminSeed implements CommandLineRunner {

        private final IUserRepository iUserRepository;

        PasswordEncoder passwordEncoder;

        public AdminSeed(IUserRepository iUserRepository, PasswordEncoder passwordEncoder) {
            this.iUserRepository = iUserRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        @Transactional
        public void run(String... args) {
            seedUsers();
        }

        private void seedUsers() {
            if (this.iUserRepository.count() == 0) {
                UserEntity admin = new UserEntity();
                admin.setName("Rannah");
                admin.setEmail("rannah@gmail.com");
                admin.setPassword(passwordEncoder.encode("Rannah123456*"));
                admin.setCellphone("rannah@gmail.com");
                admin.setDiscord("Rannah#1234");
                admin.setCellphone("+55 11 99543 5698");
                admin.setRole(admin.getRole());
                admin.setLinkedin("www.linkedin.com/in/rannah");
                admin.setStatus(ATIVO);

                this.iUserRepository.save(admin);

                System.out.println("Database has been seeded");
            } else {
                System.out.println("Database already seeded");
            }
    }


}
