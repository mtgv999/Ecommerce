package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {//고객
    boolean existsByCustomerName(String CustomerName);
    //고객 이름으로 중복된 계정이 있는지 여부 확인[15]
    Customer findByCustomerName(String CustomerName);
    //고객 이름으로 중복된 계정 찾기[16]
    Customer findBycustomerID(Long customerID);//고객 ID로 계정 찾기
    void deleteBycustomerID(Long customerID);}//고객 ID로 찾아 계정 삭제 [2][4][5][6][15]