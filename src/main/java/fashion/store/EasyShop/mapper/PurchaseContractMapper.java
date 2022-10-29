package fashion.store.EasyShop.mapper;

import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.PurchaseContract;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PurchaseContractMapper {

    @Autowired
    private CustomerMapper customerMapper;

    public PurchaseContract mapCreateDtoToEntity(PurchaseContractDto dto) {
        return new PurchaseContract(
                customerMapper.mapEditCustomerDtoToEntity(dto.getCustomerDto()),
                dto.getContractAmount(),
                dto.getParticipation(),
                dto.getContractDate()
        );
    }

    public PurchaseContract mapCreateInstallmentDtoToEntity(PurchaseContractDto dto) {
        return new PurchaseContract(
                dto.getId(),
                customerMapper.mapEditCustomerDtoToEntity(dto.getCustomerDto()),
                dto.getContractAmount(),
                dto.getParticipation(),
                dto.getContractDate()
        );
    }

    public PurchaseContractDto mapGetEntityToDto(PurchaseContract contract) {
        return new PurchaseContractDto(
                contract.getId(),
                customerMapper.mapEntityToCustomerDto(contract.getCustomer()),
                contract.getContractAmount(),
                contract.getParticipation(),
                contract.getContractDate()
//                new ArrayList<InstallmentDto>()
        );
    }
}
