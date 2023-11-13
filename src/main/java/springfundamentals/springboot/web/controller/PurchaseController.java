package springfundamentals.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfundamentals.springboot.domain.Purchase;
import springfundamentals.springboot.domain.service.PurchaseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public List<Purchase> getAll() {
        return purchaseService.getAll();
    };
    @GetMapping("/client/{id}")
    public Optional<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId);
    };

    @PostMapping()
    public Purchase save(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    };
}
