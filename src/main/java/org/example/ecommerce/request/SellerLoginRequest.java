package org.example.ecommerce.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerLoginRequest {//판매자 로그인 확인 요청
    @JsonProperty
    private String sellerName;
    @JsonProperty
    private String sellerPW;}//[2][4][5][6][15][16]