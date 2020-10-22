import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    static class Bean {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Bean2 {
        private String name;
        public Bean2() {
        }

        public Bean2(Bean bean) {
            this.name = "[" + bean.getName() + "]";
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Bean2{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Bean> list = new ArrayList<>();
        List<Bean2> list2 = list.stream().map( b -> new Bean2(b)).collect(Collectors.toList());
        System.out.println(list2);
    }
}
