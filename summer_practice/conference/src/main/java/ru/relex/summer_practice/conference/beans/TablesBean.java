package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.dao.Impl.GenericCrudDaoImpl;
import ru.relex.summer_practice.service.LectureService;
import ru.relex.summer_practice.service.PersonService;
import ru.relex.summer_practice.service.QuestionService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sasha on 16.07.2015.
 */

@Named
@SessionScoped
public class TablesBean implements Serializable{

    @EJB
    PersonService personService;

    @EJB
    QuestionService questionService;

    @EJB
    LectureService lectureService;

    List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @PostConstruct
    public void init() {
        tables = new ArrayList<Table>();
        tables.add(new Table(personService, "id login password fullname phoneNumber email"));
        tables.add(new Table(questionService,"id text rating datetime" ));
        tables.add(new Table(lectureService,"id datetime topic description" ));
    }

    static public class Table implements Serializable{
        private GenericCrudDaoImpl crudDao;
        private List<Object> entitys;

        public List<Object> getEntitys() {
            entitys = crudDao.ReadAll();
            return entitys;
        }

        public void setEntitys(List<Object> entitys) {
            this.entitys = entitys;
        }

        public Table(GenericCrudDaoImpl crudDao, String colums){
            this.crudDao = crudDao;
            this.columns = new ArrayList<ColumnModel>();
            for (String colum: colums.split(" ")){
                this.columns.add(new ColumnModel(colum.toUpperCase(),colum));
            }
        }

        private List<ColumnModel> columns;
        public List<ColumnModel> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnModel> columns) {
            this.columns = columns;
        }
    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }
}
