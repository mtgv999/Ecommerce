package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.register.OrderRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;
@Builder
@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity{@Id //주문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oNumber;//주문 번호
    private Long cID;//고객 아이디
    private Long sID;//판매자 아이디
    private Long cartID;//장바구니 아이디

    private Long pName;//상품 번호
    private int pCount;//상품 개수
    private Long category;//분류
    private double cost;//상품 가격

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> items=new ArrayList<>();//주문한 상품들
    public void addItem(OrderItem item){items.add(item);}

    public double getTotalOrderPrice() {//주문한 상품들의 총 가격
        return items.stream().mapToDouble(item->item.getProduct()
                .getCost()*item.getOrderPCount()).sum();}

    public void oUpdate(OrderRegister oRegister){
        this.cID=oRegister.getCID();
        this.sID=oRegister.getSID();
        this.cartID=oRegister.getCartID();
        this.pName=oRegister.getPName();
        this.pCount =oRegister.getPCount();
        this.category=oRegister.getCategory();
        this.cost=oRegister.getCost();}}