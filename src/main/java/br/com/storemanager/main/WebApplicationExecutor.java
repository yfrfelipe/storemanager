package br.com.storemanager.main;

import br.com.storemanager.control.product.ProductController;
import br.com.storemanager.dto.product.BarcodeDTO;
import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.model.product.Barcode;
import br.com.storemanager.model.product.Lot;
import br.com.storemanager.model.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"br.com.storemanager.service", "br.com.storemanager.control"})
@EnableJpaRepositories(basePackages = {"br.com.storemanager.persistence"})
@EntityScan("br.com.storemanager.model")
@EnableSwagger2
public class WebApplicationExecutor extends SpringBootServletInitializer {
    private static final Logger LOG = LogManager.getLogger(ProductController.class);

    @Override
    public SpringApplicationBuilder configure(final SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(WebApplicationExecutor.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationExecutor.class, args);
        LOG.info("Store manager started with success.");
    }
}
