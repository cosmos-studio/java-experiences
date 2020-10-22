package a002.exec.usmile365.cn.exec003.conponents;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import a002.exec.usmile365.cn.exec003.constraits.PhotoActionType;


/**
 * Created by Administrator on 2018-02-04.
 */

@SuppressLint("AppCompatCustomView")
public class PicGalleryBtn extends Button implements View.OnClickListener {
    private Activity activity;
    public PicGalleryBtn(Context context, Activity activity) {
        super(context);
        this.setOnClickListener(this);
        this.activity = activity;
    }

    public PicGalleryBtn(Context context, AttributeSet attrs, Activity activity) {
        super(context, attrs);
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);//打开某个手机资源
        Intent intent = new Intent(Intent.ACTION_PICK);//打开相册
        intent.setType("image/*");
        this.activity.startActivityForResult(intent, PhotoActionType.Gallery.value());
    }

}
