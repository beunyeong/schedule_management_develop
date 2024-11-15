package com.example.schedulemanagementdevelop.service;

import com.example.schedulemanagementdevelop.dto.ScheduleResponseDto;
import com.example.schedulemanagementdevelop.entity.Schedule;
import com.example.schedulemanagementdevelop.entity.User;
import com.example.schedulemanagementdevelop.repository.ScheduleRepository;
import com.example.schedulemanagementdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;


    // 1. 일정 저장 메서드 호출용
    public ScheduleResponseDto save(String title, String contents, String username) {

        User findUser = userRepository.findMemberByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents());
    }

    // 2. 전체 일정 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    //3. 선택 일정 조회
    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents());
    }


    //4. 일정 수정
    public  ScheduleResponseDto updateSchedule(Long id, String title, String contents) {
        // 1) 주어진 id로 수정할 schedule 찾기
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        // 2) 일정 데이터 수정
        findSchedule.setTitle(title);
        findSchedule.setContents(contents);

        // 3) 수정된 일정 저장
        scheduleRepository.save(findSchedule);

        //4. ScheduleResponseDto로 변환하여 반환
        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getTitle(),
                findSchedule.getContents()
        );

    }



    //5. 일정 삭제
    public void delete(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);

    }

}

