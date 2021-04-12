package jpabook.ch5_ORMBasic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name="jpabook.ch5.Member")
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

//    public Member(String id,String username){
//        this.id=id;
//        this.username=username;
//    }
}
