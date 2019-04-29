package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class CameraActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private String currentPhotoPath;
    private Bitmap mBitmapPhoto;
    private ImageView mImageViewPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        initView();
    }

    private void initView() {
        mImageViewPhoto = findViewById(R.id.image_view_photo);
    }

    public void dispatchTakePictureIntent(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE) {

            File photoFile = null;

            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, "An error occurred while creating the file.", Toast.LENGTH_SHORT).show();
            }

            if (photoFile != null) {
                Bundle bundle = data.getExtras();
                mBitmapPhoto = (Bitmap) bundle.get("data");
                mImageViewPhoto.setImageBitmap(mBitmapPhoto);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Cand a fost facuta poza
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        // Denumirea pozei + timestamp
        String imageFileName = "JPEG_" + timeStamp + "_";
        // Locul/directorul unde sunt pozele private pentru aplicatie
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mBitmapPhoto != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            mBitmapPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            outState.putByteArray("bitmap_image", byteArray);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            byte[] byteArray = savedInstanceState.getByteArray("bitmap_image");
            mBitmapPhoto = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            mImageViewPhoto.setImageBitmap(mBitmapPhoto);
        }
    }

    public void fullImageOnClick(View view) {
        // TODO: activitate noua cu poza pe tot ecranul
    }
}
