package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.RolesDao;
import ru.relex.summer_practice.db.Roles;

import java.util.Collection;

/**
 * Created by Nikita on 12.07.2015.
 */
public class RolesDaoImpl extends GenericCrudDaoImpl<Roles, Long> implements RolesDao {
    public Roles Create(Roles roles){
        return super.Create(roles);
    }

    public Roles Read(Long id){
        return super.Read(id);
    }

    public Collection<Roles> ReadAll(){
        return super.ReadAll();
    }

    public Roles Update(Roles roles){
        return super.Update(roles);
    }

    public void Delete(Long id){
        super.Delete(id);
    }
}
