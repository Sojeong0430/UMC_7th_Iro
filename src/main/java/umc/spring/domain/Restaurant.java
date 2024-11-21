package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import umc.spring.domain.common.BaseEntity;

@Entity //해당클래스가 JPA의 엔티티임을 명시
@Getter //getter를 만들어주는 어노테이션
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region; // 지역

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>(); //Mission 양방향 연관관계 매핑

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>(); //Review 양방향 연관관계 매핑

    @Column(nullable = false, length = 50)
    private String name; // 이름

    @Column(nullable = false, length = 150)
    private String address; // 주소

    private Float score; //점수
 }