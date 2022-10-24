package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.Installment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {

//    @Query(value = "SELECT * FROM installment  JOIN\n" +
//            "        purchase_contract  ON installment.purchase_contract_id = purchase_contract.id JOIN\n" +
//            "        customer  ON purchase_contract.customer_id = customer.id\n" +
//            "        WHERE customer.id = ?1 AND installment.paid_amount IS NULL", nativeQuery = true)
//    List<Installment> findAllByCustomerId(Long customerId);

//    @Query("select i from installment i where i.purchase_contract_id=?1 ")
//    @Query("select i from installment i ")
//    List<Installment> findSome();
    List<Installment> findAllByPurchaseContractId(Long id);
    List<Installment> findAllByPurchaseContract_Customer_Id(Long id);



}
