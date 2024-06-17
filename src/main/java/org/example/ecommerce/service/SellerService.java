package org.example.ecommerce.service;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.request.SellerDeleteRequest;
import org.example.ecommerce.request.SellerLoginRequest;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.repository.SellerRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerService {//판매자
    private final SellerRepository sellerRepository;

    public Seller makeSeller(SellerRegister sellerRegister){
        if(sellerRepository.existsBySellerName(sellerRegister.getSellerName())){
            throw new DuplicateNameException("판매자 이름 이미 있음");}
        return sellerRepository.save(SellerRegister.sellerForm(sellerRegister));}

        public Seller authenticateSeller(SellerLoginRequest sellerLoginRequest){
        //판매자 인증 - 판매자가 로그인을 하려고 할 때, 판매자 이름, PW를 확인한 후에 로그인
            Seller seller=sellerRepository.findBySellerName(sellerLoginRequest.getSellerName());
            if(seller.getSellerPW().equals(sellerLoginRequest.getSellerPW())
            &&seller.getSellerName().equals(sellerLoginRequest.getSellerName()))
            {return seller;}return null;} //출처: chatgpt 질의 응답

    public void logoutSeller(HttpSession session)//판매자용 로그아웃
    {session.invalidate();}

    public Optional<Seller> findBySellerID(Long sellerID){
        //판매자 이름으로 중복된 계정 찾기
        return sellerRepository.findById(sellerID);}//[16]

    public Seller getSeller(Long sellerID) {
        return sellerRepository.findById(sellerID).orElse(null);}

    public Seller updateSeller(Long sellerID, SellerRegister sellerRegister) {
            Seller saved= sellerRepository.findById(sellerID)
.orElseThrow(()->new RuntimeException("판매자 없음"));
            saved.sellerUpdate(sellerRegister);return saved;}

    public void deleteSeller(Long sellerID, SellerDeleteRequest sellerDeleteRequest){
        Seller seller=sellerRepository.findById(sellerID)
                .orElseThrow(()->new RuntimeException("판매자 없음"));
        if(seller.getSellerPW().equals(sellerDeleteRequest.getSellerPW())){
            sellerRepository.deleteById(sellerID);}
    else throw new RuntimeException("판매자 ID 삭제 실패 또는 발견 안 됨");}}//[15]