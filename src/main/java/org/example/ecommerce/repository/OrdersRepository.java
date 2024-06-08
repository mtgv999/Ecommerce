package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>{
    Orders findByOrdersNumber(Long ordersNumber);//주문 번호로 찾기
    void deleteByOrdersNumber(Long ordersNumber);}//주문 삭제