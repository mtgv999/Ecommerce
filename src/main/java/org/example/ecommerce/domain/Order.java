package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.OrderRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity{@Id //주문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oNumber;//주문 번호
    private Long cID;//고객 ID
    private Long sID;//판매자 ID
    private Long cartID;//장바구니 ID

    private Long pName;//상품 번호
    private Long pNumber;//상품 개수
    private Long category;//분류
    private Long cost;//상품 가격

    public void oUpdate(OrderRegister oRegister){
        this.cID=oRegister.getCID();
        this.sID=oRegister.getSID();
        this.cartID=oRegister.getCartID();
        this.pName=oRegister.getPName();
        this.pNumber=oRegister.getPNumber();
        this.category=oRegister.getCategory();
        this.cost=oRegister.getCost();}}