package jpabook.ch5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor
@Getter
@Setter
@Entity(name = "jpabook.ch5.Team")
public class Team {
    @Id
    @Column(name="TEAM_ID")
    private String id;

    private String name;

    // ==추가== //
    //양방향 연관관계 매핑을 위해. 기존의 회원 ->팀 뿐만 아니라
    //회원들 <-팀도 매핑하기 위해.
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

}
