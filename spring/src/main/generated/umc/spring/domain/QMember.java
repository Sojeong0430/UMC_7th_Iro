package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<CustomerInquiry, QCustomerInquiry> customerInquiryList = this.<CustomerInquiry, QCustomerInquiry>createList("customerInquiryList", CustomerInquiry.class, QCustomerInquiry.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.spring.domain.Mapping.MemberAgree, umc.spring.domain.Mapping.QMemberAgree> memberAgreeList = this.<umc.spring.domain.Mapping.MemberAgree, umc.spring.domain.Mapping.QMemberAgree>createList("memberAgreeList", umc.spring.domain.Mapping.MemberAgree.class, umc.spring.domain.Mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.Mapping.MemberMission, umc.spring.domain.Mapping.QMemberMission> memberMissionList = this.<umc.spring.domain.Mapping.MemberMission, umc.spring.domain.Mapping.QMemberMission>createList("memberMissionList", umc.spring.domain.Mapping.MemberMission.class, umc.spring.domain.Mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.Mapping.MemberPreferFood, umc.spring.domain.Mapping.QMemberPreferFood> memberPreferFoodList = this.<umc.spring.domain.Mapping.MemberPreferFood, umc.spring.domain.Mapping.QMemberPreferFood>createList("memberPreferFoodList", umc.spring.domain.Mapping.MemberPreferFood.class, umc.spring.domain.Mapping.QMemberPreferFood.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.MemberStatus> status = createEnum("status", umc.spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

