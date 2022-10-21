package fashion.store.EasyShop.contoller;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.PurchaseContract;
import fashion.store.EasyShop.service.implementation.PurchaseContractService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "contracts")
@RestController
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseContractController {

    @Autowired
    private PurchaseContractService service;

    @GetMapping
    public List<PurchaseContractDto> getPurchaseContracts() {
        return service.getPurchaseContracts();
    }

    @GetMapping(value = "/{id}")
    public PurchaseContractDto getPurchaseContract(@PathVariable(name = "id") Long id)
            throws NotFoundException {
        return service.getPurchaseContract(id);
    }

    @GetMapping("/customer")
    public List<PurchaseContractDto> getCustomerByLastNameLike(@RequestParam Long customerId)
            throws NotFoundException {
        return service.getPurchaseContractsOfCustomer(customerId);
    }
    
    @PostMapping
    public PurchaseContractDto createPurchaseContract(@Valid @RequestBody
                                                          PurchaseContractDto purchaseContractDto) {
        return service.createPurchaseContract(purchaseContractDto);
    }

}
