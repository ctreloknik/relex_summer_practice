package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.LectureRoom;

/**
 * Created by Nikita on 12.07.2015.
 */
public interface LectureRoomDAO extends GenericCRUDDAO<LectureRoom, Long> {
    public String getNumber(LectureRoom lectureRoom);
    public int getSeating(LectureRoom lectureRoom);
}
