package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Product;
import org.example.ecommerce.register.ProductRegister;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {//상품
    private final ProductRepository productRepository;
    public Product makeProduct(ProductRegister pRegister) {
    return productRepository.save(ProductRegister.pForm(pRegister));}

    public Product getProduct(Long pID) {
        return productRepository.findBypID(pID);}

    public Product updateProduct(Long pID, ProductRegister pRegister) {
        Product saved=productRepository.findBypID(pID);
        saved.pUpdate(pRegister);return saved;}

    public void deleteProduct(Long pID) {
        productRepository.deleteBypID(pID);}}