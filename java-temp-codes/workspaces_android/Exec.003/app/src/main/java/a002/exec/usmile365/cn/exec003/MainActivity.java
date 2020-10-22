package a002.exec.usmile365.cn.exec003;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import a002.exec.usmile365.cn.exec003.constraits.PhotoActionType;


public class MainActivity extends AppCompatActivity {

    private Button pic_btn;
    private ImageView pic_view;

    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);//打开某个手机资源
//            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//打开相册
            intent.setType("image/*");
            startActivityForResult(intent, PhotoActionType.Gallery.value());
        }
    };

    private void initView() {
        this.pic_view = (ImageView)this.findViewById(R.id.pic_view);
        this.pic_btn = (Button) this.findViewById(R.id.pic_btn);
        this.pic_btn.setOnClickListener(listener);
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
                pic_view.setImageURI(uri);
//                Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());
//                pic_view.setImageBitmap(bitmap);
//                ContentResolver cr = this.getContentResolver();
//                try {
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, uri);
//                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//                } catch (IOException e) {
//                    Log.e("Exception", e.getMessage(), e);
//                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
