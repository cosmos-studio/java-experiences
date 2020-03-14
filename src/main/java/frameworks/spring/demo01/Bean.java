package frameworks.spring.demo01;

import org.springframework.stereotype.Component;

@Component
public class Bean {
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": @" + this.hashCode();
    }
}
