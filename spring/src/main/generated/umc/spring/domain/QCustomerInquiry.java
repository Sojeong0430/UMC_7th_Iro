package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerInquiry is a Querydsl query type for CustomerInquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerInquiry extends EntityPathBase<CustomerInquiry> {

    private static final long serialVersionUID = 1522728413L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerInquiry customerInquiry = new QCustomerInquiry("customerInquiry");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCustomerInquiry(String variable) {
        this(CustomerInquiry.class, forVariable(variable), INITS);
    }

    public QCustomerInquiry(Path<? extends CustomerInquiry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerInquiry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerInquiry(PathMetadata metadata, PathInits inits) {
        this(CustomerInquiry.class, metadata, inits);
    }

    public QCustomerInquiry(Class<? extends CustomerInquiry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

