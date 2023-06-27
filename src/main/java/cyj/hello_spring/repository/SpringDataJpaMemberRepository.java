package cyj.hello_spring.repository;

import cyj.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepostiory {
    @Override
    Optional<Member> findByName(String name);

}
