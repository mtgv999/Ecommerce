package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.loginnrequest.SellerLoginRequest0;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.repository.SellerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {//판매자
    private final SellerRepository sellerRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Seller makeSeller(SellerRegister sellerRegister) {
        return sellerRepository.save(SellerRegister.sellerForm(sellerRegister));}

    public Seller authenticateSeller(SellerLoginRequest0 sellerloginRequest0) {
        Optional<Seller> seller = sellerRepository
                .findBySellerName(sellerloginRequest0.getSellerName());
        if (seller.isPresent() && passwordEncoder.matches
                (sellerloginRequest0.getSellerPW(), seller.get().getSellerPW())) {
            return seller.get();}return null;}//출처: chagpt 질의응답

    public Optional<Seller> findBySellerByID(Long sellerID) {
        return sellerRepository.findById(sellerID);}

    //public Seller makeSeller(SellerRegister sellerRegister) {
    // Encode password before saving
    //sellerRegister.setSellerPW(passwordEncoder.encode(sellerRegister.getSellerPW()));
    //return sellerRepository.save(SellerRegister.sellerForm(sellerRegister));}

    public Seller getSeller(Long sellerID) {
        return sellerRepository.findBysellerID(sellerID);}

    public Seller updateSeller(Long sellerID, SellerRegister sellerRegister){
        Seller saved= sellerRepository.findBysellerID(sellerID);
        saved.sellerUpdate(sellerRegister);return saved;}

//public Seller makeSeller(SellerRegister sellerRegister) {
//    if (sellerRepository.existsBySellerName(sellerRegister.getSellerName())) {
//        throw new DuplicateSellerNameException("Seller name already exists");}
//    Seller seller = SellerRegister.sellerForm(sellerRegister);
//       return sellerRepository.save(seller);}

    /* public Seller updateSeller0(Long sellerID,
    SellerLoginRequest sellerLoginRequest,SellerRegister sellerRegister) {
        Seller saved=sellerRepository.findBysellerID(sellerID);
        Seller SellerRequest=sellerRepository.findBysellerID(sellerLoginRequest.getSellerID());
        if(SellerRequest.getSellerPW().longValue()==sellerLoginRequest.getSellerPW()){
            saved.sellerUpdate(sellerRegister);}return saved;}*/

    public void deleteSeller(Long sellerID,SellerLoginRequest sellerLoginRequest) {
        Seller seller=sellerRepository.findBysellerID(sellerLoginRequest.getSellerID());
        if(seller.getSellerPW().equals(sellerLoginRequest.getSellerPW()))
            sellerRepository.deleteBysellerID(sellerID);}

    /*public String sellerLogin(SellerLoginRequest sellerLoginRequest) {
Seller SellerRequest=sellerRepository.findBysellerID(sellerLoginRequest.getSellerID());
        if(SellerRequest.getSellerPW().equals(sellerLoginRequest.getSellerPW()))
        //판매자 인지 여부를 판매자 ID, PW 통해 확인
        {return "OK!";} else return "Fail!";}*/

    public Seller changeSellerUsed(Long sellerID, SellerRegister sellerRegister){
        Seller saved2=sellerRepository.findBysellerID(sellerID);
        saved2.changeSellerUsed(sellerRegister);return saved2;}

    public Seller writeSellerReview(Long customerID, SellerRegister sellerRegister) {
        Seller saved3=sellerRepository.findBysellerID(customerID);
        saved3.writeSellerReview(sellerRegister);return saved3;}}