package fashion.store.EasyShop.contoller;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.service.implementation.CustomerService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers()  {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{id}" )
    public CustomerDto getCustomer(@PathVariable(name = "id") Long id) throws NotFoundException {
        return customerService.getCustomer(id);
    }
    @GetMapping("/like")
    public List<CustomerDto> getCustomerByLastNameLike(@RequestParam String lastNameLike) throws NotFoundException {
        return customerService.getCustomersLike(lastNameLike);
    }

    @PostMapping
    public CustomerDto addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @PutMapping(value = "/{id}")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto,
                                      @PathVariable(name = "id") Long id) throws NotFoundException {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable(name = "id") Long id) throws NotFoundException {
        customerService.deleteCustomer(id);
    }
}
