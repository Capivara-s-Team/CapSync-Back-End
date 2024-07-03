package com.bichinhos.CapSync_Back_End.dataBaseSeeds;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import com.bichinhos.CapSync_Back_End.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.bichinhos.CapSync_Back_End.enumFields.Seniority.SENIOR;
import static com.bichinhos.CapSync_Back_End.enumFields.Status.ATIVO;

@Configuration
@Component
public class DataBaseSeed implements CommandLineRunner {

        private final IUserRepository iUserRepository;

        PasswordEncoder passwordEncoder;

        public DataBaseSeed(IUserRepository iUserRepository, PasswordEncoder passwordEncoder) {
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
                admin.setDiscord("Rannah#1234");
                admin.setCellphone("+55 11 99543 5698");
                admin.setRole(admin.getRole().ADMIN);
                admin.setLinkedin("www.linkedin.com/in/rannah");
                admin.setSquad("FRONT-END");
                admin.setSeniority(SENIOR);
                admin.setStatus(ATIVO);

                UserEntity member = new UserEntity();
                member.setName("Gustavo");
                member.setEmail("gustavo@gmail.com");
                member.setPassword(passwordEncoder.encode("Gu3214596*"));
                member.setCellphone("+55 11 99543 9876");
                member.setDiscord("Gustavo#2212");
                member.setRole(admin.getRole().MEMBRO);
                member.setLinkedin("www.linkedin.com/in/gustavo");
                member.setSquad("BACK-END");
                member.setSeniority(SENIOR);
                member.setStatus(ATIVO);

                this.iUserRepository.save(member);
                this.iUserRepository.save(admin);

                System.out.println("Database has been seeded");
            } else {
                System.out.println("Database already seeded");
            }
    }


}
