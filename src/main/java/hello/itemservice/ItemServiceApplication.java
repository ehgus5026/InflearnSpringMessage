package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	/**
	 * 타임리프에서 th:text로 뿌려줄 때 th:text를 한 곳에 저장해두고 거기서 뿌려줄 때 사용.(이러면 나중에 화면에 보이는 문구를 고치려 할 때 이 파일만 수정하면 됨.)
	 * resources 루트 안에서 'messages.properties', 'errors.properties' 파일을 읽어 온다.
	 */
	/*@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages", "errors");
		messageSource.setDefaultEncoding("utf-8");

		return messageSource;
	}*/

}
