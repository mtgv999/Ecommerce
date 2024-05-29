package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Cart;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRegister {//장바구니 등록
    private String cartName;//장바구니 이름
    private String pName;//상품 이름
    private Long sID;//판매자 아이디
    private Long cID;//고객 아이디
    private Long cartPNumber;//장바구니 내 상품들의 총 개수
    private Long totalCost;//가격 총합
    private Long cartNumber;//장바구니 버호

    public static Cart cartForm(CartRegister cartRegister){
        Cart cart=Cart.builder()
                .cartName(cartRegister.getCartName())
                .pName(cartRegister.getPName())
                .sID(cartRegister.getSID())
                .cID(cartRegister.getCID())
                .cartPNumber(cartRegister.getCartPNumber())
                .totalCost(cartRegister.getTotalCost())
                .cartNumber(cartRegister.getCartNumber())
                .build();return cart;}}