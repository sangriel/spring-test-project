package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    MemoryMemberRepository repository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void join() {
        //give
        Member member = new Member();
        member.setName("test");

        //when
        Long saveId = memberService.join(member);

        //then
        Member result = memberService.findOne(saveId).get();

        assertThat(result).isEqualTo(member);
    }

    @Test
    void joinDuplicateMemberException() {
        //give
        Member member1 = new Member();
        member1.setName("test");

        Member member2 = new Member();
        member2.setName("test");

        //when
        Long mem1SaveId = memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
        // throw message까지 검증을 원하면 IllegalStateException e = 로 exception 받고 에러 메세지 비교하면 됨

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}