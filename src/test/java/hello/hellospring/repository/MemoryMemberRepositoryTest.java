package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(result, member);
        //요즘은 아래께 대세인가봄?
        //option enter치면 static import되는 개쩌는 기능이?
        //성능상의 하자나 그런건 아예 없는가?
        assertThat(member).isEqualTo(result);
    }
}
