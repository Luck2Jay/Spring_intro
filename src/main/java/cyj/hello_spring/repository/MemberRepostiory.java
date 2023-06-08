package cyj.hello_spring.repository;

import cyj.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepostiory {
    Member save(Member member); // 저장소에 회원 저장
    Optional<Member> findById(Long ID); // 저장소에서 id를 찾아 member 객체 반환 & Null이 반환되면 옵션널로 감싸서 반환
    Optional<Member> findByName(String Name);// 저장소에서 name을 찾아 member 객체 반환
    List<Member> findAll(); // 저장된 모든 회원의 member List 반환
}
