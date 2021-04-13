package jpabook.ch7_AdvancedMapping.Stratedge.TablePerClass;

import javax.persistence.*;

//Table per Class 전략은 Discriminator를 안 쓰넹
// 추천하지 않는 전략

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {
    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
}

@Entity
class Album extends Item{}

@Entity
class Movie extends Item{}

@Entity
class Book extends Item{}
