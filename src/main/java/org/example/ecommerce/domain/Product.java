package org.example.ecommerce.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.ecommerce.register.ProductRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product extends BaseEntity{@Id//상품
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;//상품 아이디

    @NotNull(message = "이름은 꼭 작성 해야 됨.")
    @Size(min=1,max=30,message = "이름은 최소 1자, 최대 30자")
    private String productName;//상품 이름

    @NotNull(message = "아이디는 꼭 작성 해야 됨")
    @Min(value=1, message = "아이디는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "아이디는 최대 9,999,999,999,999,999이어야 됨.")
    private Long sellerID;//판매자 아이디

    @NotNull(message = "가격은 꼭 작성 해야 됨.")
    @Min(value=1, message = "가격은 최소 1이어야 됨.")
    @Max(value = 9999999999L,
message = "가격은 최대 9,999,999,999이어야 됨.")
    private Long cost;//상품 가격

    @NotNull(message = "분류는 꼭 작성 해야 됨.")
    @Size(min=1,max=30,message = "분류는 최소 1자, 최대 30자")
    private String category;//상품 분류

    @NotNull(message ="상픔 정보는 꼭 작성 해야 됨" )
    @Size(min=1,message = "상품 정보는 최소 1자")
    private String information;//상품 정보

    @NotNull(message = "상품 번호는 꼭 작성 해야 됨")
    @Min(value=1, message = "상품 번호는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
message = "상품 번호는 최대 9,999,999,999,999,999이어야 됨.")
    private Long productNumber;//상품 번호

    @NotNull(message = "상품 개수는 꼭 작성 해야 됨")
    @Min(value=1, message = "상품 개수는 최소 1이어야 됨.")
    @Max(value = 99999, message = "상품 개수는 최대 99,999이어야 됨.")
    private int stock;//상품(재고) 개수 [7][9][10][15]

    public void pUpdate(ProductRegister productRegister){
        this.productName =productRegister.getProductName();
        this.sellerID =productRegister.getSellerID();
        this.cost=productRegister.getCost();
        this.category=productRegister.getCategory();
        this.information=productRegister.getInformation();
        this.productNumber =productRegister.getProductNumber();
        this.stock =productRegister.getStock();}}//[2][4][5][6]