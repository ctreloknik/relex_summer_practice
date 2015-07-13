package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Conference;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface ConferenceDao extends GenericCrudDao<Conference, Long> {
    public String getName(Conference conference);
    public String getDescription(Conference conference);
}
