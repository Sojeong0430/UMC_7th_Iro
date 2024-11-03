package umc.spring.domain.generated;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import umc.spring.domain.terms;


/**
 * Qterms is a Querydsl query type for terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qterms extends EntityPathBase<umc.spring.domain.terms> {

    private static final long serialVersionUID = 1188496507L;

    public static final Qterms terms = new Qterms("terms");

    public final umc.spring.domain.base.QBaseEntity _super = new umc.spring.domain.base.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.MemberAgree, umc.spring.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.spring.domain.mapping.MemberAgree, umc.spring.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.spring.domain.mapping.MemberAgree.class, umc.spring.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final BooleanPath optional = createBoolean("optional");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public Qterms(String variable) {
        super(terms.class, forVariable(variable));
    }

    public Qterms(Path<? extends terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qterms(PathMetadata metadata) {
        super(terms.class, metadata);
    }

}

