package cyj.hello_spring;

import cyj.hello_spring.repository.JdbcMemberRepository;
import cyj.hello_spring.repository.MemberRepostiory;
import cyj.hello_spring.repository.MemoryMemberRepository;
import cyj.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

 @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

@Bean
    public MemberRepostiory memberRepository() {
// return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }


}