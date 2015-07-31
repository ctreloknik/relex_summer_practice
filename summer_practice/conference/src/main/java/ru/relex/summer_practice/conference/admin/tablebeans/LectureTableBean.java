package ru.relex.summer_practice.conference.admin.tablebeans;

import ru.relex.summer_practice.service.LectureService;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by Sasha on 31.07.2015.
 */
@ApplicationScoped
@ManagedBean(name = "lectureTableBean", eager = true)
public class LectureTableBean extends AbstractTableBean {

    @EJB
    LectureService lectureService;

    public LectureService getLectureService() {
        return lectureService;
    }
}
