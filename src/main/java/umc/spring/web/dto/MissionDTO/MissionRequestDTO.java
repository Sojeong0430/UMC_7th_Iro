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
    }
}
