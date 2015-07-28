package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;
import ru.relex.summer_practice.db.Rating;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface RatingDao extends GenericCrudDao<Rating,Long>{
    public boolean AddRating(Person person, Question question, int rating);
}
