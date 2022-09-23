package fashion.store.EasyShop.config;

import fashion.store.EasyShop.mapper.CustomerMapper;
import fashion.store.EasyShop.service.implementation.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerMapper customerMapper() {
        return new CustomerMapper();
    }


}
