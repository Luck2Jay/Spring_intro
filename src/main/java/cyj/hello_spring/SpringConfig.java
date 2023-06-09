package cyj.hello_spring;

import cyj.hello_spring.aop.TimeTraceAop;
import cyj.hello_spring.repository.*;
import cyj.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em=em;
//    }
    private final MemberRepostiory memberRepostiory;

    public SpringConfig(MemberRepostiory memberRepostiory) {
        this.memberRepostiory = memberRepostiory;
    }


//    @Bean
//    public TimeTraceAop timeTraceAop(){
//
//        return new TimeTraceAop();
//    }

 @Bean
    public MemberService memberService() {
        return new MemberService(memberRepostiory);
    }

//@Bean
//    public MemberRepostiory memberRepository() {
//        // return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//
//    }


}