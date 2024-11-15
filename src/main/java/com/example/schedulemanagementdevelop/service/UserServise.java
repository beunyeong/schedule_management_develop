package com.example.schedulemanagementdevelop.service;

import com.example.schedulemanagementdevelop.dto.ScheduleResponseDto;
import com.example.schedulemanagementdevelop.dto.SignUpResponseDto;
import com.example.schedulemanagementdevelop.dto.UserResponseDto;
import com.example.schedulemanagementdevelop.entity.Schedule;
import com.example.schedulemanagementdevelop.entity.User;
import com.example.schedulemanagementdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //생성자 주입 (userRepository)
public class UserServise {

    private final UserRepository userRepository;

    public static void delete(Long id) {
    }

    public SignUpResponseDto signUp(String username, String password, String email) {
        User user = new User(username, password, email);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(),savedUser.getUsername());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        // NPE 방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        User findMember = optionalUser.get();

        return new UserResponseDto(findMember.getUsername(), findMember.getEmail());
    }


    // 유저 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
