package org.example.ecommerce.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.ecommerce.register.OrdersRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Orders extends BaseEntity{@Id //주문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersNumber;//주문 번호

    @NotNull(message = "이름은 꼭 작성 해야 됨.")
    @Size(min=1,max=30,message = "이름은 최소 1자, 최대 30자")
    private String ordersName;//주문 이름

    @NotNull(message = "아이디는 꼭 작성 해야 됨")
    @Min(value=1, message = "아이디는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "아이디는 최대 9,999,999,999,999,999이어야 됨.")
    private Long customerID;//고객 아이디

    @NotNull(message = "아이디는 꼭 작성 해야 됨")
    @Min(value=1, message = "아이디는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "아이디는 최대 9,999,999,999,999,999이어야 됨.")
    private Long sellerID;//판매자 아이디

    @NotNull(message = "아이디는 꼭 작성 해야 됨")
    @Min(value=1, message = "아이디는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "아이디는 최대 9,999,999,999,999,999이어야 됨.")
    private Long cartID;//장바구니 아이디

    @NotNull(message = "이름은 꼭 작성 해야 됨.")
    @Size(min=1,max=30, message = " 이름은 최소 1자, 최대 30자")
    private String productName;//상품 이름

    @NotNull(message = "상품 개수는 꼭 작성 해야 됨")
    @Min(value=1, message = "상품 개수는 최소 1이어야 됨.")
    @Max(value = 999999, message = "상품 개수는 최대 999,999이어야 됨.")
    private int ordersCount;;//주문한 상품 개수

    @NotNull(message = "분류는 꼭 작성 해야 됨.")
    @Size(min=1,max=30, message = "분류는 최소 1자, 최대 30자")
    private String category;//분류

    @NotNull(message = "가격은 꼭 작성 해야 됨.")
    @Min(value=1, message = "가격은 최소 1이어야 됨.")
    @Max(value = 9999999999L,
            message = "가격은 최대 9,999,999,999이어야 됨.")
    private Long cost;//상품 가격

    @Min(value=1, message = "상품 아이디는 최소 1이어야 됨.")
    @NotNull(message = "상품 아이디는 꼭 작성 해야 됨")
    private Long productID;//상품 아이디 [7][9][10][11][19]

    public void ordersUpdate(OrdersRegister ordersRegister){
        this.ordersName=ordersRegister.getOrdersName();
        this.customerID =ordersRegister.getCustomerID();
        this.sellerID =ordersRegister.getSellerID();
        this.cartID=ordersRegister.getCartID();
        this.productName =ordersRegister.getProductName();
        this.ordersCount =ordersRegister.getOrdersCount();
        this.category=ordersRegister.getCategory();
        this.cost=ordersRegister.getCost();
        this.productID=ordersRegister.getProductID();}}//[2][3][4][5][6]