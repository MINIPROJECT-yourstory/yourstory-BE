package miniproject.yourstory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miniproject.yourstory.entity.Work;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDto {

    private Long id;
    private String title;
    private String state;
    private String recruitmentStart;
    private String recruitmentEnd;
    private String period;
    private String org;
    private String day;
    private String place;
    private int person;
    private Long daysSinceStart;

    // Work 엔티티를 WorkDTO로 변환하는 메서드
    public static WorkDto fromEntity(Work work) {
        return new WorkDto(
                work.getId(),
                work.getTitle(),
                work.getState(),
                work.getRecruitmentStart().toString(),
                work.getRecruitmentEnd().toString(),
                String.valueOf(work.getPeriod()),
                work.getOrg(),
                work.getDay(),
                work.getPlace(),
                work.getPerson(),
                work.getDaysSinceStart()
        );
    }
}
