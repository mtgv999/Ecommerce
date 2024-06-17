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
        ordersRepository.deleteByOrdersNumber(ordersNumber);}}

     /* public Orders makeOrders0(Long productID, int ordersCount) {
        Product product=productRepository.findByproductID(productID);
        if(product.getStock()<ordersCount){
            throw new RuntimeException("재고 부족");}
        product.setStock(product.getStock()-ordersCount);
        productRepository.save(product);

        Orders ordersItem=new Orders();ordersItem.setProduct(product);
        ordersItem.setOrdersCount(ordersCount);Orders orders=new Orders();
        orders.addItem(ordersItem);return orderRepository.save(orders);}*/

        //OrdersItem ordersItem=new OrdersItem();ordersItem.setProduct(product);
         //        ordersItem.setOrdersCount(ordersCount);Orders orders=new Orders();
         //        orders.addItem(ordersItem);return orderRepository.save(orders);}

