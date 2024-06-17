package org.example.ecommerce.controller;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.DuplicateNameException;
import org.example.ecommerce.domain.Seller;
import org.example.ecommerce.request.SellerDeleteRequest;
import org.example.ecommerce.request.SellerLoginRequest;
import org.example.ecommerce.register.SellerRegister;
import org.example.ecommerce.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {//판매자
    private final SellerService sellerService;

    @PostMapping("/make")//판매자 계정 만듬
   public ResponseEntity<?> makeSeller(@RequestBody SellerRegister sellerRegister){
        try{Seller seller=sellerService.makeSeller(sellerRegister);
        return ResponseEntity.status(HttpStatus.CREATED).body(seller);
        }catch (DuplicateNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}

     @PostMapping("/login")
     //판매자가 로그인을 하려고 할 때, 판매자 이름, PW를 확인한 후에 로그인
     public ResponseEntity<String> loginSeller
            (HttpSession session, @RequestBody SellerLoginRequest sellerLoginRequest){
        Seller seller = sellerService.authenticateSeller(sellerLoginRequest);

        if(seller!=null) {//세션에 판매자 ID 저장
            session.setAttribute("sellerID", seller.getSellerID());
            return ResponseEntity.ok("로그인 성공");
        }else{return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED).body("로그인 실패");}}

    @PostMapping("/logout")//판매자용 로그아웃
    public ResponseEntity<String> logoutSeller(HttpSession session){//세션 무효화
    session.invalidate();return ResponseEntity.ok("로그아웃 성공");}

    @GetMapping("/profile")//로그인된 판매자 프로필 정보 가져옴
    public ResponseEntity<Seller> getProfile(HttpSession session){
        Long sellerID=(Long) session.getAttribute("sellerID");

if(sellerID==null){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
Optional<Seller> seller=sellerService.findBySellerID(sellerID);
return seller.map(ResponseEntity::ok).orElseGet(()
    -> ResponseEntity.notFound().build());}//[16]

    @GetMapping("/get/{sellerID}")//판매자 정보 가져옴
    public ResponseEntity<Seller> getSeller(@PathVariable Long sellerID){
        Seller seller=sellerService.getSeller(sellerID);
        if(seller!=null) {return ResponseEntity.ok(seller);
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/update/{sellerID}")//판매자 정보 수정
    public ResponseEntity<Seller> updateSeller(@PathVariable Long sellerID,
        @RequestBody SellerRegister sellerRegister){

        try { Seller updateseller=sellerService.updateSeller(sellerID,sellerRegister);
            return ResponseEntity.ok(updateseller);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @DeleteMapping("/delete/{sellerID}")
    //판매자 계정을 삭제 하려고 할 때, 판매자 ID, PW를 확인한 후에 삭제.
    public ResponseEntity<String> deleteSeller(@PathVariable Long sellerID,
    @RequestBody SellerDeleteRequest sellerDeleteRequest){

        try { sellerService.deleteSeller(sellerID, sellerDeleteRequest);
            return ResponseEntity.ok("판매자 계정 성공적 삭제");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                    body("판매자 계정 삭제 실패 또는 발견 안 됨");}}}//[2][4][5][6][15]