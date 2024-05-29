package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Product;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRegister {//상품용 회원 등록
    private Long sID;//판매자 아이디
    private String pName;//상품 이름
    private Long cost;//가격
    private String category;//분류
    private String information;//정보
    private Long pNumber;//상품 번호

    public static Product pForm(ProductRegister pRegister){
        Product product= Product.builder().sID(pRegister.getSID())
                .pName(pRegister.getPName()).cost(pRegister.getCost())
                .category(pRegister.getCategory())
                .information(pRegister.getInformation())
                .build();return product;}}