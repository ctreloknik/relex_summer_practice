package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Message;

import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface MessageDao extends GenericCrudDao<Message, Long> {
    public List<Message> ReadAllByLecture(Lecture lecture);
}
