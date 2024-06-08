package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.ProductRegister;
import org.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {//상품
    private final ProductService productService;

    @PostMapping("/make")//상품 계정 만듬
public Product makeProduct(@RequestBody ProductRegister productRegister){
        return productService.makeProduct(productRegister);}

    @GetMapping("/get/{productID}")//상품 정보 가져옴.
    public Product getProduct(@PathVariable Long productID){
        return productService.getProduct(productID);}

    @PutMapping("/update/{productID}")//상품 정보 수정
    public Product updateProduct(@PathVariable Long productID,
    @RequestBody ProductRegister productRegister){
return productService.updateProduct(productID,productRegister);}

//@DeleteMapping("/delete/{productID}")//상품 계정 삭제
//public void deleteProduct(@PathVariable Long productID,
//@RequestBody SellerLoginRequest sellerLoginRequest){
//    productService.deleteProduct(productID,sellerLoginRequest);}}

@DeleteMapping("/delete/{productID}")//상품 계정 삭제
    public void deleteProduct(@PathVariable Long productID){
        productService.deleteProduct(productID);}}

