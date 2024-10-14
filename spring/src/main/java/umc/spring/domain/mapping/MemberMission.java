package umc.spring.domain.mapping;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Member;
import umc.spring.domain.mission;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.enums. * ;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private mission mission;
}
