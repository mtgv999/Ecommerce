package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {//고객
    Customer findBycID(Long cID);//고객 ID로 찾기
    void deleteBycID(Long cID);

    Optional<Customer> findFirstByOrderByIdDesc();
}//고객 계정 삭제[2][4]