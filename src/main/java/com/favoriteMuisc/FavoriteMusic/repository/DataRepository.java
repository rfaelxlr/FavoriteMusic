package com.favoriteMuisc.FavoriteMusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.favoriteMuisc.FavoriteMusic.domain.Data;

@Repository
public interface DataRepository extends JpaRepository<Data,Integer> {

}
