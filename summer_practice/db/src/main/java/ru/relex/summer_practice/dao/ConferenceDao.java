package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Person;

import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface ConferenceDao extends GenericCrudDao<Conference, Long> {
    public String getName(Conference conference);
    public String getDescription(Conference conference);
    public List<Conference> getModeratedConference(Boolean moderated);
    public List<Conference> getTicketsForBuying(Person person);
}
