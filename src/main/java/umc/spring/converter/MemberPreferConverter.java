package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.Mapping.MemberPreferFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPreferFood> toMemberPreferList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPreferFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
