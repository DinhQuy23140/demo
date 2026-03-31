package com.example.demo.user.seed;

import com.example.demo.user.entity.Research;
import com.example.demo.user.repository.ResearchRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ResearchSeeder {
    private final ResearchRepository researchRepository;

    public List<Research> seed() {
        Faker faker = new Faker();
        List<Research> researchList = new ArrayList<>();
        for (int index = 0; index < 20; index ++) {
            Research research = Research.builder()
                    .name(faker.educator().course())
                    .description(faker.lorem().sentence())
                    .build();
            researchList.add(research);
        }
        return researchRepository.saveAll(researchList);
    }
}
