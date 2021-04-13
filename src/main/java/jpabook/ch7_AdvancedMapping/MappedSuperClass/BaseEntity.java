package jpabook.ch7_AdvancedMapping.MappedSuperClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//Designates a class whose mapping information is applied to the entities that inherit from it.
// A mapped superclass has no separate table defined for it.
@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;

}

@Entity
class Member extends BaseEntity{
    //id,name 상속
    private String email;
}

@Entity
class Seller extends BaseEntity{
    //id,name 상속
    private String shopName;
}
