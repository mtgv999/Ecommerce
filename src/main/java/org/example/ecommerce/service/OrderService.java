package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Order;
import org.example.ecommerce.register.OrderRegister;
import org.example.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {//주문
    private final OrderRepository orderRepository;
    public Order makeOrder(OrderRegister oRegister) {
return orderRepository.save(OrderRegister.oForm(oRegister));}

    public Order getOrder(Long oNumber) {
        return orderRepository.findByONumber(oNumber);}

public Order updateOrder(Long oNumber, OrderRegister oRegister){
        Order saved=orderRepository.findByONumber(oNumber);
        saved.oUpdate(oRegister);return saved;}

    public void deleteOrder(Long oNumber) {
        orderRepository.deleteByONumber(oNumber);}}