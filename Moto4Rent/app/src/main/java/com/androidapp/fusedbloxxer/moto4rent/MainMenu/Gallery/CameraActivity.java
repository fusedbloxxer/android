package com.androidapp.fusedbloxxer.moto4rent.MainMenu.Gallery;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidapp.fusedbloxxer.moto4rent.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraActivity extends AppCompatActivity {
    public static final int MY_PERMISSIONS_REQUEST_EXTERNAL = 2;
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String SAVE_BITMAP = "bitmap_save";
    private ImageView mImageViewPhoto;
    private Bitmap mBitmapPhoto;
    private String mImagePath, mImageTitle;
    private Button mButton;
    private EditText mEditText;
    private Button mButtonAccept;
    private Button mButtonDiscard;
    private ConstraintSet mConstraintSetAlt;
    private ConstraintLayout mConstraintLayout;
    private ConstraintSet mConstraintSetDefault;

    public CameraActivity() {
        // Required empty public constructor
    }

    private void initView() {
        mImageViewPhoto = findViewById(R.id.image_view_photo);
        mButton = findViewById(R.id.button_take_photo);
        mEditText = findViewById(R.id.edit_text_title);
        mButtonAccept = findViewById(R.id.button_accept);
        mButtonDiscard = findViewById(R.id.button_discard);
        mConstraintLayout = findViewById(R.id.camera_constraint_layout);
        (mConstraintSetDefault = new ConstraintSet()).clone(mConstraintLayout);
        (mConstraintSetAlt = new ConstraintSet()).clone(this, R.layout.activity_camera_alt);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initView();
        requestPermissions();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mBitmapPhoto != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            mBitmapPhoto.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bytes = stream.toByteArray();
            outState.putByteArray(SAVE_BITMAP, bytes);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            byte[] bytes = savedInstanceState.getByteArray(SAVE_BITMAP);
            if (bytes != null) {
                mBitmapPhoto = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mImageViewPhoto.setImageBitmap(mBitmapPhoto);
                showEditImage();
            }
        }
    }

    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_EXTERNAL);
        } else {
            setBehaviour();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_EXTERNAL) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                setBehaviour();
            } else {
                Toast.makeText(this, "You denied camera access.", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

    private void setPic() {
        // Get the dimensions of the view
        int targetW = mImageViewPhoto.getWidth();
        int targetH = mImageViewPhoto.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mImagePath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image :)
        if (targetW == 0) {
            targetW = 1;
        }
        if (targetH == 0) {
            targetH = 1;
        }
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        mBitmapPhoto = BitmapFactory.decodeFile(mImagePath, bmOptions);
        mImageViewPhoto.setImageBitmap(mBitmapPhoto);
        // TODO: send image to data base

        showEditImage();
    }

    private void showEditImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(mConstraintLayout);
            mConstraintSetAlt.applyTo(mConstraintLayout);
        }
    }

    private void hideEditImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(mConstraintLayout);
            mConstraintSetDefault.applyTo(mConstraintLayout);
        }
    }

    private void setBehaviour() {
        mImageTitle = "JPEG";
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (openCamera.resolveActivity(getPackageManager()) != null) {
                    File photoFile = null;
                    try {
                        photoFile = createTempFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (photoFile != null) {
                        Uri photoUri = FileProvider.getUriForFile(CameraActivity.this,
                                "com.androidapp.fusedbloxxer.moto4rent",
                                photoFile);

                        openCamera.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(openCamera, REQUEST_IMAGE_CAPTURE);
                    }
                }
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageTitle = mEditText
                        .getText()
                        .toString();
                // TODO: send info to database and update fragments ?
                finish();
                hideEditImage();
            }
        };
        mButtonAccept.setOnClickListener(onClickListener);
        mButtonDiscard.setOnClickListener(onClickListener);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE: {
                if (resultCode == RESULT_OK) {
                    setPic();
                }
            }
            break;
        }
    }

    private File createTempFile() throws IOException {
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy").format(new Date());
        String fileName = mImageTitle + "_" + timeStamp + "_";
        File fileDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = File.createTempFile(
                fileName,
                ".jpeg",
                fileDir
        );

        mImagePath = imageFile.getAbsolutePath();
        return imageFile;
    }
}
