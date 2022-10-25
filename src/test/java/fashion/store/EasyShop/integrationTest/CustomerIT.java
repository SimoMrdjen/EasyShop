package fashion.store.EasyShop.integrationTest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

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
//    //@Disabled
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