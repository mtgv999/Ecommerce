package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Orders;
import org.example.ecommerce.register.OrdersRegister;
import org.example.ecommerce.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController{//주문
    private final OrdersService ordersService;
    /* @PostMapping ("/make0/{productID}/{ordersCount}")
    public Orders makeOrder0
     (@RequestParam Long productID, @RequestParam int ordersCount){
        return ordersService.makeOrders0(productID, ordersCount);}*/

    @PostMapping("/make")//주문 만듬
public ResponseEntity<?> makeOrders(@RequestBody OrdersRegister ordersRegister){
        try{Orders orders= ordersService.makeOrders(ordersRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(orders);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[15]

    @GetMapping("/get/{ordersNumber}")//주문 정보 가져옴.
    public ResponseEntity<Orders> getOrders(@PathVariable Long ordersNumber){
        Orders orders= ordersService.getOrders(ordersNumber);
        if(orders!=null) {return ResponseEntity.ok(orders);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/update/{ordersNumber}")//주문 정보 수정
    public ResponseEntity<Orders> updateOrders(@PathVariable Long ordersNumber,
    @RequestBody OrdersRegister ordersRegister){
        try{Orders updateorders= ordersService.updateOrders(ordersNumber,ordersRegister);
        return ResponseEntity.ok(updateorders);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @DeleteMapping("/delete/{ordersNumber}")//주문 삭제
    public void deleteOrders(@PathVariable Long ordersNumber){
        ordersService.deleteOrders(ordersNumber);}}