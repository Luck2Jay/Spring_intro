package cyj.hello_spring.repostiory;

import cyj.hello_spring.domain.Member;
import cyj.hello_spring.repository.MemberRepostiory;
import cyj.hello_spring.repository.MemoryMemberRepository;
import cyj.hello_spring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static cyj.hello_spring.repository.MemoryMemberRepository.store;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

//정상적으로 작동하는 지 검증하기 위한 테스트케이스
class MemoryMemberRepositoryTest {

    //테스트를 위한 저장소 repository 선언
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //method가 끝날 때마다 특정 동작
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member(); //member 객체 선언
        member.setName("Yupoong"); // 객체 name필드 저장

        //when
        repository.save(member);

        //then : member 객체의 id필드로 repository에서 객체를 찾아 result에 저장
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(result,member);

        //테스트에서 선언한 member객체와 repository에 저장된 객체가 같은 지 검증
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Yupoong IT");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Yupoong Ashulia");
        repository.save(member2);

        Member result = repository.findByName("Yupoong IT").get();
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Yupoong IT");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Yupoong Ashulia");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);

    }




}
