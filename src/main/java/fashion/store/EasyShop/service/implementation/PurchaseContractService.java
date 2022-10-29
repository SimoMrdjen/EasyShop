package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.PurchaseContract;
import fashion.store.EasyShop.mapper.PurchaseContractMapper;
import fashion.store.EasyShop.repository.PurchaseContractRepository;
import fashion.store.EasyShop.service.inter.IPurchaseContractService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Component
public class PurchaseContractService implements IPurchaseContractService {

    @Autowired
    private PurchaseContractRepository repository;
    @Autowired
    private InstallmentService installmentService;
    @Autowired
    private PurchaseContractMapper mapper;
    private final String CONTRACT_NOT_FOUND = "Contract not found";

    @Override
    public List<PurchaseContractDto> getPurchaseContracts() {
        return repository.findAll().stream().map(mapper::mapGetEntityToDto).toList();
    }

    @Override
    public List<PurchaseContractDto> getPurchaseContractsOfCustomer(Long customerId) {
        return repository.findByCustomerId(customerId).stream().map(mapper::mapGetEntityToDto).toList();
    }

    @Override
    public PurchaseContractDto getPurchaseContract(Long id) throws NotFoundException {
        PurchaseContract purchaseContract =
                repository.findById(id).orElseThrow(() -> new NotFoundException(CONTRACT_NOT_FOUND));
        return mapper.mapGetEntityToDto(purchaseContract);
    }

    @Override
    public PurchaseContractDto createPurchaseContract(PurchaseContractDto purchaseContractDto) {
        PurchaseContract purchaseContract = repository.save(mapper.mapCreateDtoToEntity(purchaseContractDto));
        List<InstallmentDto> installmentsDto = installmentService.createListOfInstallmentsForContract(purchaseContract);

        PurchaseContractDto dto = mapper.mapGetEntityToDto(purchaseContract);
        dto.setInstallments(installmentsDto);
        return dto;
    }
}
