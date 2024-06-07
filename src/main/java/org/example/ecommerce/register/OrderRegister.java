package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Order;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRegister {//주문 등록
    private Long customerID;//고객 아이디
    private Long sellerID;//판매자 아이디
    private Long cartID;//장바구니 아이디

    private String productName;//상품 번호
    private int stock;//상품 개수
    private String category;//분류
    private Long cost;//상품 가격

    public static Order orderForm(OrderRegister orderRegister){
return Order.builder().customerID(orderRegister.getCustomerID())
                .sellerID(orderRegister.getSellerID())
                .cartID(orderRegister.getCartID())
                .productName(orderRegister.getProductName())
                .stock(orderRegister.getStock())
                .category(orderRegister.getCategory())
                .cost(orderRegister.getCost()).build();}}