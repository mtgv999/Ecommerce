package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Seller;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRegister {//판매자용 회원 등록
    private Long sellerPW;//판매자 비밀 번호
    private String sellerName;//판매자 이름
    private Long sellerAccountNumber;//판매자 계좌 번호
    private Long sellerPhoneNumber;//판매자 핸드폰 번호

    public static Seller sellerForm(SellerRegister sellerRegister){
        Seller seller=Seller.builder()
                .sellerPW(sellerRegister.getSellerPW())
                .sellerName(sellerRegister.getSellerName())
                .sellerAccountNumber(sellerRegister.getSellerAccountNumber())
                .sellerPhoneNumber(sellerRegister.getSellerPhoneNumber())
                .build();return seller;}}