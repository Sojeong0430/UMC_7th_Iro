package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Mapping.MemberPreferFood;
import umc.spring.domain.Member;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){ //MemberRequestDTO.JoinDto타입의 request객체를 받아,

        Member newMember = MemberConverter.toMember(request); //MemberConverter.toMember를 호출하여 Member객체로 변환한다.

        List<FoodCategory> foodCategoryList = request.getPerferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPreferFood> memberPreferFoodList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferFoodList.forEach(memberPreferFood -> {memberPreferFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
