package allane.contract.leasing.service;

import allane.contract.leasing.model.LeasingContract;
import allane.contract.leasing.repositories.LeasingContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeasingContractService {

    private final LeasingContractRepository leasingContractRepository;


    public LeasingContractService(LeasingContractRepository leasingContractRepository) {
        this.leasingContractRepository = leasingContractRepository;
    }

    public List<LeasingContract> findAllLeasingContracts() {
        return leasingContractRepository.findAll();
    }

    public Optional<LeasingContract> findLeasingContractById(Long id) {
        return leasingContractRepository.findById(id);
    }

    public LeasingContract createOrUpdate(LeasingContract leasingContract) {
        return leasingContractRepository.save(leasingContract);
    }

}
