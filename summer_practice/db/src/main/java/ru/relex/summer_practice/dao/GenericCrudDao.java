package ru.relex.summer_practice.dao;

import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface GenericCrudDao<T, PK> {
    public T Create(T t);
    public T Read (PK id);
    public T Update(T t);
    public void Delete(PK id);
    public List<T> ReadAll();
    public void Delete(List<T> t);
}
