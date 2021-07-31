package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();


    @AfterEach      //테스트가 끝나면 초기화 해주기 위한 코드, 초기화 하지 않으면 데이터가 저장되어 여러 테스트 하는데 문제 발생
    void afterEach(){
        memberRepository.clearStroe();
    }

    @Test
    void save(){
        //given : 이런게 주어졌을때
        Member member = new Member("hello", 20);

        //when  : 이런걸 실행했을때
        Member saveMember = memberRepository.save(member);

        //then  : 결과가 이거여야 해
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);        //findMember 는 saveMember와 같아야한다.

    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1); //member1 저장
        memberRepository.save(member2); //member2 저장

        //when
        List<Member> result = memberRepository.findAll();

        //then
        //Assertions.assertThat(result.size()).isEqualTo(2);
        assertThat(result.size()).isEqualTo(2);      //result 사이즈가 2가 되야함
        assertThat(result).contains(member1, member2);  //result 안에 member1, member2가 있는지 확인

    }

}
