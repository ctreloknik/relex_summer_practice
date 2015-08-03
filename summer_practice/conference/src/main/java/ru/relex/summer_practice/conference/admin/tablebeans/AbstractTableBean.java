package ru.relex.summer_practice.conference.admin.tablebeans;

import org.primefaces.event.RowEditEvent;
import ru.relex.summer_practice.conference.admin.annotations.EntityField;
import ru.relex.summer_practice.conference.admin.annotations.SelectOne;
import ru.relex.summer_practice.dao.GenericCrudDao;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.ManyToOne;

/**
 * Created by Sasha on 30.07.2015.
 */

public abstract class AbstractTableBean implements Serializable, Converter {

    private List<ColumnModel> columns;
    private List<Object> items;
    private GenericCrudDao service;
    private List<Object> selectedItems;
    private Class<?> EntityType;

    @PostConstruct
    public void inti(){
        columns = new ArrayList<ColumnModel>();
        getAllField(this.getClass());
        items = new ArrayList<Object>();
    }

    protected void getAllField(Class<?> c){
        for (Field field : c.getDeclaredFields()){
            if (!field.isAnnotationPresent(EJB.class) && !Modifier.isTransient(field.getModifiers())){
                if (field.isAnnotationPresent(EntityField.class)) {
                    getAllField(field.getType());
                    EntityType = field.getType();
                }else{
                    if (field.getType().equals(Date.class)){
                        columns.add(new ColumnModel(field.getName(),field.getName(),"DateField"));
                    }else
                    if(field.isAnnotationPresent(SelectOne.class)){
                        String nameField = field.getAnnotation(SelectOne.class).field();
                        ColumnModel columnModel = new ColumnModel(nameField,nameField,"SelectOne");
                        columnModel.setMethod(field.getName());
                        columns.add(columnModel);
                    }else {
                        if(!field.isAnnotationPresent(ManyToOne.class)){
                            columns.add(new ColumnModel(field.getName(),field.getName(),"Field"));
                        }
                    }
                }
            }
        }
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setService(GenericCrudDao service) {
        this.service = service;
        this.items = service.ReadAll();
    }

    public void onRowEdit(RowEditEvent event) {
        service.Create(event.getObject());
    }

    public List<Object> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Object> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void delete(){
        items.removeAll(selectedItems);
        service.Delete(selectedItems);
    }

    public void add(){
        try {
            items.add(0, service.Create(EntityType.newInstance()));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
