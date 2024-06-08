package org.example.ecommerce.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.ecommerce.register.SellerRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Seller extends BaseEntity { @Id//판매자
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerID;//판매자 아이디

    @NotNull(message = "PW는 꼭 작성 해야 됨")
    @Min(value=1, message = "PW는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "PW는 최대 9,999,999,999,999,999이어야 됨.")
    private Long sellerPW;//판매자 비밀 번호

    @NotNull(message = "이름은 꼭 작성 해야 됨")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,17}$",
            message = "이름은 최소 4자, 최대 16자, 최소 1개 문자, 숫자 모두 포함 필수")
    @Size(min=4,max=16,message = "이름은 최소 4자, 최대 16자")
    private String sellerName;//판매자 이름[7]

    @NotNull(message = "계좌 값은 꼭 작성 해야 됨")
    @Min(value=1, message = "계좌 값은 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "계좌 값은 최대 9,999,999,999,999,999이어야 됨.")
    private Long sellerAccountNumber;//판매자 계좌 번호

    @NotNull(message = "휴대폰 번호는 꼭 작성 해야 됨")
    @Min(value=1, message = "휴대폰 번호는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
            message = "휴대폰 번호는 최대 9,999,999,999,999,999이어야 됨.")
    private Long sellerPhoneNumber;//판매자 핸드폰 번호 [10][11]

    private String sellerUsed;//판매자: 시스템 사용 경험 여부
    private String sellerReview;//판매자 리뷰

    public void sellerUpdate(SellerRegister sellerRegister){
        this.sellerPW=sellerRegister.getSellerPW();
        this.sellerName =sellerRegister.getSellerName();
        this.sellerAccountNumber =sellerRegister.getSellerAccountNumber();
        this.sellerPhoneNumber =sellerRegister.getSellerPhoneNumber();}

    public void changeSellerUsed(SellerRegister sellerRegister){
        this.sellerUsed ="yes";}
    public void writeSellerReview(SellerRegister sellerRegister){
        this.sellerReview=sellerRegister.getSellerReview();}}