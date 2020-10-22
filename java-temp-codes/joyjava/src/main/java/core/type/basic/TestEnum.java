package core.type.basic;

public class TestEnum {


    public static void main(String[] args) {
//        System.out.println(EnumType.valueOf(null));
        // will throw a NullPointerException with error message: Name is null;
//        System.out.println(EnumType.valueOf("x"));
        // will throw an IllegalArgumentException with message: No enum constant core.type.basic.EnumType.x

        System.out.println(EnumType.valueOf("T1"));

        System.out.println(EnumType.valueOf("T2"));

        EnumType nullType = null;
        System.out.println(nullType);

        EnumType.doStaticSth();
        EnumType.T1.doStaticSth();
        EnumType.T2.doStaticSth();
        EnumType.T1.doSth();
        EnumType.T2.doSth();

        EnumType t1 = EnumType.valueOf("T1");
        System.out.println(t1==EnumType.T1);
        System.out.println(t1!=EnumType.T1);
        System.out.println(EnumType.T1.equals(t1));
        System.out.println("-------valueOf");
        System.out.println(EnumType.valueOf("T1"));
        System.out.println(EnumType.valueOf("T2"));
        System.out.println(EnumType.valueOf("XXXXXXXX"));
    }

}
