package hello.login.web.session;

import hello.login.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        //세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        //서버에서 쿠키를 response에 담은 후 웹 브라우저에서 전송
        sessionManager.createSession(member, response);

        //웹브라우저에서 서버에서 전송 받은 쿠키 값을 받아 요청 시 서버로 전송
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());//mySessionId=12313-123-1231231..

        //세션 조회
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        //세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();


    }



}