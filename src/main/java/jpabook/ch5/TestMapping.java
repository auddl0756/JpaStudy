package jpabook.ch5;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class TestMapping {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();

        try{
            transaction.begin();
            //testSave(manager);
//            testFind(manager);
            //testFindBy_JPQL(manager);

            //testUpdateRelation(manager);

            //testRemoveRelation(manager);
             //testRemoveEntity(manager);

            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            manager.close();
        }

        factory.close();
    }

    //모든 연관관계 지우고 엔티티 제거해야 함. 아니면 나중에 없는 팀을 참조하려고 하면 널포인터 에러 발생 함.
    public static void testRemoveEntity(EntityManager manager){
        Team team = manager.find(jpabook.ch5.Team.class,"team1");
        manager.remove(team);
    }

    //연관관계 삭제하기. member1이라는 기본키를 가지는 멤버의 팀 소속 없애기
    public static void testRemoveRelation(EntityManager manager){
        Member member = manager.find(jpabook.ch5.Member.class,"member1");

        //update에서와 동일하게 이렇게 해주면 트랜잭션 커밋할 때 변경을 감지하고 자동으로 DB에도 반영해줌!!!!
        member.setTeam(null);
    }

    //멤버 찾아서 팀 바꾸기
    public static void testUpdateRelation(EntityManager manager){
        Team team2 = new Team();
        team2.setId("team2");
        team2.setName("팀2");

        manager.persist(team2);

        Member member = manager.find(jpabook.ch5.Member.class,"member1");
        member.setTeam(team2);
    }

    //JPQL로 어떤 팀의 모든 멤버 찾기!
    public static void testFindBy_JPQL(EntityManager manager){
        String jpql = "select m from jpabook.ch5.Member m join m.team t where t.name=:teamName";

        List<Member> results = manager.createQuery(jpql,jpabook.ch5.Member.class)
                                        .setParameter("teamName","팀1")
                                        .getResultList();

        //Collector활용해서 결과 문자열 만들어봤음..ㅋ
        String result = results.stream()
                                .map(Member::getUsername)
                                .collect(Collectors.joining(" , "));

        System.out.println(result);
    }

    //객체 그래프 탐색 방법. 그래프 탐색이라는 이름이 좀 이상하긴 한데.. 왜 굳이 이런 이름으로 부를까
    public static void testFind(EntityManager manager){
        Member member=manager.find(jpabook.ch5.Member.class,"member2");
        Team team = member.getTeam();
        System.out.println("team name = "+team.getName());
    }

    //제약조건 위반 주의!
    public static void testSave(EntityManager manager){
        //팀 1 저장
        //Team team1 = new Team("team1","팀1");
//        Team team1 = new Team();
//        team1.setId("team1");
//        team1.setName("팀1");
//
//        manager.persist(team1);

        Team team1 = manager.find(jpabook.ch5.Team.class,"team1");
//        System.out.println(team1.getId()+" "+team1.getName());

//        //회원1 저장
//        //Member member1 = new Member("member1","회원1");
//        Member member1 = new Member();
//        member1.setId("member1");
//        member1.setUsername("회원1");
//        member1.setTeam(team1);
//
//        manager.persist(member1);
//
//        //회원2 저장
//        //Member member2 = new Member("member2","회원2");
        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.setTeam(team1);

        manager.persist(member2);
    }
}
