package umc.spring.web.dto.MissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResultDTO{
        Long missionId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMemberMissionResultDTO{
        Long MemberMissionId;
        Long MissionId;
        Long MemberId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDTO{
        Long missionId; //미션ID
        String content; //미션 내용
        Integer reward; //포인트
        LocalDate deadLine; //마감일
    }//가게 미션 DTO

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListDTO{
        List<MissionPreviewDTO> missionList; //미션 리스트
        Integer listSize; //반환된 데이터의 개수
        Integer totalPage; //생성된 페이지의 총 개수
        Long totalElements; //전체 데이커의 총 개수
        Boolean isFirst; //현재 페이지가 첫 페이지인지
        Boolean isLast; //현재 페이지가 마지막 페이지인지
    }//가게 미션 리스트 DTO
}
