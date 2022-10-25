package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.InstallmentOrdinal;
import fashion.store.EasyShop.entity.PurchaseContract;
import fashion.store.EasyShop.mapper.PurchaseContractMapper;
import fashion.store.EasyShop.repository.InstallmentRepository;
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
    private InstallmentRepository installmentRepository;
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
        Double installAmount =(purchaseContract.getContractAmount() - purchaseContract.getParticipation()) / 3 ;
        List<Installment> insts = List.of(
                new Installment(purchaseContract, InstallmentOrdinal.FIRST, installAmount, purchaseContract.getContractDate().plusMonths(1)),
                new Installment(purchaseContract, InstallmentOrdinal.SECOND, installAmount, purchaseContract.getContractDate().plusMonths(2)),
                new Installment(purchaseContract, InstallmentOrdinal.THIRD, installAmount, purchaseContract.getContractDate().plusMonths(3))
                );
        insts = installmentRepository.saveAll(insts);
        purchaseContract.setInstallments(insts);
        return mapper.mapGetEntityToDto(purchaseContract);
    }
}
