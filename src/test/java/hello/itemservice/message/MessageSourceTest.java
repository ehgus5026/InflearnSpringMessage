package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        String result = ms.getMessage("hello", null, null); // 'hello'로 넘기고 + default properties가 선택되고 + 한국 or 영어 설정
        assertThat(result).isEqualTo("안녕");
    }

    // 'no_code'를 찾았는데 값이 없는 경우 예외 발생
    @Test
    void notFoundmessageCode() {
//        ms.getMessage("no_code", null, null);
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    // default 메세지 값 주기
    @Test
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("not_found", null,"기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지");
    }

    // messages.properties의 매개변수 사용
    @Test
    void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null); // 안녕 + 배열{0}에 Spring으로 치환
        assertThat(message).isEqualTo("안녕 Spring");
    }

    @Test
    void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    void enLang() {
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello"); // messages_en.properties에서 읽게됨
    }


}
