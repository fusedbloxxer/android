package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoHandlerClass implements Camera.PictureCallback {
    private Context mContext;

    PhotoHandlerClass(Context context) {
        mContext = context;
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        File pictureFileDir = getDir();

        if (!pictureFileDir.exists() || !pictureFileDir.mkdirs()) {
            Log.e("MKDIR ERROR: ", "An error occurred while creating the file directory !");
            Toast.makeText(mContext, "Can't create directory to save image.", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        String timeStamp = new SimpleDateFormat("dd_MM_YYYYY").format(new Date());
        String photoFile = "JPEG_" + timeStamp + ".jpg";

        String fileName = pictureFileDir.getPath() + File.separator + photoFile;

        File pictureFile = new File(fileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pictureFile);
            fileOutputStream.write(data);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getDir() {
        File sdDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(sdDir, "CameraAPIDemo");
    }
}
