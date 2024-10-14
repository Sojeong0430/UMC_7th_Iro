package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    private region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<review> reviewList = new ArrayList<>();
}
