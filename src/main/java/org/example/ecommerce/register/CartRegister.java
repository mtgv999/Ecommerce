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
    private String productName;//상품 이름
    private Long sellerID;//판매자 아이디
    private Long customerID;//고객 아이디
    private int cartStock;//장바구니 내 상품들의 총 개수
    private Long totalCost;//가격 총합
    private Long cartNumber;//장바구니 번호

    public static Cart cartForm(CartRegister cartRegister){
return Cart.builder().cartName(cartRegister.getCartName())
                .productName(cartRegister.getProductName())
                .sellerID(cartRegister.getSellerID())
                .customerID(cartRegister.getCustomerID())
                .cartStock(cartRegister.getCartStock())
                .totalCost(cartRegister.getTotalCost())
.cartNumber(cartRegister.getCartNumber()).build();}}