package org.example.ecommerce.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.ecommerce.register.CustomerRegister;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer extends BaseEntity {@Id//고객
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;//고객 아이디

    @NotNull(message = "이름은 꼭 작성 해야 됨")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,17}$",
            message = "이름은 최소 4자, 최대 16자, 최소 1개 문자, 숫자 모두 포함 필수")
    @Size(min=4,max=16,message = "이름: 최소 4자, 최대 16자")
    private String customerName;//고객 이름

    @NotNull(message = "이름은 꼭 작성 해야 됨")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,17}$",
            message = "이름은 최소 4자, 최대 16자, 최소 1개 문자, 숫자 모두 포함 필수")
    @Size(min=4,max=16,message = "이름: 최소 4자, 최대 16자")
    private String customerPW;//고객 비밀 번호

    @NotNull(message = "계좌 번호는 꼭 작성 해야 됨")
    @Min(value=1, message = "계좌 번호는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
message = "계좌 번호는 최대 9,999,999,999,999,999이어야 됨.")
    private Long customerAccountNumber;//고객 계좌 번호

    @NotNull(message = "휴대폰 번호는 꼭 작성 해야 됨")
    @Min(value=1, message = " 휴대폰 번호는 최소 1이어야 됨.")
    @Max(value = 9999999999999999L,
message = "휴대폰 번호는 최대 9,999,999,999,999,999이어야 됨.")
    private Long customerPhoneNumber;//고객 핸드폰 번호

    private String customerReview;//고객 리뷰 [9][10][11]

    public void customerUpdate(CustomerRegister customerRegister){
        this.customerName =customerRegister.getCustomerName();
        this.customerPW=customerRegister.getCustomerPW();
        this.customerAccountNumber =customerRegister.getCustomerAccountNumber();
        this.customerPhoneNumber =customerRegister.getCustomerPhoneNumber();
        this.customerReview=customerRegister.getCustomerReview();}}//[2][4][5][6]