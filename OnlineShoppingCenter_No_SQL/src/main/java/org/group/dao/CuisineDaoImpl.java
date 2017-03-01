package org.group.dao;

import org.group.entity.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by lincolnz9511 on 16-11-26.
 */
@Repository
public class CuisineDaoImpl  implements CuisineDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cuisine createCuisine(final Cuisine cuisine) {
        final String sql
                = "insert into cuisines(cuisine_name, description, price) values(?,?,?)";
        jdbcTemplate.update(sql, cuisine.getCuisine_name(),cuisine.getDescription(),cuisine.getPrice());
        return cuisine;
    }

    public void updateCuisine(Cuisine cuisine) {
        String sql = "update cuisines set cuisine_name=?, description=?, price=?  where cuisine_name=?";
        jdbcTemplate.update(sql, cuisine.getCuisine_name(),cuisine.getDescription(),cuisine.getPrice(),cuisine.getCuisine_name());
    }

    public void deleteCuisine(String cuisine_name) {
        String sql = "delete from cuisines where cuisine_name=?";
        jdbcTemplate.update(sql, cuisine_name);
    }

    public Cuisine findByName(String cuisine_name) {
        String sql = "select cuisine_name, description, price  from cuisines where cuisine_name=?";
        List<Cuisine> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Cuisine.class), cuisine_name);
        if(userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }
}

