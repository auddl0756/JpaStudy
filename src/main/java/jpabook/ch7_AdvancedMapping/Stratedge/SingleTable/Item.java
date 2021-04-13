package jpabook.ch7_AdvancedMapping.Stratedge.SingleTable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE")
public abstract class Item {
    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
}

@Entity
@DiscriminatorValue("A")
class Album extends Item{}

@Entity
@DiscriminatorValue("M")
class Movie extends Item{}

@Entity
@DiscriminatorValue("B")
class Book extends Item{}


