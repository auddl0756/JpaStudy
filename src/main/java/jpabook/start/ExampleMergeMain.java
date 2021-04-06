package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExampleMergeMain {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Member member = createMember("member1","leemr",1);
        member.setUsername("kim mr");
        mergeMember(member);
    }

    static Member createMember(String id,String username,int age){
        //first persistence context (영속성 컨텍스트) 시작
        EntityManager manager1 = factory.createEntityManager();
        EntityTransaction transaction1 = manager1.getTransaction();
        transaction1.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        member.setAge(age);

        manager1.persist(member);
        transaction1.commit();

        manager1.close();

        return member;
    }

    static void mergeMember(Member member){
        EntityManager manager2 = factory.createEntityManager();
        EntityTransaction transaction2 = manager2.getTransaction();

        transaction2.begin();
        Member mergeMember = manager2.merge(member);
        transaction2.commit();

        //준영속 상태 :: persistence context에는 없고 메모리에는 있는 상태
        System.out.println("member = "+member.getUsername());

        //영속 상태
        System.out.println("mergeMember = "+mergeMember.getUsername());

        System.out.println("manager2 contains member "+ manager2.contains(member));

        System.out.println("manager2 contains mergeMember "+ manager2.contains(mergeMember));

        manager2.close();
    }
}
