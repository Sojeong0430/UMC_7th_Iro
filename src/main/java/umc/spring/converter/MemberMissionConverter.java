package umc.spring.converter;

import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

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
}
