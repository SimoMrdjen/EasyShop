package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Query("SELECT u FROM Customer u WHERE UPPER(u.last_name) LIKE CONCAT('%',UPPER(:lastNameLike),'%')")
//    List<Customer> findByLastNameLikeIgnoreCase(@Param("lastNameLike") String lastNameLike);

      List<Customer> findByLastNameContainingIgnoreCase(String lastNameLike);
      Optional<Customer> findByJmbg(String jmbg);

}

