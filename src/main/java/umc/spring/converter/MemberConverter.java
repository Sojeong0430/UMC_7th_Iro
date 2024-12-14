package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;
import umc.spring.web.dto.MemberDTO.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){ //멤버 생성

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
        }

        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())
                .password(request.getPassword())
                .gender(gender)
                .name(request.getName())
                .memberPreferFoodList(new ArrayList<>())
                .role(request.getRole())
                .build();
    }


}
