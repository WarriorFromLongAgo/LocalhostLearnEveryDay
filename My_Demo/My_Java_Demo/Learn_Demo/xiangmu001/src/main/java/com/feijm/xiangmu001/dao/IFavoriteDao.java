package com.feijm.xiangmu001.dao;

import com.feijm.xiangmu001.domain.Favorite;

public interface IFavoriteDao {
    Favorite findFavoriteByRidUidDao(int rid, int uid);

    Integer findCountByRidDao(int rid);

    boolean addFavoriteDao(int rid, int uid);

    boolean removeFavoriteDao(int rid, int uid);
}
