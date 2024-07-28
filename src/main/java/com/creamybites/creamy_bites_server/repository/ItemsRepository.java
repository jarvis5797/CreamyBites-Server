package com.creamybites.creamy_bites_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creamybites.creamy_bites_server.entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

}
