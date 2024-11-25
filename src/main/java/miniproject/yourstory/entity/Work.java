package miniproject.yourstory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.locks.Condition;

@Entity
@Getter
@Setter
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 센터명

    private String state; // 모집 상태

    private LocalDate recruitmentStart; // 모집 기간 시작

    private LocalDate recruitmentEnd; // 모집 기간 끝

    private int period; // 봉사 기간

    private String org; // 등록 기관

    private String day; // 봉사 요일

    private String place; // 봉사 장소

    private int person; // 모집 인원

    private String manager; // 담당자

    private LocalTime startTime; // 봉사 시간 시작

    private LocalTime endTime; // 봉사 시간 끝

    private String content; // 내용

    // 시작한 지 N일째 계산
    public long getDaysSinceStart() {
        return ChronoUnit.DAYS.between(startTime, LocalDate.now());
    }
}
