package jpabook.ch5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@AllArgsConstructor
@Getter
@Setter
@Entity(name = "jpabook.ch5.Team")
public class Team {
    @Id
    @Column(name="TEAM_ID")
    private String id;

    private String name;
}
