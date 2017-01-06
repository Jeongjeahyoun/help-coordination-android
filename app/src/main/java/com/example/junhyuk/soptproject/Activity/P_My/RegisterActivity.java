package com.example.junhyuk.soptproject.Activity.P_My;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.junhyuk.soptproject.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RegisterActivity extends AppCompatActivity {
    private static final int PICK_FROM_GALLERY = 1;
    ImageView imgview;
    Button saveBtn;
    EditText inputNameEdit;
    EditText inputMemoEdit;
    Spinner inputCategorySpin;
    final Context context = this;

    final int REQ_CODE_SELECT_IMAGE=100;
    String imgUrl = "";
    Uri data;
    // NetworkService service;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imgview = (ImageView) findViewById(R.id.imageView1);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        inputNameEdit = (EditText) findViewById(R.id.inputNameEdit);
        inputMemoEdit = (EditText) findViewById(R.id.inputMenoEdit);
        inputCategorySpin = (Spinner) findViewById(R.id.inputCategorySpin);

        Spinner spiiner2 = (Spinner) findViewById(R.id.inputCategorySpin);


        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.category,
                android.R.layout.simple_spinner_item);

        spiiner2.setAdapter(adapter2);

        mProgressDialog = new ProgressDialog(RegisterActivity.this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("등록 중...");
        mProgressDialog.setIndeterminate(true);

        //service = ApplicationController.getInstance().getNetworkService();

        imgview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
                // Gallery 호출
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // 잘라내기 셋팅
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);

                try {
                    intent.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(intent,
                            "Complete action using"), PICK_FROM_GALLERY);
                } catch (ActivityNotFoundException e) {

                }
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                alertDialogBuilder
                        .setMessage("옷을 추가하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(inputNameEdit.length() == 0 ) {
                                            Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            mProgressDialog.show();

                                            RequestBody name = RequestBody.create(MediaType.parse("multipart/form-data"), inputNameEdit.getText().toString());

                                            MultipartBody.Part body;

                                            if(imgUrl=="") {
                                                body = null;
                                            }

                                            else{
                                                BitmapFactory.Options options = new BitmapFactory.Options();

                                                InputStream in = null;

                                                try{
                                                    in = getContentResolver().openInputStream(data);
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                }

                                                Bitmap bitmap = BitmapFactory.decodeStream(in, null, options);
                                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);

                                                RequestBody photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray());

                                                File photo = new File(imgUrl);

                                                body = MultipartBody.Part.createFormData("image", photo.getName(), photoBody);
                                            }
                                        }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();

            }
        });
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        if (requestCode == PICK_FROM_GALLERY) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                imgview.setImageBitmap(photo);
            }
        }
    }




}
