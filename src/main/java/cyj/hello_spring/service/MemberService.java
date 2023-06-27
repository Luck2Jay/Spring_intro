package cyj.hello_spring.service;

import cyj.hello_spring.domain.Member;
import cyj.hello_spring.repository.MemberRepostiory;
import cyj.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
//회원 repository와 domain을 활용하여 작성한 비즈니스 로직인 회원 서비스
@Transactional
public class MemberService {

    private final MemberRepostiory memberRepostiory ;

  //  @Autowired
    //Constructor, 외부에서 넣어주도록
    public MemberService(MemberRepostiory memberRepostiory) {
        this.memberRepostiory = memberRepostiory;
    }


    //회원가입
    public Long join(Member member){
        //중복 이름 가입 x,
//        Optional<Member> result = memberRepostiory.findByName(member.getName());
//        result.ifPresent(m->{ // ifpresent : null이 아니라 어떠한 값이 있으면 ,,, 멤버에 값이 있으면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        //중복회원 검증 메서드
        validateDuplicateMember(member);

        // 검증된 객체 저장소에 저장
        memberRepostiory.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepostiory.findByName(member.getName()) // cmd opt v
                .ifPresent(m->{ // ifpresent : null이 아니라 어떠한 값이 있으면 ,,, 멤버에 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepostiory.findAll();
    }
    //id로 회원 조회
    public Optional<Member> findOne(Long memberID){
        return memberRepostiory.findById(memberID);
    }

}
