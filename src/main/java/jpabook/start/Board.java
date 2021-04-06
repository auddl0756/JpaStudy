package jpabook.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키 생성 전략(Identity전략)
    //MySQL에서  기본키에 auto_increment를 사용한 경우에, @GeneratedValue를 이용
    // 그리고 persistence.xml에 hibernate.id.new_generator_mappings = true로 지정해줘야 함
    private Long id;



}


