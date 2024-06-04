package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Order;
import org.example.ecommerce.domain.OrderItem;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.OrderRegister;
import org.example.ecommerce.repository.OrderRepository;
import org.example.ecommerce.repository.ProductRepository;

import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {//주문
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

     public Order makeOrder0(Long productID, int orderCount) {
        Product product=productRepository.findByproductID(productID);
        if(product.getStock()<orderCount){
            throw new RuntimeException("재고 부족");}
        product.setStock(product.getStock()-orderCount);
        productRepository.save(product);

        OrderItem orderItem=new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrderCount(orderCount);

        Order order=new Order();
        order.addItem(orderItem);
        return orderRepository.save(order);}

    public Order makeOrder(OrderRegister orderRegister) {
return orderRepository.save(OrderRegister.oForm(orderRegister));}

    public Order getOrder(Long orderNumber) {
        return orderRepository.findByorderNumber(orderNumber);}

public Order updateOrder(Long orderNumber, OrderRegister orderRegister){
        Order saved=orderRepository.findByorderNumber(orderNumber);
        saved.oUpdate(orderRegister);return saved;}

    public void deleteOrder(Long orderNumber) {
        orderRepository.deleteByorderNumber(orderNumber);}}