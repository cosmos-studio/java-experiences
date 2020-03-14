package skills.proxy.m3;

public class App {

    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();

        proxy.save();
    }
}
