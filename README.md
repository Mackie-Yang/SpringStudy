### 1、Spring

#### 1.1 简介

**历史**

- 2002，首次推出了Spring框架的雏形：interface21框架。
- Spring框架即以interface21框架为基础经过重新设计，并不断丰富其内涵，与2004年3月24号，发布了1.0正式版。
- Rod Johnson，SpringFramework创始人，著名作家。很难想象Rod Johnson的学历，真的让人大吃一惊，他是悉尼大学的博士，然而他的专业并不是计算机，而是音乐学。
- spring理念：是现有的技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架。
- 官网：https://docs.spring.io/spring-framework/docs/current/reference/html/
- 官方下载地址：http://repo.spring.io/release/org/projects/spring-framework/spring
- GitHub：https://github.com/spring-projects/psring-framework

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.20</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.20</version>
</dependency>

```



#### 1.2 优点

- Spring是一个开源免费的框架、容器
- Spring是一个轻量级的框架，非侵入式的框架
- **控制反转（IOC），面向切面（AOP）**
- 对事务的支持，对框架整合的支持



==一句话总结就是：Spring是一个轻量级的控制反转（IOC）和面向切面（AOP）的框架==



#### 1.3 组成

![1653277277210](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653277277210.png)

Spring由七大模块组成：

- **Spring核心容器（Core）：**提供Spring框架的基本功能。核心容器主要组件是BeanFactory，它是工厂模式的实现。BeanFactory使用控制反转（IOC）模式将应用程序和依赖性规范与实际的应用代码程序分开。
- **Spring AOP：**通过配置管理特性，Spring AOP模块直接面向方面的程序模块功能集成到了Spring框架中，所以可以很容易的使Spring框架管理的任何对象支持AOP。SpringAOP模块为基于Spring的应用程序中的对象提供了事务管理服务。通过使用Spring AOP，不用买依赖于EJB组件，就可以直接将声明性事务管理集成到应用程序中。
- **Spring ORM：**Spring框架集成了若干个ORM框架，从而提供了ORM的对象关系工具，其中包括JDO、Hibernate、iBatis和TopLink。所有这些都遵从Spring的通用事务和DAO异常层结构。
- **Spring DAO：**JDBC DAO抽象层提供了由意义的一场层次的结构，可用以该结构来管理异常处理和不同数据供应商抛出的异常错误信息。异常层次结构简化了错误处理，并且大大降低了需要编写的异常代码数量（例如，打开和关闭连接）。Spring DAO的面向JDBC的异常遵从通用的DAO异常层结构。
- **Spring WEB：**Web上下文模块建立在上下文模块（Context）的基础之上，为基于Web服务的应用程序提供了上下文的服务。所以Spring框架支持Jakarta Struts的集成。Web模块还简化了1处理多部分请求及将请求参数绑定到域对象的工作。
- **Spring 上下文（Context）：**Spring上下文是一个配置文件，向Spring框架提供上下文信息。Spring上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化校验和调度功能。
- **Spring MVC：**Spring的MVC框架是一个全功能的构建Web应用程序的MVC实现。通过策略接口，NVC框架变成高度可配置的，MVC容纳的大量试图技术，包括JSP、Velocity、Tiles、iText和Pol。



#### 1.4 拓展

基于Spring的开发

![1653280766465](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653280766465.png)

- Spring Boot
  - 一个快速开发的脚手架
  - 基于SpringBoot可以快速的开发单个微服务
  - 约定大于配置
- Spring Cloud
  - SpringCloud是基于SpringBoot实现的

现在大多数公司都在使用SpringBoot进行快速开发，学习SpringBoot的前提，需要完全掌握Spring及SpringMVC

**弊端：发展了太久了之后，违背了原来的理念，配置十分繁琐，人称“配置地狱”**

### 2、IOC理念推导

1. UserDao接口
2. UserDaoImpl实现类
3. UserService业务接口
4. UserServiceImpl业务实现类

在我们之前的代码中，用户的需求可能会影响我们原来的代码，我们需要根据用户的需求去修改原来的代码。如果程序代码量十分大，修改一次的成本代价十分昂贵。



我们使用一个set接口实现。已经发生了革命性的变化。

```java
	private UserDao userDao;
    // 利用set进行动态实现值的注入！
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
```

- 之前，程序是主动创建对象，控制权在程序员手上
- 使用了set注入后，程序不再具有主动性，而是变成了被动的接受对象

这种思想，从本质上解决了问题，我们程序员不用再去管理对象的创建了。系统的耦合性大大降低，可以更加的专注在业务的实现上。这是IOC的原型。

![1653359818009](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653359818009.png)

#### IOC本质

**控制反转IOC（Inverssion of Control），是一种设计思想，DI（依赖注入）是实现IOC的一种方法**，也有人认为DI只是IOC的另一种说法。没有IOC的程序中，我们使用面向对象程序编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓的控制反转就是：获得依赖的对象的方式反转了。

**IOC是Srping框架的核心内容**，使用了多种方式完美实现了IOC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IOC。

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从IOC容器中取出需要的对象。

采用XMl方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到零配置的目的。

**控制反转是一种通过描述（XML或注释）并通过第三方去产生或获取特定对象的方式。在Spring中实现控制反转的是IOC容器，其实现方法是依赖注入（Dependency Injection，DI）。**

3、HelloSpring

控制：谁来控制对象的创建，传统应用程序·的对象是由程序本身控制创建的，使用Spring之后，对象是由Spring来创建的。

反转：程序本身不创建对象，而编程被动的接收对象

依赖注入：就是利用set方法来进行注入的

IOC是一种编程思想，由主动的编程编程被动的接收

可以通过newClassPathXmlApplicationContext去浏览一下底层代码

![1653367281089](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653367281089.png)

### 4、IOC创建的方式

1. 使用无参构造对象，默认

2. 假设我们要使用有参构造创建对象

   1. 下标赋值

      ```xml
      <bean id="user" class="com.yy.pojo.User">
              <constructor-arg index="0" value="狂神说Java"/>
          </bean>
      ```

   2. 类型

   ```xml
      <bean id="user" class="com.yy.pojo.User">
              <constructor-arg type="java.lang.String" value="秦疆"/>
          </bean>
   ```

   3. 参数名

      ```xml
      <bean id="user" class="com.yy.pojo.User">
              <constructor-arg name="name" value="秦疆"/>
          </bean>
      ```

Spring容器，类似于婚介网站

总结：在配置文件加载的时候，容器中的对象就已经初始化了

### 5、Spring配置

#### 5.1 别名

```xml
<!-- 别名，如果添加了别名，我们也可以用别名获取到这个对象 -->
    <alias name="user" alias="userNew"/>
```

#### 5.2 Bean的配置

```xml
<!--
    id: bean的唯一标识符，也就是相当于我们学的对象名
    class: bean对象所对应的权限定名： 包名 + 类型
    name: 也是别名,而且name可以取多个别名
    -->
    <bean id="userT" class="com.yy.pojo.UserT" name="user2 u2,u3;u4">
        <property name="name" value="西部开源"/>
    </bean>
```

#### 5.3 import

这个import，一般用于团队开发，他可以将多个配置文件，导入合并为一个

假设，项目中有多个人开发，这三个人负责不同的类，不同的类需要注册在不同的bean中，我们可以利用import将所有人的beans.xml合并为一个总的

- 张三

- 李四

- 王五

- applicationContext.xml

  ```xml
  <import resource="beans.xml"/>
  <import resource="beans2.xml"/>
  <import resource="beans3.xml"/>
  ```

  

使用的时候，直接使用总的配置就可以了

### 6、DI（依赖注入）

#### 6.1 构造器注入



#### 6.2 Set注入

- 依赖注入：Set注入
  - 依赖：bean对象的创建依赖于容器
  - 注入：bean对象中的所有属性，由容器来注入

【环境搭载】

1. 复杂类型

   ```java
   package com.yy.pojo;
   
   public class Address {
       private String address;
   
       public String getAddress() {
           return address;
       }
   
       public void setAddress(String address) {
           this.address = address;
       }
   }
   
   
   ```

   

2. 真实测试对象

   ```java
   package com.yy.pojo;
   
   import java.util.*;
   
   public class Student {
   
       private String name;
       private Address address;
       private String[] books;
       private List<String> hobbies;
       private Map<String, String> card;
       private Set<String> games;
       private Properties info;
       private String wife;
   
       public String getName() {
           return name;
       }
   
       public void setName(String name) {
           this.name = name;
       }
   
       public Address getAddress() {
           return address;
       }
   
       public void setAddress(Address address) {
           this.address = address;
       }
   
       public String[] getBooks() {
           return books;
       }
   
       public void setBooks(String[] books) {
           this.books = books;
       }
   
       public List<String> getHobbies() {
           return hobbies;
       }
   
       public void setHobbies(List<String> hobbies) {
           this.hobbies = hobbies;
       }
   
       public Map<String, String> getCard() {
           return card;
       }
   
       public void setCard(Map<String, String> card) {
           this.card = card;
       }
   
       public Set<String> getGames() {
           return games;
       }
   
       public void setGames(Set<String> games) {
           this.games = games;
       }
   
       public Properties getInfo() {
           return info;
       }
   
       public void setInfo(Properties info) {
           this.info = info;
       }
   
       public String getWife() {
           return wife;
       }
   
       public void setWife(String wife) {
           this.wife = wife;
       }
   
       @Override
       public String toString() {
           return "Student{" +
                   "name='" + name + '\'' +
                   ", address=" + address +
                   ", books=" + Arrays.toString(books) +
                   ", hobbies=" + hobbies +
                   ", card=" + card +
                   ", games=" + games +
                   ", info=" + info +
                   ", wife='" + wife + '\'' +
                   '}';
       }
   }
   
   
   ```

3. beans.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd">
       <bean id="student" class="com.yy.pojo.Student">
           <!--1. 普通值注入，value-->
           <property name="name" value="秦疆"/>
       </bean>
   </beans>
   
   ```

4. 测试类

   ```java
   public class MyTest {
       public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
           Student student = (Student) context.getBean("student");
           System.out.println(student.getName());
       }
   }
   
   ```

   

完善注入信息：

```xml
<bean id="address" class="com.yy.pojo.Address">
        <property name="address" value="西安"/>
     </bean>
    <bean id="student" class="com.yy.pojo.Student">
        <!--1. 普通值注入，value-->
        <property name="name" value="秦疆"/>
        <!--2. Bean注入，ref-->
        <property name="address" ref="address"/>
        <!--3. 数组注入-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>西游记</value>
                <value>水浒传</value>
                <value>三国演义</value>
            </array>
        </property>
        <!--List注入-->
        <property name="hobbies">
            <list>
                <value>听歌</value>
                <value>敲打吗</value>
                <value>看电影</value>
            </list>
        </property>
        <!--Map注入-->
        <property name="card">
            <map>
                <entry key="身份证" value="11111122222233333"/>
                <entry key="银行卡" value="112121212121331312"/>
            </map>
        </property>
        <!--Set注入-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>
        <!--null注入-->
        <property name="wife">
            <null/>
        </property>
        <!--Property注入-->
        <property name="info">
            <props>
                <prop key="学号">20190525</prop>
                <prop key="性别">男</prop>
                <prop key="姓名">小明</prop>
            </props>
        </property>
    </bean>

```



#### 6.3 扩展方式注入

我们可以使用p命名空间和c命名空间进行注入

官方解释：

![1653409839050](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653409839050.png)

使用：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间注入，可以直接注入属性的值：property-->
    <bean id="user" class="com.yy.pojo.User" p:name="秦疆" p:age="18"/>
    <!--c命名空间注入，通过构造器注入：construct-args-->
    <bean id="user2" class="com.yy.pojo.User" c:age="18" c:name="狂神"/>
</beans>

```

测试：

```java
@Test
public void test2() {
    ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
    User user = context.getBean("user2", User.class);
    System.out.println(user);
}

```

注意点：p命名和c命名空间不能直接使用，需要导入xml约束

```xml
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c"

```



#### 6.4 bean的作用域

![1653410178932](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653410178932.png)

1.单例模式 （Spring默认机制）

![1653410278596](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653410278596.png)

```xml
<bean id="user2" class="com.yy.pojo.User" c:age="18" c:name="狂神" scope="singleton"/>

```

2.原型模式：每次从容器中get的时候，都会产生一个新对象

![1653410554823](C:\Users\93599\AppData\Roaming\Typora\typora-user-images\1653410554823.png)

```xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>

```

3.其余的 request、session、application 这些只能在web开发中使用到



### 7、Bean的自动装配

- 自动装配是Spring满足bean依赖的一种方式
- Spring会在下上文中自动寻找，并自动给bean装配属性

在Spring中有三种装配的方式：

1. 在xml中显示的配置
2. 在java中显示配置
3. 隐式的自动装配bean【重要】

#### 7.1 测试

环境搭建：一个人有两个宠物



#### 7.2 ByName自动装配

```xml
<!--
byName: 会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid
-->
<bean id="person" class="com.yy.pojo.Person" autowire="byName">
    <property name="name" value="小狂神呀"/>
</bean>

```



#### 7.3 ByType自动装配

```xml
<bean class="com.yy.pojo.Cat"/>
<bean class="com.yy.pojo.Dog"/>
<!--
byName: 会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanId
byType: 会自动在容器上下文中查找，和自己对象类型相同的bean
-->
<bean id="person" class="com.yy.pojo.Person" autowire="byType">
    <property name="name" value="小狂神呀"/>
</bean>

```

小结：

- byName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致
- byType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致



#### 7.4 使用注解实现自动装配

jdk1.5支持的注解，Spring从2.5就开始支持注解

The introduction of annotation-based configuration raised the question of whether this approach is “better” than XML. 

要使用注解须知：

1. 导入约束：context约束
2. 配置注解的支持：<context:annotation-config/>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>

```

@Autowired
