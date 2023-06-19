package com.webtech.project.demo.web.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    List<ShopEntity> findAllByArtikelName(String artikelName);

}
