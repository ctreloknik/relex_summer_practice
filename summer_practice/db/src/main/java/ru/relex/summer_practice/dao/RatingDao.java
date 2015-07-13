package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface RatingDAO {
    public void AddRating(Person person, Question question, int rating);
}
