package allane.contract.leasing.repositories;

import allane.contract.leasing.model.LeasingContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeasingContractRepository  extends JpaRepository<LeasingContract, Long> {

}
