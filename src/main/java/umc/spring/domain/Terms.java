package umc.spring.domain;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Mapping.MemberAgree;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity //해당클래스가 JPA의 엔티티임을 명시
@Getter //getter를 만들어주는 어노테이션
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor //빌더패턴

public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    @Column(nullable = false, length = 50)
    private String title; // 제목

    @Column(nullable = false, length = 2000)
    private String content; // 본문

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>(); // MemberAgree 양방향 연관관계 매핑

}