package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RestaurantRepository;
import umc.spring.validation.annotation.ExistRestraurant;

@Component
@RequiredArgsConstructor
public class RestraurantExistValidation implements ConstraintValidator<ExistRestraurant,Long>{

    private final RestaurantRepository restaurantRepository;
    @Override
    public void initialize(ExistRestraurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long values, ConstraintValidatorContext context) {

        boolean isValid = restaurantRepository.existsById(values);

        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
