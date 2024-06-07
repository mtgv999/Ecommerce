package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    Order findByOrderNumber(Long orderNumber);//주문 번호로 찾기
    void deleteByOrderNumber(Long orderNumber);}//주문 삭제