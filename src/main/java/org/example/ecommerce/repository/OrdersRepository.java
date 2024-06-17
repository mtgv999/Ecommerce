package org.example.ecommerce.repository;
import org.example.ecommerce.domain.Orders;
import org.example.ecommerce.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>{
    boolean existsByOrdersName(String ordersName);
    //주문 이름으로 중복된 주문이 있는지 여부 확인[15]
    Orders findByOrdersNumber(Long ordersNumber);//주문 번호로 주문 찾기
    void deleteByOrdersNumber(Long ordersNumber);}//주문 번호로 찾아 주문 삭제 [2][3][4][5][6][15]