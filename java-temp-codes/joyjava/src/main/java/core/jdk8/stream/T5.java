package core.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class T5 {

    public static void main(String[] args) {
        T5 t5 = new T5();
        t5.test(-2);
        t5.test(2);
        t5.test(4);
        t5.test(5);
        t5.test(6);

    }

    public void test(int value) {
//        dto.getSessionMerchandises()
//                .stream()
//                .filter(s -> s.getSessionMerchandiseId().equals(sessionMerchandise.identity().getValue()))
//                .mapToLong(SessionMerchandiseSelectionDto::getProductId)
//                .forEach(productId -> {
//                    merchandiseProducts.add(sessionMerchandise.createVariantItemMarketTypeWithProduct(productId));
//                });


        System.out.println("---------->" + value);
        List<T5Bean> dataList = createList();
        dataList.stream()
                .filter(s -> s.getId() > value)
                .mapToLong(T5Bean::getIdLong)
//                .map(T5Bean::getIdLong)
//                .filter(s -> s!=null)
                .forEach(longId -> {
                    System.out.print(longId + ", ");
                });
        System.out.println();
//        List<Long> listLong = dataList.stream()
//                .filter(s -> s.getId() > value)
//                .mapToLong(T5Bean::getIdLong)//.getClass().getName()
//                .boxed().collect(Collectors.toList());
//        System.out.println(listLong);
    }

    private static List<T5Bean> createList() {
        List<T5Bean> list = new ArrayList<>();
        for(int i = 1; i<=5; i++) {
            list.add(new T5Bean(i, i+ 0L));
        }
//        list.add(null);
        list.add(new T5Bean(6, null));
        return list;
    }


    static class T5Bean {
        private int id;
        private Long idLong;

        public T5Bean(int id, Long idLong) {
            this.id = id;
            this.idLong = idLong;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            T5Bean t5Bean = (T5Bean) o;
            return id == t5Bean.id &&
                    Objects.equals(idLong, t5Bean.idLong);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, idLong);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Long getIdLong() {
            return idLong;
        }

        public void setIdLong(Long idLong) {
            this.idLong = idLong;
        }
    }
}
