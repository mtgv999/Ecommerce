package org.example.ecommerce.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "이름은 꼭 작성 해야 됨.")
    @Size(min=1,max=30, message = "이름은 최소 1자, 최대 30자")
    private String cartName;//장바구니 이름

    @NotNull(message = "이름은 꼭 작성 해야 됨.")
    @Size(min=1,max=30, message = "이름은 최소 1자, 최대 30자")
    private String productName;//상품 이름

    @NotNull(message = "상품 번호는 꼭 작성 해야 됨")
    @Min(value=1, message = "상품 번호는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "상품 번호는 최대 9,999,999,999,999,999이어야 됨.")
    private Long sellerID;//판매자 아이디

    @NotNull(message = "상품 번호는 꼭 작성 해야 됨")
    @Min(value=1, message = "상품 번호는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "상품 번호는 최대 9,999,999,999,999,999이어야 됨.")
    private Long customerID;//고객 아이디

    @NotNull(message = "총 상품 개수는 꼭 작성 해야 됨")
    @Min(value=1, message = "총 상품 개수는 최소 1이어야 됨.")
    @Max(value = 999999, message = "총 상품 개수는 최대 999,999이어야 됨.")
    private int cartStock;//장바구니 내 상품들의 총 개수 [7]

    @NotNull(message = "가격 총합은 작성 해야 됨.")
    @Min(value=1, message = "가격 총합은 최소 1이어야 됨.")
    @Max(value = 9999999999L,
            message = "가격 총합은 최대 9,999,999,999이어야 됨.")
    private Long totalCost;//가격 총합

    @NotNull(message = "상품 번호 값은 꼭 작성 해야 됨")
    @Min(value=1, message = "상품 번호 값은 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "상품 번호 값은 최대 9,999,999,999,999,999이어야 됨.")
    private Long cartNumber;//장바구니 번호

    @Min(value=1, message = "상품 아이디는 최소 1이어야 됨.")
    @NotNull(message = "상품 아이디는 꼭 작성 해야 됨")
    private Long productID;//상품 아이디 [9][10][11][19]

    public void cartUpdate(CartRegister cartRegister){
        this.cartName=cartRegister.getCartName();
        this.productName =cartRegister.getProductName();
        this.sellerID =cartRegister.getSellerID();
        this.customerID =cartRegister.getCustomerID();
        this.cartStock =cartRegister.getCartStock();
        this.totalCost=cartRegister.getTotalCost();
        this.cartNumber=cartRegister.getCartNumber();
        this.productID=cartRegister.getProductID();}}//[2][4][5][6]