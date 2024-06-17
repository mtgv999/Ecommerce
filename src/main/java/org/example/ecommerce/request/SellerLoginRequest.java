package org.example.ecommerce.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerLoginRequest {
    @JsonProperty
    private String sellerName;
    @JsonProperty
    private String sellerPW;}