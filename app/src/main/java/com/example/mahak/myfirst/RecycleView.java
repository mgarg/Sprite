package com.example.mahak.myfirst;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecycleView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        int[] imgs = {R.drawable.ofline,R.drawable.online,R.drawable.sprightly};
        MyItem[] myDataSet = {new MyItem("Catalog",10,imgs),
                            new MyItem("Pricelist",12,imgs),
                            new MyItem("Ecard",1,imgs),
                            new MyItem("Flyer",4,imgs)};

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(myDataSet,RecycleView.this);
        recyclerView.setAdapter(adapter);
    }

    public void camera(MenuItem item){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uriSavedImage=Uri.fromFile(new File("/sdcard/flashCropped.png"));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        startActivityForResult(intent, 0);
    }
    public void gallery(MenuItem item){
        FishBun.with(RecycleView.this).startAlbum();
    }
    public void collections(MenuItem item){
        Toast.makeText(this,"collections",Toast.LENGTH_SHORT).show();
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent imageData) {
        super.onActivityResult(requestCode, resultCode, imageData);
        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    ArrayList<String> path = imageData.getStringArrayListExtra(Define.INTENT_PATH);
                    Intent intent = new Intent(RecycleView.this,CreateNew.class);
                    intent.putExtra("imgs",path);
                    startActivity(intent);


                    break;
                }
        }

    }
    private void saveImage(Bitmap b){
        File myDir = Environment.getExternalStorageDirectory();
        myDir.mkdirs();
    }
}
