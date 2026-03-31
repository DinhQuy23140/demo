package com.example.demo.user.seed;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class UserSeeder {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public List<User> seed() {

        Faker faker = new Faker();
        Random random = new Random();

        String[] genders = {"male", "female"};
        String[] roles = {"teacher", "student", "admin"};

        List<User> users = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            LocalDate dob = faker.date()
                    .birthday(18, 60)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            User user = User.builder()
                    .fullname(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .phone(faker.phoneNumber().cellPhone())
                    .password(passwordEncoder.encode("123456"))
                    .dob(dob.toString())
                    .gender(genders[random.nextInt(genders.length)])
                    .address(faker.address().fullAddress())
                    .image("default-avatar.png")
                    .role(roles[random.nextInt(roles.length)])
                    .build();

            users.add(user);
        }

        return userRepository.saveAll(users);
    }
}
