package org.example.ecommerce.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDeleteRequest {//판매자 계정 확인 요청
    @JsonProperty
    private Long sellerID;
    @JsonProperty
    private String sellerPW;}