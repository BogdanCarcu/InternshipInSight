package app.INTERNSHIP_IN_SIGHT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages= {"controller", "dao", "dao.dbmodel", "model", "service", "app.INTERNSHIP_IN_SIGHT"})
@EntityScan(basePackages = {"dao.dbmodel"})
@EnableJpaRepositories("dao")
@EnableSwagger2
public class InternshipInSightApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipInSightApplication.class, args);
	}
}
