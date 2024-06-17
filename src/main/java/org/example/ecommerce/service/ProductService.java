package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.ProductRegister;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {//상품
    private final ProductRepository productRepository;
    public Product makeProduct(ProductRegister productRegister) {
        if(productRepository.existsByProductName(productRegister.getProductName())){
            throw new DuplicateNameException("상품 이름 이미 있음");}
return productRepository.save(ProductRegister.productForm(productRegister));}

    public Product getProduct(Long productID) {
        return productRepository.findById(productID).orElse(null);}

public Product updateProduct(Long productID, ProductRegister productRegister) {
        Product saved=productRepository.findById(productID)
.orElseThrow(()->new RuntimeException("상품 없음"));
        saved.pUpdate(productRegister);return saved;}

    public void deleteProduct(Long productID) {
        productRepository.deleteByproductID(productID);}}//[2][4][5][6][15]
