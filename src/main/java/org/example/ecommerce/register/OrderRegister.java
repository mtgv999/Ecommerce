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

    private Long pName;//상품 번호
    private int stock;//상품 개수
    private Long category;//분류
    private double cost;//상품 가격

    public static Order oForm(OrderRegister oRegister){
        Order order=Order.builder()
                .customerID(oRegister.getCustomerID())
                .sellerID(oRegister.getSellerID())
                .cartID(oRegister.getCartID())
                .productName(oRegister.getPName())
                .stock(oRegister.getStock())
                .category(oRegister.getCategory())
                .cost(oRegister.getCost())
                .build();return order;}}