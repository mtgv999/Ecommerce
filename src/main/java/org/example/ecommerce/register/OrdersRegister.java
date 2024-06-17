package org.example.ecommerce.register;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.ecommerce.domain.Orders;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersRegister {//주문 등록
    private String ordersName;//주문 이름
    private Long customerID;//고객 아이디
    private Long sellerID;//판매자 아이디
    private Long cartID;//장바구니 아이디

    private String productName;//상품 번호
    private int ordersCount;//주문한 상품 개수
    private String category;//분류
    private Long cost;//상품 가격

    public static Orders ordersForm(OrdersRegister orderRegister){
return Orders.builder().ordersName(orderRegister.getOrdersName())
        .customerID(orderRegister.getCustomerID())
                .sellerID(orderRegister.getSellerID())
                .cartID(orderRegister.getCartID())
                .productName(orderRegister.getProductName())
                .ordersCount(orderRegister.getOrdersCount())
                .category(orderRegister.getCategory())
                .cost(orderRegister.getCost()).build();}}