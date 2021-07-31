package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;        //데이터 베이스에 저장 될 때 부여될 아이디
    private String username;
    private int age;

    public Member() {   //기본 생성자
    }

    public Member(String username, int age) {   //username, age 생성자

        this.username = username;
        this.age = age;
    }
}
