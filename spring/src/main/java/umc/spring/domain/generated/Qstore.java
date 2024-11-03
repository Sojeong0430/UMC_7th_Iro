package umc.spring.domain.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import umc.spring.domain.review;
import umc.spring.domain.store;


/**
 * Qstore is a Querydsl query type for store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qstore extends EntityPathBase<umc.spring.domain.store> {

    private static final long serialVersionUID = 1188017109L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qstore store = new Qstore("store");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final Qregion region;

    public final ListPath<review, Qreview> reviewList = this.<review, Qreview>createList("reviewList", review.class, Qreview.class, PathInits.DIRECT2);

    public final NumberPath<Float> score = createNumber("score", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public Qstore(String variable) {
        this(store.class, forVariable(variable), INITS);
    }

    public Qstore(Path<? extends store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qstore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qstore(PathMetadata metadata, PathInits inits) {
        this(store.class, metadata, inits);
    }

    public Qstore(Class<? extends store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new Qregion(forProperty("region")) : null;
    }

}

