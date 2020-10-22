package core.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class T2 {

    public static void testListCollectToMap() {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean("A", 6));
        list.add(new Bean("C", 5));
        list.add(new Bean("D", 3));
        list.add(new Bean("B", 8));
        Map<String, Integer> beanMap = list.stream().collect(Collectors.toMap(b ->b.getName(), b -> b.getLength()));
        System.out.println(list);
        System.out.println(beanMap);

    }

    public static void testMinMax() {
        List<Bean> list = new ArrayList<>();
        list.add(new Bean("A", 6));
        list.add(new Bean("C", 5));
        list.add(new Bean("D", 3));
        list.add(new Bean("B", 8));
        System.out.println(list);
        Bean minBean = list.stream().min(Comparator.comparing(bean -> bean.getLength())).get();
        System.out.println(minBean);

        list.clear();
        System.out.println(list);
        Optional<Bean> minOption = list.stream().min(Comparator.comparing(bean -> bean.getLength()));
        System.out.println(minOption.isPresent());
        System.out.println(minOption.isPresent()?minOption.get():"Default");

    }

    public static class Bean {
        private String name;
        private int length;
        public Bean(String name, int length) {
            this.name = name;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "name='" + name + '\'' +
                    ", length=" + length +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

}
