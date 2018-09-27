package com.example;

import com.example.event.EmailEvent;
import com.example.service.*;
import com.example.util.DataSource;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

public class SpringTest {
    public static void main(String[] args){
        // 创建 Spring 容器 ApplicationContext
        // ApplicationContext 是Spring的核心， Spring中绝大部分功能是通过该容器实现的
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("实例化ApplicationContext： " + context);

        // Spring容器（ApplicationContext） 可以根据配置文件信息（spring-config.xml），创建PersonService的实例，并为实例设置属性值
        // 这种由容器对象为对象设置属性值的方式称为控制反转

        PersonService p = context.getBean("personService", PersonService.class);
        p.info();

        // P537 使用 设值注入
        Person person = context.getBean("chinese", Person.class);
        person.useAxe();

        String[] a = {"Howard"};
        String hello = context.getMessage("hello", a, Locale.getDefault());
        Object[] b = {new Date()};

        String now = context.getMessage("now", b, Locale.getDefault());
        System.out.println(hello);
        System.out.println(now);

        // 主动触发容器事件
        EmailEvent emailEvent = new EmailEvent("springTest", "houdd321@hotmail.com", "this is a test");
        context.publishEvent(emailEvent);

        // 判断两次请求 Bean 实例是否相等 - singleton 作用域
        System.out.println(context.getBean("personService") == context.getBean("personService"));
        // 判断两次请求 Bean 实例是否相等 - prototype 作用域
        System.out.println(context.getBean("personService2") == context.getBean("personService2"));

        Chinese achinese = context.getBean("achinese", Chinese.class);
        System.out.println("姓名：" + achinese.getName() + " 年龄：" + achinese.getAge() + " 身高：" + achinese.getHeight());

        // 注入集合值
        context.getBean("chinese2", Chinese.class).testCollection();

        // 复合属性
        Chinese chinese3 = context.getBean("chinese3", Chinese.class);
        System.out.println(chinese3.getAxe().getName());

        // 使用 Java 类进行配置管理
        Chinese chinese4 = context.getBean("chinese4", Chinese.class);
        System.out.println("姓名： " + chinese4.getName() + " 斧头： " +chinese4.getAxe());

        // 使用静态工厂创建Bean, Bean 由静态工厂负责创建，静态工厂(BeingFactory)由Spring容器负责管理
        Being b1 = context.getBean("dog", Being.class);
        b1.testBeing();
        Being b2 = context.getBean("cat", Being.class);
        b2.testBeing();

        // 使用实例工厂创建Bean, Bean 由实例工厂负责创建，实例工厂(PersonFactory)由Spring容器负责创建和管理
        Person p1 = context.getBean("chinese5", Person.class);
        System.out.println(p1.sayHello("张三") + " " + p1.sayGoodBye("张三"));
        Person p2 = context.getBean("american", Person.class);
        System.out.println(p2.sayHello("Jackee") + " " + p2.sayGoodBye("Jackee"));

        // 使用工作Bean：Spring 容器通过getBean方法获取工厂Bean时，容器不会返回FactoryBean实例，而是返回该 FactoryBean 的产品
        Person p3 = context.getBean("chinese6", Person.class);
        System.out.println(p3.sayHello("Marry") + " " + p3.sayGoodBye("Marry"));
        Person p4 = context.getBean("chinese6", Person.class);
        System.out.println(p3 == p4);
        // 要获取 FactoryBean 本身时， 需在 FactoryBean ID 前面加 &
        System.out.println("FactoryBean 本身: "+ context.getBean("&chinese6"));

        // 获取Bean本身的ID： 需要Bean实现BeanNameAware中的setBeanName方法，该方法有Spring容器调用
        English english = context.getBean("english", English.class);
        english.info();

        // 让Bean能够访问Spring容器: 通过实现 ApplicationContextAware 接口中的 setApplicationContext() 方法, 该方法由Spring容器调用
        Japanese japanese = context.getBean("japanese", Japanese.class);
        System.out.println("japanese.getFactory() ："+ japanese.getFactory());
        System.out.println("japanese.getContext() ："+ japanese.getContext());
        System.out.println("context == japanese.getContext() : " + (context == japanese.getContext()));

        // 实现 Bean 销毁之前的行为
        Person person2 = context.getBean("french", Person.class);
        person2.useAxe();
        // 为Spring容器注册一个关闭的钩子，保证关闭Spring容器之前调用实例的析构函数
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

        // 协调作用域不同步的Bean，
        German german = context.getBean("german", German.class);
        // 每次调用 getAxe 方法，都会产生不同的 Axe 实例
        System.out.println("获取Axe实例： " + german.getAxe());
        System.out.println("获取Axe实例： " + german.getAxe());

        // 注入其他Bean的属性值
        System.out.println("pet1: "+ context.getBean("pet1"));

        // 将目标Bean的属性值定义成 Bean实例
        System.out.println("pet2: "+ context.getBean("pet2"));
        System.out.println("canada.pet: "+ context.getBean("canada", Canada.class).getPet());

        System.out.println("theAge: "+ context.getBean("theAge"));

        // 注入其他Bean中的方法的返回值: 指定调用目标Bean的哪个方法
        System.out.println("pet3: "+ context.getBean("pet3", Pet.class).getAge());
        // 注入其他Bean中的方法的返回值： 指定调用目标类的哪个静态方法
        System.out.println("pet4: "+ context.getBean("pet4", Pet.class).getAge());
        // 注入其他Bean中的方法的返回值： 指定调用目标类的哪个静态方法（方法带参数）
        System.out.println("java version: "+ context.getBean("javaVersion"));

        // 使用 p 名称空间配置属性
        System.out.println("korean2: " + context.getBean("korean2", Korean.class).getName());

        spelTest();

        // 在Spring 配置文件中 使用表达式语言配置Bean
        System.out.println("korean3: " + context.getBean("korean3", Korean.class).getName());

        spelTest2();

        // 使用属性占位符配置器（一个容器后处理器）：PropertyPlaceholderConfigurer，它会读取属性文件信息，
        System.out.println("dataSource: " + context.getBean("dataSource", DataSource.class).getDriver());
    }

    public static void spelTest(){
        // ExpressionParser 用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();

        // 最简单的字符串表达式
        Expression expression = parser.parseExpression("'HelloWorld'");
        System.out.println("'HelloWorld'的结果： "+ expression.getValue());

        // 调用方法的表达式
        expression = parser.parseExpression("'HelloWorld'.concat('!')");
        System.out.println("'HelloWorld'.concat('!')的结果： "+ expression.getValue() + " vs. " + "HelloWorld".concat("!"));

        // 调用对象的getter 方法
        expression = parser.parseExpression("'HelloWorld'.bytes");
        System.out.println("'HelloWorld'.bytes的结果： "+ expression.getValue() + " vs. " + "HelloWorld".getBytes());

        // 访问对象的属性
        expression = parser.parseExpression("'HelloWorld'.bytes.length");
        System.out.println("'HelloWorld'.bytes.length的结果： "+ expression.getValue() + " vs. " + "HelloWorld".getBytes().length);

        // 使用构造函数创建对象
        expression = parser.parseExpression("new String('HelloWorld')" + ".toUpperCase()");
        System.out.println("new String('HelloWorld')" +".toUpperCase() 的结果： "+ expression.getValue() + " vs. "
                + new String("HelloWorld").toUpperCase());

        // 以指定的对象作为root来计算表达式的值， 相当于调用 chinese.name表达式
        Chinese chinese = new Chinese();
        chinese.setName("齐天大圣");
        expression = parser.parseExpression("name");
        System.out.println("以 chinese 为root， name表达式的值是： "+ expression.getValue(chinese, String.class));

        // 以指定的context来计算表达式的值, EvaluationContext 只能有1个root 对象
        expression = parser.parseExpression("name=='孙大圣'");
        StandardEvaluationContext context = new StandardEvaluationContext();
        // 设置根对象, 访问 EvaluationContext 根对象时，可以省略root对象
        context.setRootObject(chinese);
        System.out.println("以指定的 context， name=='孙大圣' 表达式的值是： "+ expression.getValue(context, Boolean.class));

        // 修改表达式的值
        List<Boolean> list = new ArrayList<Boolean>();
        list.add(true);
        // 往 context 里放入对象， 访问 EvaluationContext 中指定对象时，要用OGNL格式：#list
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("list", list);
        expression = parser.parseExpression("#list[0]");
        expression.setValue(context2, "false");
        System.out.println("list的第一个元素：" + list.get(0));
    }

    public static void spelTest2(){
        ExpressionParser parser = new SpelExpressionParser();

        // 1. 直接量表达式：就是使用Java语言支持的直接量，如：字符串、日期、数值等
        double num = parser.parseExpression("0.23").getValue(Double.class);
        System.out.println(num);

        // 2. 在表达式中创建数组
        Expression expression = parser.parseExpression("new String[]{'Java','Spring'}");
        System.out.println(expression.getValue());

        // 3. 在表达式中创建List集合
        expression = parser.parseExpression("{'Java', 'Spring Framework'}");
        System.out.println(expression.getValue());

        // 4. 在表达式中 访问 List 、 Map 等集合元素
        // 9. 在表达式中 使用变量， SpEL是通过 EvaluationContext 来配置变量，通过 #变量名称 来访问变量
        List<String> list = new ArrayList<String >();
        list.add("head first java");
        list.add("spring framework");
        Map<String,Double> map = new HashMap<String, Double>();
        map.put("java", 80.0);
        map.put("spring", 90.3);
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("list", list);
        context.setVariable("map", map);
        System.out.println(parser.parseExpression("#list[0]").getValue(context));
        System.out.println(parser.parseExpression("#map['java']").getValue(context));

        // 5. 在表达式中 调用方法
        System.out.println(parser.parseExpression("'HelloWorld'.substring(2,5)").getValue());
        System.out.println(parser.parseExpression("#list.add('Servlet')").getValue(context));
        System.out.println(list);

        // 6. 在表达式中 使用算术、比较、逻辑、赋值等运算符
        parser.parseExpression("#list[0]='Head First Java'").getValue(context);
        System.out.println(list.get(0));

        // 7. 在表达式中 使用类型运算符 T() , 告诉SpEL将T()运算符内的字符串当成"类"
        System.out.println(parser.parseExpression("T(java.lang.System).getProperty('os.name')").getValue());

        // 8. 在表达式中 使用new调用类的构造函数
        System.out.println(parser.parseExpression("new String('HelloWorld').substring(2,6)").getValue());

        // 11. 在表达式中 使用安全导航操作, 如果foo为空时，将返回 null
        System.out.println(parser.parseExpression("#foo?.bar").getValue(context));

        // 12. 对集合元素进行选择
        // 集合选择语法：collection.?[condition_expr]
        // 只有当 condition_expr 返回 true时，对应的集合元素才会被筛选出来
        System.out.println(parser.parseExpression("#list.?[length()>7]").getValue(context));
        System.out.println(parser.parseExpression("#map.?[value>90]").getValue(context));

        // 13. 集合投影运算
        // 集合投影运输的语法：collection.![condition_expr]
        // 会依次将 collection 集合中的元素传人 condition_expr 中，并得到新的结果，最后组成新的集合
        System.out.println(parser.parseExpression("#list.![length()]").getValue(context));

        // 14. 表达式模板
        expression = parser.parseExpression("我的姓名是: #{name}, 年龄是: #{age}", new TemplateParserContext());
        Chinese chinese = new Chinese();
        chinese.setName("张小平");
        chinese.setAge(38);
        System.out.println(expression.getValue(chinese));
    }
}
