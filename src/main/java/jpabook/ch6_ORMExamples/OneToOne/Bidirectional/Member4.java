package jpabook.ch6_ORMExamples.OneToOne.Bidirectional;

import jpabook.ch6_ORMExamples.OneToOne.OneWay.Locker;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member4 {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String username;

    //1대1 관계 매핑 : 주 테이블에 외래키가 있는 경우
    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

}