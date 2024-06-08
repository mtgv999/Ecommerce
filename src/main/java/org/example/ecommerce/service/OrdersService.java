package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Orders;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.OrdersRegister;
import org.example.ecommerce.repository.OrdersRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {//주문
    private final OrdersRepository orderRepository;
    private final ProductRepository productRepository;

     public Orders makeOrders0(Long productID, int ordersCount) {
        Product product=productRepository.findByproductID(productID);
        if(product.getStock()<ordersCount){
            throw new RuntimeException("재고 부족");}
        product.setStock(product.getStock()-ordersCount);
        productRepository.save(product);

        Orders ordersItem=new Orders();ordersItem.setProduct(product);
        ordersItem.setOrdersCount(ordersCount);Orders orders=new Orders();
        orders.addItem(ordersItem);return orderRepository.save(orders);

        //OrdersItem ordersItem=new OrdersItem();ordersItem.setProduct(product);
         //        ordersItem.setOrdersCount(ordersCount);Orders orders=new Orders();
         //        orders.addItem(ordersItem);return orderRepository.save(orders);
     }
    public Orders makeOrders(OrdersRegister orderRegister) {
return orderRepository.save(OrdersRegister.ordersForm(orderRegister));}

    public Orders getOrders(Long ordersNumber) {
        return orderRepository.findByOrdersNumber(ordersNumber);}

public Orders updateOrders(Long orderNumber, OrdersRegister orderRegister){
        Orders saved=orderRepository.findByOrdersNumber(orderNumber);
        saved.ordersUpdate(orderRegister);return saved;}

    public void deleteOrders(Long orderNumber) {
        orderRepository.deleteByOrdersNumber(orderNumber);}}