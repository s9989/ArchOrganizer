package archorganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories( basePackages = {"archorganizer.repository"})
@EntityScan( basePackages = {"archorganizer.model"})

public class ArchorganizerApplication {

	@Autowired
	private DataInitializer dataInitializer;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ArchorganizerApplication.class, args);
		context.getBean(DataInitializer.class).initData();
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
