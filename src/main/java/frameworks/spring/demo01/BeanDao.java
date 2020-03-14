package frameworks.spring.demo01;

import org.springframework.stereotype.Component;

@Component("userDao")
public class BeanDao {

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": @" + this.hashCode();
    }
}
