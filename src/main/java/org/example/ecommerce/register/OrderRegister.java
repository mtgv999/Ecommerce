package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Order;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRegister {//주문 등록
    private Long cID;//고객 아이디
    private Long sID;//판매자 아이디
    private Long cartID;//장바구니 아이디

    private Long pName;//상품 번호
    private int pCount;//상품 개수
    private Long category;//분류
    private double cost;//상품 가격

    public static Order oForm(OrderRegister oRegister){
        Order order=Order.builder()
                .cID(oRegister.getCID())
                .sID(oRegister.getSID())
                .cartID(oRegister.getCartID())
                .pName(oRegister.getPName())
                .pCount(oRegister.getPCount())
                .category(oRegister.getCategory())
                .cost(oRegister.getCost())
                .build();return order;}}