package umc.spring.domain.Mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberPreferFood is a Querydsl query type for MemberPreferFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberPreferFood extends EntityPathBase<MemberPreferFood> {

    private static final long serialVersionUID = -2039309644L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberPreferFood memberPreferFood = new QMemberPreferFood("memberPreferFood");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberPreferFood(String variable) {
        this(MemberPreferFood.class, forVariable(variable), INITS);
    }

    public QMemberPreferFood(Path<? extends MemberPreferFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberPreferFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberPreferFood(PathMetadata metadata, PathInits inits) {
        this(MemberPreferFood.class, metadata, inits);
    }

    public QMemberPreferFood(Class<? extends MemberPreferFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

