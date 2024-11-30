package umc.spring.validation.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.Resolver.CheckPageResolver;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션
@Constraint(validatedBy = CheckPageResolver.class)
@Target({ ElementType.PARAMETER}) //파라미터에 적용
@Retention(RetentionPolicy.RUNTIME) //런타임 동안 유지
public @interface CheckPage {
    String message() default "페이지 번호는 1보다 커야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
