package umc.spring.web.dto.MissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Restaurant;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionDTO{
        @NotNull
        String missionBody;
        @NotNull
        LocalDate deadline;
        @NotNull
        Integer reward;
    }//특정 가게 미션 추가

    @Getter
    public static class AddMemberMissionDTO{
        @NotNull
        Long MissionId;
    }//도전중인 미션으로 등록

}
