package cyj.hello_spring.repository;

import cyj.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepostiory{

   //Map<key,value>
    public static Map<Long,Member> store = new HashMap<>(); //회원을 저장할 DB라고 생각하면 됨
    private static long sequence = 0L; // 여기서 sequence는 key값, long에서는 0을 0l이라 표현

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //ID 세팅
        store.put(member.getId(),member); //store에 저장하면 map에 저장됨
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()  //values() : value만 가져옴,
               .filter(member->member.getName().equals(name)).findAny(); // 반복문 돌려서 찾아지면 꺼냄
    }

    @Override
    public List<Member> findAll() { // 실무에서 리스트 많이 사용
        return new ArrayList<>(store.values()); // 멤버 리스트 반환
    }

    public void clearStore() {
        store.clear();
    }


}
