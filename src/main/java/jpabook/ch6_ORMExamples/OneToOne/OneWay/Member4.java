package jpabook.ch6_ORMExamples.OneToOne.OneWay;

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

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

}
