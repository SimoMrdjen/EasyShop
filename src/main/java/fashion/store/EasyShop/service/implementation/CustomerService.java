package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.exception.BadRequestException;
import fashion.store.EasyShop.mapper.CustomerMapper;
import fashion.store.EasyShop.repository.CustomerRepository;
import fashion.store.EasyShop.service.inter.ICustomerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@NoArgsConstructor
@Service
@Component
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    private final String CUSTOMER_NOT_FOUND = "Customer not found";

    @Override
    public CustomerDto getCustomer(Long id) throws NotFoundException {
        Customer customer =
                customerRepository.findById(id).
                        orElseThrow(() -> new NotFoundException(CUSTOMER_NOT_FOUND));
        return customerMapper.mapEntityToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll().
                stream().
                map(customerMapper::mapEntityToCustomerDto).
                collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomersLike(String lastNameLike) {
        return customerRepository.findByLastNameContainingIgnoreCase(lastNameLike).
                stream().map(customerMapper::mapEntityToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
       if (!customerRepository.findByJmbg(customerDto.getJmbg()).isEmpty())
        {
          throw new BadRequestException("Customer with same JMBG exists yet!!!!");
        }
        Customer customer = customerRepository.save(customerMapper.mapCreateCustomerDtoToEntity(customerDto));
        return customerMapper.mapEntityToCustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) throws NotFoundException {
        customerRepository.findById(customerDto.getId()).orElseThrow(
                              () -> new NotFoundException(CUSTOMER_NOT_FOUND));

        Customer customer = customerRepository.save(customerMapper.mapEditCustomerDtoToEntity(customerDto));
        return customerMapper.mapEntityToCustomerDto(customer);
    }

    @Override
    public void deleteCustomer(Long id) throws NotFoundException {
        if (customerRepository.findById(id).isEmpty()) {
            throw new NotFoundException(CUSTOMER_NOT_FOUND);
        }
        customerRepository.deleteById(id);

//                ifPresentOrElse((customer) -> {customerRepository.deleteById(id);},
//                        () -> {  new NotFoundException(CUSTOMER_NOT_FOUND);});
    }
}
