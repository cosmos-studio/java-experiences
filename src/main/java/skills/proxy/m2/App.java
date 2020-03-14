package skills.proxy.m2;

public class App {
    public static void main(String[] args) {
        IUserDao target =  new UserDao();
        System.out.println("original type->\t"+target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("proxy type   ->\t"+proxy.getClass());

        proxy.save();
    }
}
