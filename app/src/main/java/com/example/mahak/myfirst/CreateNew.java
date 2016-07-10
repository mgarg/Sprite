package com.example.mahak.myfirst;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateNew extends AppCompatActivity {
private static final int REQUEST_CODE = 1;
    ImageView imageView;
    private Bitmap bitmap;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private Uri fileUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        imageView = (ImageView) findViewById(R.id.imageView11);
    }


    public void camera(MenuItem item){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uriSavedImage=Uri.fromFile(new File("/sdcard/flashCropped.png"));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        startActivityForResult(intent, 0);
    }
    public void gallery(MenuItem item){
        FishBun.with(CreateNew.this).startAlbum();
    }
    public void collections(MenuItem item){
        Toast.makeText(this,"collections",Toast.LENGTH_SHORT).show();
    }

    public void catalog(View view){
        PopupMenu popupMenu = new PopupMenu(CreateNew.this,findViewById(R.id.catalog));
        popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
        popupMenu.show();
    }

protected void onActivityResult(int requestCode, int resultCode,
                                Intent imageData) {
    super.onActivityResult(requestCode, resultCode, imageData);
    switch (requestCode) {
        case Define.ALBUM_REQUEST_CODE:
            if (resultCode == RESULT_OK) {
                ArrayList<String> path = imageData.getStringArrayListExtra(Define.INTENT_PATH);
                ImageView[] imageViews = new ImageView[4];

                imageViews[0] = (ImageView) findViewById(R.id.imageView11);
                imageViews[1] = (ImageView) findViewById(R.id.imageView12);
                imageViews[2] = (ImageView) findViewById(R.id.imageView13);
                imageViews[3] = (ImageView) findViewById(R.id.imageView14);

                imageViews[0].setImageBitmap(BitmapFactory.decodeFile(path.get(0)));
                imageViews[1].setImageBitmap(BitmapFactory.decodeFile(path.get(1)));
                imageViews[2].setImageBitmap(BitmapFactory.decodeFile(path.get(2)));
//                imageViews[3].setImageBitmap(BitmapFactory.decodeFile(path.get(3)));

                break;
            }
    }
}
    }

