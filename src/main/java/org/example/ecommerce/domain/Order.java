package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.OrderRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Getter
@Setter
//@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity{@Id //주문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;//주문 번호
    private Long customerID;//고객 아이디
    private Long sellerID;//판매자 아이디
    private Long cartID;//장바구니 아이디

    private String productName;//상품 번호
    private int stock;//상품 개수
    private String category;//분류
    private Long cost;//상품 가격

    /* @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> items=new ArrayList<>();//주문한 상품들
    public void addItem(OrderItem item){items.add(item);}

    public double getTotalOrderPrice() {//주문한 상품들의 총 가격
        return items.stream().mapToDouble(item->item.getProduct()
                .getCost()*item.getOrderCount()).sum();}*/

    public void orderUpdate(OrderRegister orderRegister){
        this.customerID =orderRegister.getCustomerID();
        this.sellerID =orderRegister.getSellerID();
        this.cartID=orderRegister.getCartID();
        this.productName =orderRegister.getProductName();
        this.stock =orderRegister.getStock();
        this.category=orderRegister.getCategory();
        this.cost=orderRegister.getCost();}}