package umc.spring.domain.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import umc.spring.domain.food_category;


/**
 * Qfood_category is a Querydsl query type for food_category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qfood_category extends EntityPathBase<umc.spring.domain.food_category> {

    private static final long serialVersionUID = 681669299L;

    public static final Qfood_category food_category = new Qfood_category("food_category");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public Qfood_category(String variable) {
        super(food_category.class, forVariable(variable));
    }

    public Qfood_category(Path<? extends food_category> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qfood_category(PathMetadata metadata) {
        super(food_category.class, metadata);
    }

}

