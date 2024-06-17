package org.example.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.ProductRegister;
import org.example.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {//상품
    private final ProductService productService;

    @PostMapping("/make")//상품 계정 만듬
    public ResponseEntity<?> makeProduct(@RequestBody ProductRegister productRegister){
        try{Product product= productService.makeProduct(productRegister);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}//[15]

    @GetMapping("/get/{productID}")//상품 정보 가져옴.
    public ResponseEntity<Product> getProduct(@PathVariable Long productID){
        Product product= productService.getProduct(productID);
        if(product!=null) {return ResponseEntity.ok(product);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/update/{productID}")//상품 정보 수정
    public ResponseEntity<?> updateProduct(@PathVariable Long productID,
@RequestBody ProductRegister productRegister){
try{Product updateproduct= productService.updateProduct(productID,productRegister);
    return ResponseEntity.ok(updateproduct);
}catch (Exception e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @DeleteMapping("/delete/{productID}")//상품 삭제
    public void deleteProduct(@PathVariable Long productID){
        productService.deleteProduct(productID);}}//[2][4][5][6][15]