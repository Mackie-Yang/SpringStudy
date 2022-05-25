import com.yy.pojo.User;
import com.yy.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        //User user = new User();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //User user = (User) context.getBean("user");
        //User user2 = (User) context.getBean("user");
        //System.out.println(user == user2);

        UserT user = (UserT) context.getBean("u4");
        user.show();
    }
}
