package com.example.mahak.myfirst;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNew extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        ImageView[] imageViews = new ImageView[4];
        Bundle extras = getIntent().getExtras();
        ArrayList<String> path = extras.getStringArrayList("imgs");
        imageViews[0] = (ImageView) findViewById(R.id.imageView11);
        imageViews[1] = (ImageView) findViewById(R.id.imageView12);
        imageViews[2] = (ImageView) findViewById(R.id.imageView13);
        imageViews[3] = (ImageView) findViewById(R.id.imageView14);

        imageViews[0].setImageBitmap(BitmapFactory.decodeFile(path.get(0)));
        imageViews[1].setImageBitmap(BitmapFactory.decodeFile(path.get(1)));
        imageViews[2].setImageBitmap(BitmapFactory.decodeFile(path.get(2)));
        imageViews[3].setImageBitmap(BitmapFactory.decodeFile(path.get(3)));

//        saveImage(b);

    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
    public void share(View v){

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.setDrawingCacheEnabled(true);
        linearLayout.buildDrawingCache();
        Bitmap b = Bitmap.createBitmap(linearLayout.getDrawingCache());

        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("image/*");
        share.putExtra(Intent.EXTRA_STREAM, getImageUri(CreateNew.this,b)); // Add image path
        startActivity(Intent.createChooser(share, "Share image using"));
    }
//    private void saveImage(Bitmap b){
//        File myDir = Environment.getExternalStorageDirectory();
//        myDir.mkdirs();
//    }
}

