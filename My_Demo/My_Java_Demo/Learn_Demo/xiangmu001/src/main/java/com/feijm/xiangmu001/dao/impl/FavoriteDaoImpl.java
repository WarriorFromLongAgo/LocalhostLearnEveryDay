package com.feijm.xiangmu001.dao.impl;

import com.feijm.xiangmu001.dao.IFavoriteDao;
import com.feijm.xiangmu001.domain.Favorite;
import com.feijm.xiangmu001.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteDaoImpl implements IFavoriteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findFavoriteByRidUidDao(int rid, int uid) {

//        INSERT INTO mybatisdemo(birthday) VALUES ( NOW());
//          2019-10-10 19:33:26
//        INSERT INTO mybatisdemo(birthday) VALUES ( CURDATE());
//        2019-10-10 00:00:00

        String sql = "SELECT * FROM tab_favorite WHERE rid = ? AND uid = ?";

        try {

            System.out.println("favorite qian");
            Favorite favorite = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Favorite.class), rid, uid);
            System.out.println("favorite hou");
            return favorite;

        } catch (DataAccessException e) {
            System.out.println("findFavoriteByRidUidDao");
            return null;
        }
    }

    @Override
    public Integer findCountByRidDao(int rid) {
        String sql = "SELECT COUNT(rid) FROM tab_favorite WHERE rid = ?";
        try {
            System.out.println(" findCountByRidDao  qian ");
            Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, rid);
            System.out.println(" findCountByRidDao  hou ");

            return integer;

        } catch (DataAccessException e) {
            System.out.println("findFavoriteByRidUidDao");
            return null;
        }
    }

    @Override
    public boolean addFavoriteDao(int rid, int uid) {
        String sql = "INSERT INTO tab_favorite(rid, DATE, uid) VALUES (?, NOW(), ?)";

        System.out.println("addFavoriteDao qian");
        int update = jdbcTemplate.update(sql, rid, uid);

        System.out.println("addFavoriteDao hou ");

        return update > 0;

    }

    @Override
    public boolean removeFavoriteDao(int rid, int uid) {
        String sql = "DELETE FROM tab_favorite WHERE rid = ? AND uid = ?";

        System.out.println("removeFavoriteDao  qian ");

        int update = jdbcTemplate.update(sql, rid, uid);

        System.out.println("removeFavoriteDao  qian ");

        return update > 0;
    }
}
