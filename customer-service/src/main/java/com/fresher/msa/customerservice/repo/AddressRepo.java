package com.fresher.msa.customerservice.repo;

import com.fresher.msa.customerservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
