package springfundamentals.springboot.domain.repository;

import springfundamentals.springboot.domain.Purchase;

import java.util.List;

public interface PurchaseRepository {
    List<Purchase> getAll();
    List<Purchase> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
