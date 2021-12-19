package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    MemberRepository memberRepository = new MemberRepository();
    LoginService loginService = new LoginService(memberRepository);

    @Test
    void login() {
        Member member1 = new Member();
        member1.setLoginId("test1");
        member1.setPassword("test1!");
        member1.setName("테스터1");

        Member member2 = new Member();
        member2.setLoginId("test2");
        member2.setPassword("test2!");
        member2.setName("테스터2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        Member login = loginService.login("test1", "test1!");
        System.out.println("login = " + login);

        Optional<String> optVal = Optional.of("ABC");
        System.out.println("optVal = " + optVal);
        String str1 = optVal.get();
        System.out.println("str1 = " + str1);
        System.out.println("str1 = " + str1.getClass().getName());


    }



}