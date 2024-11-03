package umc.spring.domain.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import umc.spring.domain.region;
import umc.spring.domain.store;


/**
 * Qregion is a Querydsl query type for region
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qregion extends EntityPathBase<umc.spring.domain.region> {

    private static final long serialVersionUID = -1868903808L;

    public static final Qregion region = new Qregion("region");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<store, Qstore> storeList = this.<store, Qstore>createList("storeList", store.class, Qstore.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public Qregion(String variable) {
        super(region.class, forVariable(variable));
    }

    public Qregion(Path<? extends region> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qregion(PathMetadata metadata) {
        super(region.class, metadata);
    }

}

