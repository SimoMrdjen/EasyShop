package fashion.store.EasyShop.mapper;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.PurchaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PurchaseContractMapper {

    @Autowired
    private CustomerMapper mapper;

    public PurchaseContract mapCreateDtoToEntity(PurchaseContractDto dto) {
        return new PurchaseContract(
                mapper.mapEditCustomerDtoToEntity(dto.getCustomerDto()),
                dto.getContractAmount(),
                dto.getParticipation(),
                dto.getContractDate()
        );
    }

    public PurchaseContract mapCreateInstallmentDtoToEntity(PurchaseContractDto dto) {
        return new PurchaseContract(
                dto.getId(),
                mapper.mapEditCustomerDtoToEntity(dto.getCustomerDto()),
                dto.getContractAmount(),
                dto.getParticipation(),
                dto.getContractDate()
        );
    }

    public PurchaseContractDto mapGetEntityToDto(PurchaseContract contract) {
        return new PurchaseContractDto(
                contract.getId(),
                mapper.mapEntityToCustomerDto(contract.getCustomer()),
                contract.getContractAmount(),
                contract.getParticipation(),
                contract.getContractDate(),
                new ArrayList<InstallmentDto>()
        );
    }
}
