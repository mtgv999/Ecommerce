package org.example.ecommerce.loginnrequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerLoginRequest {//판매자 로그인 확인 요청(ID, PW)
    @JsonProperty
    private Long sellerID;
    @JsonProperty
    private String sellerPW;}