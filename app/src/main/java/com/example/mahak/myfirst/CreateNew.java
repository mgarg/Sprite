package com.example.mahak.myfirst;

import android.annotation.TargetApi;
import android.app.Activity;
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

        //        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
//        linearLayout.setDrawingCacheEnabled(true);
//        linearLayout.buildDrawingCache();
//        Bitmap b = Bitmap.createBitmap(linearLayout.getDrawingCache());
//        saveImage(b);

    }
    private void saveImage(Bitmap b){
        File myDir = Environment.getExternalStorageDirectory();
        myDir.mkdirs();
    }
}

