package jpabook.ch6_ORMExamples.OneToMany.Bidirectional;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member3 {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="TEAM_ID",insertable = false,updatable = false)
    //in javax.persistence.JoinColumn
    // public abstract boolean insertable(),updatable()=false :: 읽기 전용으로 만드는
    private Team3 team;

}
