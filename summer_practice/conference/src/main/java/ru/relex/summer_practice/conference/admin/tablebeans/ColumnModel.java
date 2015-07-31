package ru.relex.summer_practice.conference.admin.tablebeans;

/**
 * Created by Sasha on 30.07.2015.
 */
public class ColumnModel {
    private String header;
    private String property;
    private String method;
    private String type;

    public ColumnModel(String header, String property, String type) {
        this.header = header;
        this.property = property;
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public String getProperty() {
        return property;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }
}
