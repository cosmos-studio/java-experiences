package frameworks.spring.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConf.class);

        Bean bean1 = appCtx.getBean(Bean.class);
        Bean bean2 = appCtx.getBean(Bean.class);
        BeanDao userDao = appCtx.getBean(BeanDao.class);

        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(userDao);
    }
}
