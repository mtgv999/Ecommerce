package org.example.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {@Id//주문받는 상품
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    @ManyToOne
    private Product product;
    private int orderCount;}