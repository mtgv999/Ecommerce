package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Order;
//import org.example.ecommerce.domain.OrderItem;
import org.example.ecommerce.domain.OrderItem;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.OrderRegister;
import org.example.ecommerce.repository.OrderRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {//주문
    @Autowired private final OrderRepository orderRepository;
    @Autowired private final ProductRepository productRepository;

     public Order makeOrder0(Long pID, int orderPCount) {
        Product product=productRepository.findBypID(pID);
        if(product.getPCount()<orderPCount){
            throw new RuntimeException("재고 부족");}
        product.setPCount(product.getPCount()-orderPCount);
        productRepository.save(product);

        OrderItem orderItem=new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrderPCount(orderPCount);

        Order order=new Order();
        order.addItem(orderItem);
        return orderRepository.save(order);}

    public Order makeOrder(OrderRegister oRegister) {
return orderRepository.save(OrderRegister.oForm(oRegister));}

    public Order getOrder(Long oNumber) {
        return orderRepository.findByoNumber(oNumber);}

public Order updateOrder(Long oNumber, OrderRegister oRegister){
        Order saved=orderRepository.findByoNumber(oNumber);
        saved.oUpdate(oRegister);return saved;}

    public void deleteOrder(Long oNumber) {
        orderRepository.deleteByoNumber(oNumber);}}