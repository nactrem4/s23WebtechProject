package com.webtech.project.demo.web;

import com.webtech.project.demo.web.api.ShopCreateRequest;
import com.webtech.project.demo.web.api.ShopItem;
import com.webtech.project.demo.web.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ShopRestController {

    private final ShopService shopService;

    public ShopRestController(ShopService shopService) {
        this.shopService = shopService;
    }


    @GetMapping(path = "/api/v1/shopitems")
   public ResponseEntity<List<ShopItem>> fetchShopItems(){
        return ResponseEntity.ok(shopService.findAll());
    }

    @GetMapping(path = "/api/v1/shopitems/{id}")
    public ResponseEntity<ShopItem> fetchShopItem(@PathVariable Long id){
        var shopitem = shopService.findById(id);
        return shopitem != null? ResponseEntity.ok(shopitem) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/shopitems")
    public ResponseEntity<Void> createItem(@RequestBody ShopCreateRequest request) throws URISyntaxException {
       var shopItem =  shopService.create(request);
       URI uri = new URI("/api/v1/shopitems/" + shopItem.getId());
       return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/shopItems/{id}")
    public ResponseEntity<ShopItem> updatePerson(@PathVariable Long id, @RequestBody ShopCreateRequest request) {
        var shopItem = shopService.update(id, request);
        return shopItem != null? ResponseEntity.ok(shopItem) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean successful = shopService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

