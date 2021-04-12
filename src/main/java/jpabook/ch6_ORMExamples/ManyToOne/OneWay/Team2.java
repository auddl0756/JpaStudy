package jpabook.ch6_ORMExamples.ManyToOne.OneWay;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Team2 {
    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;
}
