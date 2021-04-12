package jpabook.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name="Member")
public class Member {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    private String name;

    private String city;
    private String street;
    private String zipcode;

    //연관관계의 주인은 mappedBy 속성을 사용하지 않는다
    //주인이 아니면 mappedBy 속성을 사용하고 주인의 필드 이름을 mappedBy 값으로 줘야 한다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders =  new ArrayList<>();
}

