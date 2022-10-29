package fashion.store.EasyShop.config;

import fashion.store.EasyShop.mapper.CustomerMapper;
import fashion.store.EasyShop.mapper.InstallmentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerMapper customerMapper() {
        return new CustomerMapper();
    }

//    @Bean
//    public PurchaseContractMapper purchaseContractMapper() {
//        return new PurchaseContractMapper();
//    }

    @Bean
    public InstallmentMapper installmentMapper() {
        return new InstallmentMapper();
    }


}
