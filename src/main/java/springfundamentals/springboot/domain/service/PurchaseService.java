package springfundamentals.springboot.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfundamentals.springboot.domain.Purchase;
import springfundamentals.springboot.domain.repository.PurchaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    };
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    };
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    };
}
