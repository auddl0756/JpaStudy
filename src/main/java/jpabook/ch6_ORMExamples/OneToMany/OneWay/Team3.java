package jpabook.ch6_ORMExamples.OneToMany.OneWay;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team3 {
    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

    //외래키가 Member테이블에 있다..?
    @OneToMany
    @JoinColumn(name="TEAM_ID")
    private List<Member3> members = new ArrayList<>();
}
