package fashion.store.EasyShop.contoller;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.service.implementation.InstallmentService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "installments")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentController {
    @Autowired
    private InstallmentService service;

    @GetMapping("/customer")
    public List<InstallmentDto> getAllUnpaidInstallmentsOfCustomer(@RequestParam Long customerId) {
        return service.getAllInstallmentsByCustomerId(customerId);
    }

    @GetMapping(value = "/{id}")
    public InstallmentDto getInstallment(@PathVariable(name = "id") Long id) throws NotFoundException {
        return service.getInstallment(id);
    }

    @PutMapping(value = "/{id}")
    public InstallmentDto editInstallment(@RequestBody InstallmentDto dto, @PathVariable(name = "id") Long id) throws NotFoundException {
        return service.updateInstallment(dto, id);
    }
}
