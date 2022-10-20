package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.PurchaseContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseContractRepository extends JpaRepository<PurchaseContract, Long> {
    List<PurchaseContract> findByCustomerId(Long customerId);
    @Override
    Optional<PurchaseContract> findById(Long id);
}
