package jpabook.ch6_ORMExamples.OneToOne.Bidirectional;

import jpabook.start.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Locker {
    @Id
    @GeneratedValue
    @Column(name="LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member4 member;

}
