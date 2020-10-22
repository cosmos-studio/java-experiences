package core.type.basic;

public enum EnumType {
    T1, T2;

    public void doSth() {
        System.out.println(this.name() + ": do something. -> " + this.ordinal());
    }

    public static void doStaticSth() {
        System.out.println(EnumType.class.getName() + ": do static tings.");
    }
}
