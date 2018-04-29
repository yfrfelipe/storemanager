package br.com.storemanager.control;

import br.com.storemanager.persistence.PersonPersistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {PersonPersistence.class})
@ComponentScan({"br.com.storemanager.service"})
@EntityScan("br.com.storemanager.model")
public class PersonWebServiceImpl extends SpringBootServletInitializer {

    @Override
    public SpringApplicationBuilder configure(final SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(PersonWebServiceImpl.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PersonWebServiceImpl.class, args);
    }
}
