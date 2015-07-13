package ru.relex.summer_practice.dao;


import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;

import java.util.Date;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface QuestionDao extends GenericCrudDao<Question, Long> {
    public List<Question> ReadQuestionOrderByDate (boolean desc);
    public List<Question> ReadQuestionOrderByRating (boolean desc);
    public List<Question> ReadQuestionOrderByPerson (boolean desc);
    public List<Question> ReadQuestionByPerson (Person person);
    public List<Question> ReadQuestionByLecture (Lecture lecture);
}
