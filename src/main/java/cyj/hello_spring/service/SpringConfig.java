package cyj.hello_spring.service;

import cyj.hello_spring.repository.MemberRepostiory;
import cyj.hello_spring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepostiory());
    }

    @Bean
    public MemberRepostiory memberRepostiory(){
        return new MemoryMemberRepository();
    }
}
