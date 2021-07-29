package com.example.opencv4android;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;

import org.opencv.android.JavaCameraView;

import java.io.FileOutputStream;

public class MainActivityView extends JavaCameraView implements Camera.PictureCallback {

    private static final String TAG = "Sample::Tutorial3View";
    private String mPictureFileName;
    private Camera mCamera;

    public MainActivityView(Context context, int cameraId) {
        super(context, cameraId);
    }

    public void takePicture(final String fileName) {
        Log.i(TAG, "Taking picture");
        this.mPictureFileName = fileName;
        // Postview and jpeg are sent in the same buffers if the queue is not empty when performing a capture.
        // Clear up buffers to avoid mCamera.takePicture to be stuck because of a memory issue
        mCamera.setPreviewCallback(null);

        // PictureCallback is implemented by the current class
        mCamera.takePicture(null, null, this);
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Log.i(TAG, "Saving a bitmap to file");
        // The camera preview was automatically stopped. Start it again.
        mCamera.startPreview();
        mCamera.setPreviewCallback((Camera.PreviewCallback) this);

        // Write the image in a file (in jpeg format)
        try {
            FileOutputStream fos = new FileOutputStream(mPictureFileName);

            fos.write(data);
            fos.close();

        } catch (java.io.IOException e) {
            Log.e("PictureDemo", "Exception in photoCallback", e);
        }
    }
}
