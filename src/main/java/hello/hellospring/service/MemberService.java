package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    //service class의 경우 함수 이름을 개발적인 용어보다 진짜 비즈니스 적이고, 기획?스러운 네이밍을 하는 게 좋다고 한다.

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //control t 특정 코드 블록 함수로 추출하는 개꿀 기능,
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("member already exist");
                });
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        //findone? 진짜로?
        return memberRepository.findById(memberId);
    }


}
