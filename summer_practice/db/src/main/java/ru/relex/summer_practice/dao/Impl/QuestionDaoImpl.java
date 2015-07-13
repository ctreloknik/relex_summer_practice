package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.QuestionDAO;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public class QuestionDAOImpl extends GenericCRUDDAOImpl<Question, Long> implements QuestionDAO {
    @Override
    public List<Question> ReadQuestionOrderByPerson(boolean desc) {
        String jpql = desc == false ? "SELECT q from Person p JOIN p.questions q ORDER BY p.login" :
                "SELECT q from Person p JOIN p.questions q ORDER BY p.login DESC";
        return this.EexecuteQuery(jpql);
    }

    @Override
    public List<Question> ReadQuestionOrderByDate(boolean desc) {
        String jpql = desc == false ? "SELECT q from Question q ORDER BY q.datetime" :
                "SELECT q from Question q ORDER BY q.datetime DESC";
        return this.EexecuteQuery(jpql);
    }

    @Override
    public List<Question> ReadQuestionOrderByRating(boolean desc) {
        String jpql = desc == false ? "SELECT q from Question q ORDER BY q.rating" :
                "SELECT q from Question q ORDER BY q.rating DESC";
        return this.EexecuteQuery(jpql);
    }

    @Override
    public List<Question> ReadQuestionByPerson(Person person) {
        String jpql = "SELECT q from Question q WHERE q.questioner = :person";
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("person", person);
        return this.EexecuteQuery(jpql,parameters);
    }

    @Override
    public List<Question> ReadQuestionByLecture(Lecture lecture) {
        String jpql = "SELECT q from Question q WHERE q.lecture = :lecture";
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("lecture", lecture);
        return this.EexecuteQuery(jpql,parameters);
    }
}
