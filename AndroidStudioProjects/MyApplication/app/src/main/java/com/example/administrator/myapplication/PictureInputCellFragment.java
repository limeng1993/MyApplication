package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/5.
 */

public class PictureInputCellFragment  extends Fragment {
    ImageView imageView;
    TextView labelText;
    TextView hintText;
    final  int REQUESTCODE_CAMERA=1;
    final int REQUESTCODE_ALBUM=2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_inputcell_picture,container);
        imageView=(ImageView) view.findViewById(R.id.image);
        labelText=(TextView)view.findViewById(R.id.label);
        hintText=(TextView)view.findViewById(R.id.hint);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choicePicture();
            }
        });
        return view;


    }
      void choicePicture() {
        String[] items =
                {
                        "拍照", "相册"
                };

        new AlertDialog.Builder(getActivity())
                .setTitle(labelText.getText())
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                takePhoto();
                                break;
                            case 1:
                                pickFromAlbm();
                                break;
                            default:
                                break;
                        }

                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }
        void takePhoto()
    {
        //调用系统拍照功能
        Intent itnt=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(itnt,REQUESTCODE_CAMERA);//有反馈的意图机制


    }
    void pickFromAlbm()
    {
        Intent itnt=new Intent(Intent.ACTION_GET_CONTENT);
        itnt.setType("image/*");
        startActivityForResult(itnt,REQUESTCODE_ALBUM);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_CANCELED) return;
        //用户拍照后的结果
        if (requestCode==REQUESTCODE_CAMERA)
        {
            Bitmap bmp=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bmp);
            //Log.d("camara data",dataObj.getClass().toString());

        }else if (requestCode==REQUESTCODE_ALBUM)
        {
           // Bitmap bmp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            Bitmap bmp= null;
            try {
                bmp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }

            imageView.setImageBitmap(bmp);

        }
            //Log.d("camera capture",data.getExtras().keySet().toString());



}
    public void setLabelText(String labelText)
    {

        this.labelText.setText(labelText);
    }

    public void setHintText(String hintText)
    {
        this.hintText.setHint(hintText);
    }

}
