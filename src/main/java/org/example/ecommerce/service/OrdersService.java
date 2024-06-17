package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Orders;
import org.example.ecommerce.register.OrdersRegister;
import org.example.ecommerce.repository.OrdersRepository;
import org.springframework.stereotype.Service;
@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {//주문
    private final OrdersRepository ordersRepository;
    public Orders makeOrders(OrdersRegister ordersRegister) {
        if(ordersRepository.existsByOrdersName(ordersRegister.getOrdersName())){
            throw new DuplicateNameException("주문 이름 이미 있음");}
        return ordersRepository.save(OrdersRegister.ordersForm(ordersRegister));}

    public Orders getOrders(Long ordersNumber) {
        return ordersRepository.findById(ordersNumber).orElse(null);}

    public Orders updateOrders(Long ordersNumber, OrdersRegister ordersRegister){
        Orders saved= ordersRepository.findById(ordersNumber)
 .orElseThrow(()->new RuntimeException("주문 없음"));
        saved.ordersUpdate(ordersRegister);return saved;}

    public void deleteOrders(Long ordersNumber) {
        ordersRepository.deleteByOrdersNumber(ordersNumber);}}//[2][3][4][5][6][15]

