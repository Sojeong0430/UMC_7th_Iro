package umc.spring.domain;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.common.BaseEntity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //해당클래스가 JPA의 엔티티임을 명시
@Getter //getter를 만들어주는 어노테이션
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor //빌더패턴

public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    private Integer reward; // 리워드

    private LocalDate deadline; // 마감일

    @Column(nullable = false, length = 100)
    private String missionBody; // 미션 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; // 식당

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>(); // MemberMission 양방향 연관관계 매핑

}