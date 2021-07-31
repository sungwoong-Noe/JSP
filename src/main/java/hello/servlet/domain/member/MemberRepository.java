package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려 해야함
 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();  //key는 id, 값은 Member
    private static long sequence = 0L;      //아이디가 하나씩 증가하는 sequence 사용

    //싱글톤으로 만들기
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){           //무조건 getInstance()로 조회해야함
        return instance;
    }

    private MemberRepository(){     //싱글톤은 private으로 생성자를 막아야함. 아무나 생성할 수 없도록
    }

    public Member save(Member member){      //저장
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){    //찾는거
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());     //store의 모든 값들을 새로운 ArrayList에 담아서 넘겨줌
    }

    public void clearStroe(){       //store 날리기
        store.clear();
    }


}
