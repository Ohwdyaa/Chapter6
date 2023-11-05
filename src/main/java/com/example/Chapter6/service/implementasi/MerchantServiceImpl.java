package com.example.Chapter6.service.implementasi;

import com.example.Chapter6.model.Merchant;
import com.example.Chapter6.repository.MerchantRepository;
import com.example.Chapter6.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Autowired
    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    @Autowired
    public Merchant addMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Autowired
    public Optional<Merchant> getMerchantById(Long merchantId) {
        return merchantRepository.findById(merchantId);
    }

    @Autowired
    public Merchant updateMerchant(Merchant merchant) {
        Optional<Merchant> existingMerchantOptional = merchantRepository.findById(merchant.getMerchantCode());

        if (existingMerchantOptional.isPresent()) {
            Merchant existingMerchant = existingMerchantOptional.get();
            // Update status buka/tutup merchant
            existingMerchant.setOpen(merchant.isOpen());
            // Anda dapat menambahkan logika lainnya untuk pembaruan di sini
            return merchantRepository.save(existingMerchant);
        } else {
            return null; // Merchant tidak ditemukan
        }
    }

    @Autowired
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByOpen(true);
    }
}
