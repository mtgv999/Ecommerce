package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Product;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRegister {//상품용 회원 등록
    private Long sellerID;//판매자 아이디
    private String productName;//상품 이름
    private Long cost;//가격
    private String category;//분류
    private String information;//정보
    private Long productNumber;//상품 번호
    private int stock;//상품 개수

    public static Product productForm(ProductRegister productRegister){
        return Product.builder()
                .sellerID(productRegister.getSellerID())
                .productName(productRegister.getProductName())
                .cost(productRegister.getCost())
                .category(productRegister.getCategory())
                .information(productRegister.getInformation())
                .productNumber(productRegister.getProductNumber())
                .stock(productRegister.getStock()).build();}}