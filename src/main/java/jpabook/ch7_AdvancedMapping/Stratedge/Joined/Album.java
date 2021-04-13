package jpabook.ch7_AdvancedMapping.Stratedge.Joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item{
    private String artist;
}
