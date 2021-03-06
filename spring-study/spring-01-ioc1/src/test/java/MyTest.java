import com.yy.dao.impl.UserDaoImpl;
import com.yy.dao.impl.UserDaoMysqlImpl;
import com.yy.dao.impl.UserOracleImpl;
import com.yy.dao.impl.UserSqlserverImpl;
import com.yy.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        // 用户实际调用的是业务层，dao层他们不需要接触
        //UserServiceImpl userService = new UserServiceImpl();
        //userService.setUserDao(new UserSqlserverImpl());
        //userService.getUser();

        //获取ApplicationContext; 拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //容器在手，天下我有！ 需要什么，就直接get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
