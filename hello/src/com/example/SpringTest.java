package com.example;

import com.example.service.Chinese;
import com.example.service.English;
import com.example.service.French;
import com.example.service.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Date;

public class SpringTest {
    public static void main(String[] args){

//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 通过指定前缀，访问ClassPathResource资源
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:bean.xml");

        // 使用 @Component 标注一个普通的 Spring Bean 类
        System.out.println("-----------" + Arrays.toString(context.getBeanDefinitionNames()));

        // 使用 @Resource 配置依赖，将 steelAxe 注入到 setter 方法
        context.getBean("chinese", Chinese.class).useAxe();

        // 使用 @Autowired 进行自动装配，Spring 采用 byType 或 byName 自动装配策略，并将该Bean的实例作为 setter 的参数传人
        context.getBean("english", English.class).useAxe();

        context.getBean("english", English.class).feedBeing();

        // 使用 @Autowired 标注多个参数的 普通方法
        // 使用 @Autowired 标注多参数的 构造函数
        // 使用 @Autowired 标注 Field
        context.getBean("french", French.class).useAxe();

        System.out.println("------------------------------------------------------------------");
        try {
            // 使用 UrlResource 访问网络资源文件
            urlResourceTest();

            System.out.println("------------------------------------------------------------------");

            // 使用 ClassPathResource 访问类加载路径下的资源
            classPathResourceTest();

            System.out.println("------------------------------------------------------------------");

            // 使用 FileSystemResource 访问文件系统资源
            fileSystemResourceTest();

            System.out.println("------------------------------------------------------------------");

            // 使用 ByteArrayResource 读取字节数组资源
            byteArrayResourceTest();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------------------------------------");

        //通过 ApplicationContext 访问资源
//        Resource resource = context.getResource("module.png");
        //强制指定使用 URLResource访问资源
        Resource resource = context.getResource("file:/Users/dongdong/OneDrive/idea.png");
        // 获取资源的简单信息
        System.out.println("文件名称："+resource.getFilename());
        System.out.println("文件描述："+resource.getDescription());
        System.out.println("文件是否存在："+resource.exists());

        System.out.println("------------------------------------------------------------------");
        TestBean testBean = context.getBean("test", TestBean.class);
        System.out.println("resourceloader 是否和 Application context 相等： "+ (testBean.getResourceLoader() == context));
        // 当 Bean 实例需要访问Resource时，可以直接使用依赖注入
        testBean.parse();

        System.out.println("------------------------------------------------------------------");

        System.out.println("Chinese : "+ context.getBean("chinese", Chinese.class).sayHello("张三"));
//        context.getBean("chinese", Chinese.class).divide();

        //
        context.getBean("chinese", Chinese.class).eat("西瓜", new Date());
    }

    // 使用 UrlResource 访问网络资源文件
    public static void urlResourceTest() throws IOException {
        // 使用 UrlResource 访问本地资源文件
        UrlResource resource = new UrlResource("file:/Users/dongdong/OneDrive/idea.png");

        // 获取资源的简单信息
        System.out.println("文件名称："+resource.getFilename());
        System.out.println("文件描述："+resource.getDescription());
        System.out.println("文件最后修改时间："+resource.lastModified());
        System.out.println("文件大小："+resource.contentLength());
        System.out.println("文件是否存在："+resource.exists());
        System.out.println("文件是否打开："+resource.isOpen());
    }

    // 使用 ClassPathResource 访问类加载路径下的资源
    public static void classPathResourceTest() throws IOException {

        // 创建一个Resource对象，从类加载路径里读取资源
        ClassPathResource resource = new ClassPathResource("module.png");

        // 获取资源的简单信息
        System.out.println("文件名称："+resource.getFilename());
        System.out.println("文件描述："+resource.getDescription());
        System.out.println("文件是否存在："+resource.exists());
    }

    // 使用 FileSystemResource 访问文件系统资源
    public static void fileSystemResourceTest() throws IOException {

        // 创建一个Resource对象，默认从文件系统的当前路径读取文件资源
        FileSystemResource resource = new FileSystemResource("/Users/dongdong/OneDrive/idea.png");

        // 获取资源的简单信息
        System.out.println("文件名称："+resource.getFilename());
        System.out.println("文件描述："+resource.getDescription());
        System.out.println("文件是否存在："+resource.exists());
    }

    // 使用 ByteArrayResource 读取字节数组资源
    private static void byteArrayResourceTest(){
        String file = "可以看到这个时候关羽又重拾了青龙偃月刀。可以看到，当halberd bean的autowire-candidate属性设为false时，" +
                "他将不会作为自动装配的竞选bean之一，这个时候虽然halberd的primary属性为true，但是halberd bean没有参与自动装配的竞选，" +
                "所以自动装配到了falchion。\n" + "\n" +
                "这种感觉就好像：“隔壁村李小花觊觎我已久，但我是一个要成为海贼王的男人，于是拒绝了她……最终她嫁给了隔壁老王，过上了幸福的生活”。";
        byte[] fileBytes = file.getBytes();

        ByteArrayResource resource = new ByteArrayResource(fileBytes);

        // 获取资源的简单信息
        System.out.println("文件名称："+resource.contentLength());
        System.out.println("文件描述："+resource.getDescription());
        System.out.println("文件是否打开："+resource.isOpen());
    }
}
