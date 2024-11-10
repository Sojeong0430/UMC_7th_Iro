package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;


@Entity //해당클래스가 JPA의 엔티티임을 명시
@Getter //getter를 만들어주는 어노테이션
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor //빌더패턴

public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; // 유저

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; // 식당

    private Float score; // 점수

    @Column(nullable = false, length = 20)
    private String title; // 리뷰 제목

    @Column(nullable = false, length = 500)
    private String reviewBody; // 리뷰 본문

}
