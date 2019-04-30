package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

public class MakePhotoActivity extends AppCompatActivity {
    private Camera camera;
    private int cameraId = 0;
    public static final String DEBUG_TAG = "MakePhotoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_photo);

        if (!getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Toast.makeText(this, "No camera on this device.", Toast.LENGTH_LONG)
                    .show();
        } else {
            cameraId = findFrontFacingCamera();
            if (cameraId < 0) {
                Toast.makeText(this, "No front facing camera found.",
                        Toast.LENGTH_LONG)
                        .show();
            } else {
                camera = Camera.open(cameraId);
            }
        }
    }

    public void onClick(View view) {
        camera.startPreview();
        camera.takePicture(null, null,
                new PhotoHandlerClass(getApplicationContext()));
    }

    private int findFrontFacingCamera() {
        int cameraId = -1;
        int numberOfCameras = Camera.getNumberOfCameras();

        for (int i = 0; i < numberOfCameras; i++) {
            CameraInfo info = new CameraInfo();
            Camera.getCameraInfo(i, info);
            if (CameraInfo.CAMERA_FACING_FRONT == info.facing) {
                cameraId = i;
                Log.d(DEBUG_TAG, "Camera found.");
                break;
            }
        }

        return cameraId;
    }

    @Override
    protected void onPause() {
        if (camera != null) {
            camera.release();
            camera = null;
        }
        super.onPause();
    }
}
