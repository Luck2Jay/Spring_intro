package cyj.hello_spring.service;

import cyj.hello_spring.domain.Member;
import cyj.hello_spring.repository.MemberRepostiory;
import cyj.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 트랜잭션 실행 후 롤백해버림
class MemberServiceIntegrationTest {

    //테스트
    @Autowired MemberService memberService;
    @Autowired MemberRepostiory memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member(); //member 객체 생성
        member.setName("spring"); //member name으로 hello 지정

        //when
        Long saveId = memberService.join(member); //member객체를 join(회원가입)하고, 반환된 id를 saveId

        //then
        //회원가입한 member의 id가 저장소에 있으면, 해당 member객체를 findmember에 지정
        Member findMember = memberService.findOne(saveId).get();
        //회원가입한 member와 저장소에서 가져온 member의 이름이 같은 지 검증
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        //이름이 같은 중복 회원 member 객체 생성
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // 중복회원이 존재할 때 나오는 경고문이 같은 지 확인하는 테스트 케이스
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

}