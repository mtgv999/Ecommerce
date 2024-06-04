package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.CartRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Cart extends BaseEntity{@Id//장바구니
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartID;//장바구니 아이디
    private String cartName;//장바구니 이름
    private String productName;//물건 이름
    private Long sellerID;//판매자 아이디

    private Long customerID;//고객 아이디
    private Long cartStock;//장바구니 내 상품들의 총 개수
    private Long totalCost;//가격 총합
    private Long cartNumber;//장바구니 번호

    public void cartUpdate(CartRegister cartRegister){
        this.cartName=cartRegister.getCartName();
        this.productName =cartRegister.getProductName();
        this.sellerID =cartRegister.getSroductID();
        this.customerID =cartRegister.getCustomerID();
        this.cartStock =cartRegister.getCartStock();
        this.totalCost=cartRegister.getTotalCost();}}