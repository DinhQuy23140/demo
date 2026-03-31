package com.example.demo.department.seed;

import com.example.demo.user.entity.Research;
import com.example.demo.user.entity.User;
import com.example.demo.user.entity.UserReseach;
import com.example.demo.user.repository.ResearchRepository;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.repository.UserResearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class UserResearchSeeder {
    private final UserRepository userRepository;
    private final ResearchRepository researchRepository;
    private final UserResearchRepository userResearchRepository;

    public List<UserReseach> seed() {
        Random random = new Random();
        List<User> users = userRepository.findAll();
        List<Research> researchList = researchRepository.findAll();
        List<UserReseach> userReseachList = new ArrayList<>();

        // defensive: nếu không có dữ liệu nguồn thì không tạo record
        if (users.isEmpty() || researchList.isEmpty()) {
            return userResearchRepository.saveAll(userReseachList);
        }

        // tạo 20 bản ghi (hoặc bạn có thể điều chỉnh số lượng)
        for (int index = 0; index < 20; index++) {
            User user = users.get(random.nextInt(users.size()));
            Research research = researchList.get(random.nextInt(researchList.size()));
            UserReseach userReseach = UserReseach.builder()
                    .user(user)
                    .research(research)
                    .build();
            userReseachList.add(userReseach);
        }
        return userResearchRepository.saveAll(userReseachList);
    }
}