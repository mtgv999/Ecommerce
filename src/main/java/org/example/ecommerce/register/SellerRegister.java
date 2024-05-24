package org.example.ecommerce.register;
import lombok.*;
import org.example.ecommerce.domain.Seller;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRegister {//판매자용 회원 등록
    private Long sPW;//판매자 비밀 번호
    private String sName;//판매자 이름
    private Long sAccountNumber;//판매자 계좌 번호
    private Long sPhoneNumber;//판매자 핸드폰 번호

    public static Seller sForm(SellerRegister sRegister){
        Seller seller=Seller.builder()
                .sPW(sRegister.getSPW()).sName(sRegister.getSName())
                .sAccountNumber(sRegister.getSAccountNumber())
                .sPhoneNumber(sRegister.getSPhoneNumber())
                .build();return seller;}}