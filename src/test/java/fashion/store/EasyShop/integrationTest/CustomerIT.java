package fashion.store.EasyShop.integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fashion.store.EasyShop.EasyShopApplication;
import fashion.store.EasyShop.EasyShopApplicationTests;
import fashion.store.EasyShop.config.AppConfig;
import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest//(classes = CustomerIT.class)
//@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@ContextConfiguration (locations = "classpath*:/spring/applicationContext*.xml")
class CustomerIT {

//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    CustomerRepository customerRepository;
//
//    Customer customer;
//    CustomerDto customerDto;
//
//    @BeforeEach
//    void setUp() {
//        customer = new Customer(1L,
//                "Mrdjen",
//                "Simo",
//                "0206970850122",
//                "Yr",
//                "0205",
//                "Zrenjanin PU",
//                "dr.sizni@gmail.com",
//                "0631030260");
//        customerDto = new CustomerDto(1L,
//                "Mrdjen",
//                "Simo",
//                "0206970850122",
//                "Yr",
//                "0205",
//                "Zrenjanin PU",
//                "dr.sizn@gmail.com",
//                "0631030260");
//    }
//
//    @Test
//    @Disabled
//    void shouldReturnStudentsWhenGetCustomers() throws Exception {
//        List<Customer> customers = List.of(customer);
//        customerRepository.saveAll(customers);
//
//        mockMvc.perform(get("/customers")).
//                andExpect(status().isOk());
//    }
//
//    @Test
//    //@Disabled
//    void getCustomer() {
//        assertThat("a").isEqualTo("a");
//    }
//
//    @Test
//    @Disabled
//    void addCustomer() throws Exception {
//        customerDto.setId(null);
//
//        mockMvc.perform(post("/customers").
//                contentType(MediaType.APPLICATION_JSON).
//                content(objectMapper.writeValueAsString(customerDto))).
//                andExpect(status().isOk());
//    }
//
//    @Test
//    @Disabled
//    void updateCustomer() {
//    }
//
//    @Test
//    @Disabled
//    void deleteCustomer() {
//    }
}