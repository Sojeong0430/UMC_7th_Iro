package umc.spring.domain.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import umc.spring.domain.review;


/**
 * Qreview is a Querydsl query type for review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qreview extends EntityPathBase<umc.spring.domain.review> {

    private static final long serialVersionUID = -1868457244L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qreview review = new Qreview("review");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final Qstore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public Qreview(String variable) {
        this(review.class, forVariable(variable), INITS);
    }

    public Qreview(Path<? extends review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qreview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qreview(PathMetadata metadata, PathInits inits) {
        this(review.class, metadata, inits);
    }

    public Qreview(Class<? extends review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.store = inits.isInitialized("store") ? new Qstore(forProperty("store"), inits.get("store")) : null;
    }

}

