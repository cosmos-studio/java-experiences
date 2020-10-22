package a002.exec.usmile365.cn.exec003;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

import a002.exec.usmile365.cn.exec003.conponents.PicGalleryBtn;
import a002.exec.usmile365.cn.exec003.constraits.PhotoActionType;


public class MainActivity extends AppCompatActivity {

    private ImageView pic_view;

    private void initView() {
        this.pic_view = (ImageView)this.findViewById(R.id.pic_view);
        new PicGalleryBtn(this.getApplicationContext(), this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PhotoActionType.Gallery.value()) {
            if(data!=null) {
                Uri uri = data.getData();
                ContentResolver cr = this.getContentResolver();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, uri);
//                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    pic_view.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Log.e("Exception", e.getMessage(), e);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
