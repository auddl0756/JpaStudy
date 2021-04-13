package jpabook.ch6_ORMExamples.OneToOne.Bidirectional;

import javax.persistence.*;

@Entity
public class Locker2 {
    @Id
    @GeneratedValue
    @Column(name="LOCKER_ID")
    private Long id;

    private String name;

    //1대1 관계 매핑 : 대상 테이블에 외래키가 있는 경우
    @OneToOne
    @JoinColumn(name="MEMBER_ID")
    private Member4_2 member;
}
