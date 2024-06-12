package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.register.ProductRegister;
import org.example.ecommerce.repository.ProductRepository;
import org.example.ecommerce.repository.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {//상품
    private final ProductRepository productRepository;
    public Product makeProduct(ProductRegister productRegister) {
return productRepository.save(ProductRegister.productForm(productRegister));}

    public Product getProduct(Long productID) {
        return productRepository.findByproductID(productID);}

    public Product updateProduct(Long productID,
        ProductRegister productRegister) {
        Product saved=productRepository.findByproductID(productID);
        saved.pUpdate(productRegister);return saved;}

    public void deleteProduct(Long productID) {
            productRepository.deleteByproductID(productID);}}

//public void deleteProduct(Long productID, SellerLoginRequest sellerLoginRequest) {
//    Seller SellerRequest=productRepository.findBysellerID(sellerLoginRequest.getSellerID());
//    if(SellerRequest.getSellerPW().longValue()==sellerLoginRequest.getSellerPW())
//        productRepository.deleteByproductID(productID);}