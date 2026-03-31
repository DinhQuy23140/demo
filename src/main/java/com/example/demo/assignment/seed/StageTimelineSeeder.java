package com.example.demo.assignment.seed;

import com.example.demo.assignment.entity.ProjectTerm;
import com.example.demo.assignment.entity.StageTimeline;
import com.example.demo.assignment.repository.ProjectTermRepository;
import com.example.demo.assignment.repository.StageTimelineRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StageTimelineSeeder {
    private final ProjectTermRepository projectTermRepository;
    private final StageTimelineRepository stageTimelineRepository;

    public List<StageTimeline> seed() {

        Faker faker = new Faker();

        List<ProjectTerm> projectTerms = projectTermRepository.findAll();
        List<StageTimeline> timelines = new ArrayList<>();

        for (ProjectTerm projectTerm : projectTerms) {

            LocalDate start = LocalDate.now().minusDays(
                    faker.number().numberBetween(5, 20)
            );

            for (int round = 1; round <= 8; round++) {

                LocalDate end = start.plusDays(
                        faker.number().numberBetween(5, 10)
                );

                StageTimeline timeline = StageTimeline.builder()
                        .projectTerm(projectTerm)
                        .numberOfRound(round)
                        .startDate(start.toString())
                        .endDate(end.toString())
                        .description("Round " + round + " timeline")
                        .build();

                timelines.add(timeline);

                start = end.plusDays(1);
            }
        }
        return stageTimelineRepository.saveAll(timelines);
    }
}
