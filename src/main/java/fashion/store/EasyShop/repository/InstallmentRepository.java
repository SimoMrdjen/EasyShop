package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.Installment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {
    
    List<Installment> findAllByPurchaseContract_Id(Long id);
    List<Installment> findAllByPurchaseContract_Customer_Id(Long id);
}
