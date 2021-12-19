package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        log.info("save:member={}", member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream() // stream -> for문 역할
                .filter(m -> m.getLoginId().equals(loginId)) // filter -> 조건에 만족하는 것만 다음 단계로 이동
                .findFirst(); // findFirst -> 먼저 나오는애를 반환
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
