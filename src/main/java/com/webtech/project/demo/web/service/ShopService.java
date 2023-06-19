package com.webtech.project.demo.web.service;


import com.webtech.project.demo.web.api.ShopCreateRequest;
import com.webtech.project.demo.web.api.ShopItem;
import com.webtech.project.demo.web.persistence.ShopEntity;
import com.webtech.project.demo.web.persistence.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopItem> findAll() {
        List<ShopEntity> shopitems = shopRepository.findAll();
        return shopitems.stream()
                .map(shopEntity -> transformEntity(shopEntity))
                .collect(Collectors.toList());
    }

    public ShopItem findById(Long id){
        var shopEntity = shopRepository.findById(id);
        return shopEntity.map(this::transformEntity).orElse(null);
    }

    public ShopItem create(ShopCreateRequest request) {
        var shopEntity = new ShopEntity(request.getArtikelName(), request.isWareVorhanden());
         shopEntity = shopRepository.save(shopEntity);
         return transformEntity(shopEntity);
    }

    public ShopItem update(Long id, ShopCreateRequest request) {
        var ShopEntityOptional = shopRepository.findById(id);
        if (ShopEntityOptional.isEmpty()) {
            return null;
        }
        var shopEntity = ShopEntityOptional.get();
        shopEntity.setArtikelName(request.getArtikelName());
        shopEntity.setWareVorhanden(request.isWareVorhanden());
        return transformEntity(shopEntity);
    }
    public boolean deleteById(Long id) {
        if (!shopRepository.existsById(id)) {
            return false;
        }

        shopRepository.deleteById(id);
        return true;
    }

    private ShopItem transformEntity(ShopEntity shopEntity){
        return new ShopItem(
                shopEntity.getId(),
                shopEntity.getArtikelName(),
                shopEntity.getWareVorhanden()
        );
    }
}
