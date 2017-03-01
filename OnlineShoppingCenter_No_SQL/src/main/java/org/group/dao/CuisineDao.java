package org.group.dao;

/**
 * Created by lincolnz9511 on 16-11-26.
 */
import org.group.entity.Cuisine;

public interface CuisineDao {
    public Cuisine createCuisine(Cuisine cuisine);
    public void updateCuisine(Cuisine cuisine);
    public void deleteCuisine(String cuisine_name);
    public Cuisine findByName(String cuisine_name);
}

