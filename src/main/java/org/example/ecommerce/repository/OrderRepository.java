package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    Order findByoNumber(Long oNumber);//주문 번호로 찾기
    void deleteByoNumber(Long oNumber);}//주문 삭제