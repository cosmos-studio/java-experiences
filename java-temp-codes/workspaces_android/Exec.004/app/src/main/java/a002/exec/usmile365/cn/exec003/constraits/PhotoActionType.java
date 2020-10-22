package a002.exec.usmile365.cn.exec003.constraits;

/**
 * Created by Administrator on 2018-02-03.
 */
public enum PhotoActionType {
    Camara(1), Gallery(2), CUT(3);

    PhotoActionType(int value) {
        this.value = value;
    }

    private int value;

    public int value() {
        return value;
    }
}
