package jpabook.ch6_ORMExamples.OneToMany.OneWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
    EntityManagerFactory factory;
    EntityManager manager;
    EntityTransaction transaction;

    public static void main(String[] args) {

    }


    public static void testSave(){
        Member3 member1 = new Member3();
        Member3 member2 = new Member3();

        Team3 team1 = new Team3();
        team1.setName("team1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

//        manager.persist(member1);
//        manager.persist(member2);

        //여기서 내부적으로(실제 SQL은)  Insert(team),Update(member1.fk),Update(member2.fk)가 일어남
        //1:N인데 1이 주인이다 보니..
//        manager.persist(team1);
//        transaction.commit();

    }
}
