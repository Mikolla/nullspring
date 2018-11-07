


import ru.nullspring.model.User;
import ru.nullspring.service.abstraction.user.UserService;
import ru.nullspring.service.impl.user.UserServiceImpl;
import ru.nullspring.util.SingleDBHelper;

import java.sql.SQLException;

public class testclass {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        for (int i = 0; i < 5; i++) {
            SingleDBHelper.getInstance();
        }
        System.out.println(SingleDBHelper.instanceCount);

        UserService service =  new UserServiceImpl();
        User user = service.getUserByLogin("log");
        System.out.println(user.toString());


    }
}
