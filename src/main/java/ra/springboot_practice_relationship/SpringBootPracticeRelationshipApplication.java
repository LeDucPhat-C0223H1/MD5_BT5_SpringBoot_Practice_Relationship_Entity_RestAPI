package ra.springboot_practice_relationship;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPracticeRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeRelationshipApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
