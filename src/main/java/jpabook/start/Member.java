package jpabook.start;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
//DDL에 unique 속성 추가 가능!
//unique 속성이란 ? : primary key를 제외한 필드들에 고유성을 강제할 때 사용.
@Table(name="MEMBER",uniqueConstraints = {@UniqueConstraint(
        name="NAME_AGE_UNIQUE",
        columnNames = {"NAME","AGE"}
)})
public class Member {

    @Id     //@Id는 엔티티 클래스의 필드를 DB 테이블의 기본키로 매핑한다
    @Column(name = "ID")
    private String id;

    //@Column의 nullable,length 속성 등으로 필드에 제약 조건을 추가할 수 있다!
    @Column(name = "NAME",nullable = false,length = 10)
    private String username;

    private Integer age;

    //=================추가=======================

    //Enum 타입은 @Enumerated이용해서 매핑
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //Date 타입은 @Temporal 이용해서 매핑
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //DB의 varchar이 아니라 CLOB 타입으로 지정하는 거라는데 CLOB 타입이 뭐지?
    @Lob
    private String description;
}

