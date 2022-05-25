import com.yy.pojo.Student;
import com.yy.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());

        /**
         * Student{
         * name='秦疆',
         * address=Address{address='null'},
         * books=[红楼梦, 西游记, 水浒传, 三国演义],
         * hobbies=[听歌, 敲打吗, 看电影],
         * card={身份证=11111122222233333, 银行卡=112121212121331312},
         * games=[LOL, COC, BOB],
         * info={学号=20190525, 性别=男, 姓名=小明},
         * wife='null'}
         */

    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);
        User user2 = context.getBean("user2", User.class);
        System.out.println(user == user2);
    }

}
