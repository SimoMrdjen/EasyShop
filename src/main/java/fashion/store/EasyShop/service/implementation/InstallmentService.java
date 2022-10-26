package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.InstallmentOrdinal;
import fashion.store.EasyShop.entity.PurchaseContract;
import fashion.store.EasyShop.mapper.InstallmentMapper;
import fashion.store.EasyShop.repository.InstallmentRepository;
import fashion.store.EasyShop.service.inter.IInstallmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class InstallmentService implements IInstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;
    @Autowired
    InstallmentMapper installmentMapper;

    @Override
    public List<InstallmentDto> getAllInstallmentsByCustomerId(Long customerId) {
           return installmentRepository.findAllByPurchaseContract_Customer_Id(customerId).
                stream().
                filter(i -> Objects.isNull(i.getPaidAmount())).
                map(installmentMapper::mapGetEntityToDto).
                collect(Collectors.toList());
    }

    @Override
    public InstallmentDto updateInstallment(InstallmentDto installmentDto) {

        return installmentMapper.mapGetEntityToDto(
                installmentRepository.save(installmentMapper.mapEditDtoToEntity(installmentDto)));
    }

    @Override
    public InstallmentDto createInstallment(InstallmentDto installmentDto) {
        return installmentMapper.mapGetEntityToDto(
                installmentRepository.save(installmentMapper.mapCreateDtoToEntity(installmentDto)));
    }

    @Override
    public List<Installment> createListOfInstallmentsForContract(PurchaseContract purchaseContract) {
                Double installAmount =(purchaseContract.getContractAmount() - purchaseContract.getParticipation()) / 3 ;
        List<Installment> installments = List.of(
                new Installment(purchaseContract, InstallmentOrdinal.FIRST, installAmount, purchaseContract.getContractDate().plusMonths(1)),
                new Installment(purchaseContract, InstallmentOrdinal.SECOND, installAmount, purchaseContract.getContractDate().plusMonths(2)),
                new Installment(purchaseContract, InstallmentOrdinal.THIRD, installAmount, purchaseContract.getContractDate().plusMonths(3))
                );
        return installmentRepository.saveAll(installments);
    }
}
