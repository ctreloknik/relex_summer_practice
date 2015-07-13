package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Lecture;

import java.util.Date;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface LectureDao extends GenericCrudDao<Lecture, Long> {
    public String getTopic(Lecture lecture);
    public Date getDatetime(Lecture lecture);
    public String getDescription(Lecture lecture);
}
