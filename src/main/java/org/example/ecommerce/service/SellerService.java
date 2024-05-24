package org.example.ecommerce.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.loginnrequest.SellerLoginRequest;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.repository.SellerRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {//판매자
    private final SellerRepository sellerRepository;

    public Seller makeSeller(SellerRegister sRegister) {
        return sellerRepository.save(SellerRegister.sForm(sRegister));}

    public Seller getSeller(Long sID) {
        return sellerRepository.findBysID(sID);}

    public Seller updateSeller(Long sID,SellerRegister sRegister) {
        Seller saved= sellerRepository.findBysID(sID);
        saved.sUpdate(sRegister);return saved;}

    public void deleteSeller(Long sID) {
        sellerRepository.deleteBysID(sID);}

    public String sLogin(SellerLoginRequest sLReq) {
        Seller reqSe=sellerRepository.findBysID(sLReq.getSID());
        if(reqSe.getSPW().longValue()==sLReq.getSPW())
        //판매자 인지 여부를 판매자 ID, PW 통해 확인
        {return "OK!";} else return "Fail!";}}