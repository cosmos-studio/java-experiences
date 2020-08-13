package skills.proxy.m1;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("transaction start");
        target.save();
        System.out.println("transaction stop");
    }
}
