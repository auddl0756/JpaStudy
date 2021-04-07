package jpabook.ch5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class TestMapping_Bidirectional {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try{
            transaction.begin();

            //FindMembersByTeam(manager);

            transaction.commit();
        }catch(Exception e){

            e.printStackTrace();
            transaction.rollback();
        }finally {
            manager.close();
        }
        factory.close();
    }


    //JPA만 사용한다면 주인(owner)에만 값을 넣어주면 되지만
    //JPA없이 객체로 프로그래밍 할 때를 고려해서
    //양쪽에 모두 값을 넣어주는 것이 제일 좋은 방법이다.
    public static void Save_Bidirectional(EntityManager manager){
        Team team1 = manager.find(jpabook.ch5.Team.class,"team1");

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.setTeam(team1);

        manager.persist(member1);
//
//        //회원2 저장
//        //Member member2 = new Member("member2","회원2");
        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.setTeam(team1);

        manager.persist(member2);
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);
    }

    //팀이 team1인 모든 회원 찾기! 양방향 매핑을 활용!
    // (team class에서 @OneToMany(mapped ="team") 적용, List<Member> 추가)
    public static void FindMembersByTeam(EntityManager manager){
        Team team = manager.find(jpabook.ch5.Team.class,"team1");
        List<Member> members = team.getMembers();

        String result = members.stream()
                                .map(Member::getUsername)
                                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}
