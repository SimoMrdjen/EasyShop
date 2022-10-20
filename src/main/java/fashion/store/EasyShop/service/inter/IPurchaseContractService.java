package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.PurchaseContractDto;
import javassist.NotFoundException;

import java.util.List;

public interface IPurchaseContractService {
    List<PurchaseContractDto> getPurchaseContracts();
    List<PurchaseContractDto> getPurchaseContractsOfCustomer(Long customerId);
    PurchaseContractDto getPurchaseContract(Long id) throws NotFoundException;
    PurchaseContractDto createPurchaseContract(PurchaseContractDto purchaseContractDto);
}
