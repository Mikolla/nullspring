package ru.nullspring.dao.impl.user;

import ru.nullspring.dao.abstraction.user.UserDao;
import ru.nullspring.util.PropertiesReader;

public class DaoFactory {
    public UserDao makeDao() {
        String useTech = PropertiesReader.getProperties("useTech");
        if ( useTech.equals("hibernate")) {
            return  new UserDaoImplHibernate();
        } else if  ( useTech.equals("jdbc")) {
            return new UserDaoImpljdbc();
        } else {
            return new UserDaoImpljdbc();
        }
    }
}
