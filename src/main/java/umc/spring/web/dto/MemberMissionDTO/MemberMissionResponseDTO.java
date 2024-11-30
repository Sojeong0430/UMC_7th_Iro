package umc.spring.web.dto.MemberMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewDTO{
        Long memberMissionId; //진행 중인 미션 Id
        Long memberId; //미션 Id
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreViewListDTO{
        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> MemberMissionList; //진행 중인 미션 리스트
        Integer listSize; //반환된 데이터의 개수
        Integer totalPage; //생성된 페이지의 총 개수
        Long totalElements; //전체 데이커의 총 개수
        Boolean isFirst; //현재 페이지가 첫 페이지인지
        Boolean isLast; //현재 페이지가 마지막 페이지인지
    }

}
