package jpabook.ch6_ORMExamples.ManyToOne.OneWay;

import jpabook.ch5_ORMBasic.Team;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member2 {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne  //매핑 관계 설정시에 필수 어노테이션
    @JoinColumn(name="TEAM_ID") //JoinColumn(외래키)은 외래키를 매핑할 때 사용. 생략 가능한 어노테이션
    private Team team;



}
