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
public Product makeProduct(@RequestBody ProductRegister pRegister){
        return productService.makeProduct(pRegister);}

    @GetMapping("/get/{pID}")//상품 정보 가져옴.
    public Product getProduct(@PathVariable Long pID){
        return productService.getProduct(pID);}

    @PutMapping("/update/{pID}")//상품 정보 수정
    public Product updateProduct(@PathVariable Long pID,
    @RequestBody ProductRegister pRegister){
        return productService.updateProduct(pID,pRegister);}

    @DeleteMapping("/delete/{pID}")//상품 계정 삭제
    public void deleteProduct(@PathVariable Long pID){
        productService.deleteProduct(pID);}}