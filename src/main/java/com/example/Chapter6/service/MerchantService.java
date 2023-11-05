package com.example.Chapter6.service;

import com.example.Chapter6.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MerchantService {
    public List<Merchant> getAllMerchants();

    public Merchant addMerchant(Merchant merchant);

    public Optional<Merchant> getMerchantById(Long merchantId);

    public Merchant updateMerchant(Merchant merchant);

    public List<Merchant> getOpenMerchants();
}
