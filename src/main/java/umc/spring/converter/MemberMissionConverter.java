package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemberMissionConverter {
    public static MissionResponseDTO.AddMemberMissionResultDTO addMemberMissionResultDTO(MemberMission memberMission){
        return MissionResponseDTO.AddMemberMissionResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .MemberId(memberMission.getMember().getId())
                .MissionId(memberMission.getMission().getId())
                .build();
    }//응답

    public static MemberMission toMemberMission(Member member, Mission mission){

        @ExistMemberMission
        MemberMission memberMission =  MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return memberMission;

    }//DTO -> MemberMission

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO memberMissionPreviewDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreViewListDTO memberMissionPreViewListDTO(Page<MemberMission> memberMissionList){

        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionPreviewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::memberMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreViewListDTO.builder()
                .MemberMissionList(memberMissionPreviewDTOList)
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreviewDTOList.size())
                .build();
    }
}
