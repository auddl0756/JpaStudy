package jpabook.ch6_ORMExamples.OneToOne.Bidirectional;

import jpabook.ch6_ORMExamples.OneToOne.OneWay.Locker;

import javax.persistence.*;

@Entity
public class Member4_2 {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String username;

    @OneToOne(mappedBy = "member")
    //@JoinColumn(name="LOCKER_ID")
    private Locker locker;
}
