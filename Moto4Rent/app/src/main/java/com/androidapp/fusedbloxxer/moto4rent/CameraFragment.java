package com.androidapp.fusedbloxxer.moto4rent;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
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
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String SAVE_BITMAP = "bitmap_save";
    public static final int MY_PERMISSIONS_REQUEST_EXTERNAL = 2;
    private String imagePath;
    private Bitmap mBitmapPhoto;
    private ImageView mImageViewPhoto;
    private Button mButton;

    public CameraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_camera, container, false);
        initView(itemView);
        requestPermissions();
        return itemView;
    }

    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_EXTERNAL);
        } else{
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
                Toast.makeText(getActivity(), "You denied camera access.", Toast.LENGTH_LONG)
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
        BitmapFactory.decodeFile(imagePath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image :)
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        mBitmapPhoto = BitmapFactory.decodeFile(imagePath, bmOptions);
        mImageViewPhoto.setImageBitmap(mBitmapPhoto);
    }

    private void setBehaviour() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (openCamera.resolveActivity(getActivity().getPackageManager()) != null) {
                    File photoFile = null;
                    try {
                        photoFile = createTempFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (photoFile != null) {
                        Uri photoUri = FileProvider.getUriForFile(getActivity(),
                                "com.androidapp.fusedbloxxer.moto4rent",
                                photoFile);

                        openCamera.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(openCamera, REQUEST_IMAGE_CAPTURE);
                    }
                }
            }
        });
    }

    private void initView(View itemView) {
        mImageViewPhoto = itemView.findViewById(R.id.image_view_photo);
        mButton = itemView.findViewById(R.id.button_take_photo);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE: {
                if (resultCode == getActivity().RESULT_OK) {
                    setPic();
                }
            }
            break;
        }
    }

    private File createTempFile() throws IOException {
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy").format(new Date());
        String fileName = "JPEG_" + timeStamp + "_";
        File fileDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = File.createTempFile(
                fileName,
                ".jpeg",
                fileDir
        );

        imagePath = imageFile.getAbsolutePath();
        return imageFile;
    }
}
