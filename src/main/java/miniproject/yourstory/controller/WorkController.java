package miniproject.yourstory.controller;

import lombok.RequiredArgsConstructor;
import miniproject.yourstory.dto.ConditionDto;
import miniproject.yourstory.dto.WorkDto;
import miniproject.yourstory.entity.Condition;
import miniproject.yourstory.entity.Work;
import miniproject.yourstory.service.WorkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/work")
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;

    // 봉사 목록 조회
    @GetMapping
    public ResponseEntity<List<WorkDto>> getWorkList() {
        List<Work> works = workService.getWorkList();
        List<WorkDto> workDTOs = works.stream().map(WorkDto::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(workDTOs);
    }

    // 봉사 상세 조회
    @GetMapping("/{workId}")
    public ResponseEntity<WorkDto> getWorkDetail(@PathVariable Long workId) {
        Work work = workService.getWorkDetail(workId);
        return ResponseEntity.ok(WorkDto.fromEntity(work));
    }

    // 봉사 신청
    @PostMapping("/{workId}")
    public ResponseEntity<ConditionDto> applyForWork(@PathVariable Long workId,
                                                     @RequestParam String username) {
        Condition condition = workService.applyForWork(workId, username);
        return ResponseEntity.ok(ConditionDto.fromEntity(condition));
    }

    // 나의 봉사 현황 조회
    @GetMapping("/my-status")
    public ResponseEntity<List<ConditionDto>> getMyWorkStatus(@RequestParam String username) {
        List<Condition> conditions = workService.getMyWorkStatus(username);
        List<ConditionDto> conditionDTOs = conditions.stream()
                .map(ConditionDto::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(conditionDTOs);
    }


    // 지역/모집 상태/요일 필터링
    @GetMapping("/list")
    public ResponseEntity<List<WorkDto>> filterWorkList(@RequestParam(required = false) String sort,
                                                        @RequestParam(required = false) String dayOfWeek,
                                                        @RequestParam(required = false) String regions,
                                                        @RequestParam(required = false) String recruitmentStatus) {
        List<Work> works = workService.filterWorkList(dayOfWeek, regions, recruitmentStatus);
        List<WorkDto> workDTOs = works.stream().map(WorkDto::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(workDTOs);
    }
}
