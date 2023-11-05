package com.example.Chapter6.controller;

import com.example.Chapter6.model.Merchant;
import com.example.Chapter6.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/merchants")
public class MerchantController {
    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> merchants = merchantService.getAllMerchants();
        return new ResponseEntity<>(merchants, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant merchant) {
        Merchant addedMerchant = merchantService.addMerchant(merchant);
        return new ResponseEntity<>(addedMerchant, HttpStatus.CREATED);
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable Long merchantId) {
        Optional<Merchant> merchant = merchantService.getMerchantById(merchantId);
        if (merchant.isPresent()) {
            return new ResponseEntity<>(merchant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{merchantId}")
    public ResponseEntity<Merchant> updateMerchant(@PathVariable Long merchantId, @RequestBody Merchant merchant) {
        merchant.setMerchantCode(merchantId); // Pastikan ID merchant sesuai dengan URL
        Merchant updatedMerchant = merchantService.updateMerchant(merchant);

        if (updatedMerchant != null) {
            return new ResponseEntity<>(updatedMerchant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/open")
    public ResponseEntity<List<Merchant>> getOpenMerchants() {
        List<Merchant> openMerchants = merchantService.getOpenMerchants();
        return new ResponseEntity<>(openMerchants, HttpStatus.OK);
    }
}

//        GET /merchants: Endpoint untuk mendapatkan daftar semua pedagang (merchants).
//        POST /merchants: Endpoint untuk menambahkan pedagang baru.
//        GET /merchants/{merchantId}: Endpoint untuk mendapatkan pedagang berdasarkan ID pedagang.
//        PUT /merchants/{merchantId}: Endpoint untuk memperbarui pedagang berdasarkan ID pedagang.
//        GET /merchants/open: Endpoint untuk mendapatkan daftar pedagang yang sedang buka.