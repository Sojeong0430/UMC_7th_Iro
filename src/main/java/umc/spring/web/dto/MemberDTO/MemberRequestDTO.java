package umc.spring.web.dto.MemberDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank //검증 조건
        String name;

        @NotBlank
        @Email
        String email;

        @NotNull
        String password;

        @NotNull
        Integer gender;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

        @Size(min = 5, max = 12)
        String address;

        @Size(min = 5, max = 12)
        String specAddress;

        @NotNull
        Role role;

        @ExistCategories //커스텀 어노테이션
        List<Long> perferCategory;
    }
}
