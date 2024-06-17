package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Seller;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRegister {//판매자용 회원 등록
    private String sellerName;//판매자 이름
    private String sellerPW;//판매자 비밀 번호
    private Long sellerAccountNumber;//판매자 계좌 번호
    private Long sellerPhoneNumber;//판매자 핸드폰 번호
    private String sellerReview;//판매자 리뷰

    public static Seller sellerForm(SellerRegister sellerRegister){
return Seller.builder().sellerName(sellerRegister.getSellerName())
                        .sellerPW(sellerRegister.getSellerPW())
.sellerAccountNumber(sellerRegister.getSellerAccountNumber())
.sellerPhoneNumber(sellerRegister.getSellerPhoneNumber())
.sellerReview(sellerRegister.getSellerReview()).build();}}//[2][4][5][6][15]