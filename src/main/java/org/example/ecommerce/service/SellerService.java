package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Customer;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.register.CustomerRegister;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.repository.SellerRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {//판매자
    private final SellerRepository sellerRepository;

    public Seller makeSeller(SellerRegister sellerRegister) {
        return sellerRepository.save(SellerRegister.sellerForm(sellerRegister));}

    public Seller getSeller(Long sellerID) {
        return sellerRepository.findBysellerID(sellerID);}

    public Seller updateSeller(Long sellerID, SellerRegister sellerRegister) {
            Seller saved= sellerRepository.findBysellerID(sellerID);
            saved.sellerUpdate(sellerRegister);return saved;}

    public Seller updateSeller0(Long sellerID,
    SellerLoginRequest sellerLoginRequest,SellerRegister sellerRegister) {
        Seller saved=sellerRepository.findBysellerID(sellerID);
        Seller SellerRequest=sellerRepository.findBysellerID(sellerLoginRequest.getSellerID());
        if(SellerRequest.getSellerPW().longValue()==sellerLoginRequest.getSellerPW()){
            saved.sellerUpdate(sellerRegister);}return saved;}

    public void deleteSeller(Long sellerID,SellerLoginRequest sellerLoginRequest) {
        Seller SellerRequest=sellerRepository.findBysellerID(sellerLoginRequest.getSellerID());
        if(SellerRequest.getSellerPW().longValue()==sellerLoginRequest.getSellerPW())
            sellerRepository.deleteBysellerID(sellerID);}

    public String sellerLogin(SellerLoginRequest sellerLoginRequest) {
Seller SellerRequest=sellerRepository.findBysellerID(sellerLoginRequest.getSellerID());
        if(SellerRequest.getSellerPW().longValue()==sellerLoginRequest.getSellerPW())
        //판매자 인지 여부를 판매자 ID, PW 통해 확인
        {return "OK!";} else return "Fail!";}

    public Seller changeSellerUsed(Long sellerID, SellerRegister sellerRegister){
        Seller saved2=sellerRepository.findBysellerID(sellerID);
        saved2.changeSellerUsed(sellerRegister);return saved2;}

    public Seller writeSellerReview(Long customerID, SellerRegister sellerRegister) {
        Seller saved3=sellerRepository.findBysellerID(customerID);
        saved3.writeSellerReview(sellerRegister);return saved3;}}