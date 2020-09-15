package com.favoriteMuisc.FavoriteMusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.favoriteMuisc.FavoriteMusic.domain.Song;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

}
