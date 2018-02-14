package com.blackflag.screenrecorder;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.File;
import java.io.IOException;

public class VideoPreview extends AppCompatActivity {

    FullscreenVideoLayout videoLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_preview);
        videoLayout = (FullscreenVideoLayout) findViewById(R.id.videoview);
        videoLayout.setActivity(this);

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        Toast.makeText(this, MainActivity.currentfilename, Toast.LENGTH_SHORT).show();
        Log.e("Video",MainActivity.currentfilename+".mp4");
        File file = new File(path, MainActivity.currentfilename+".mp4");
       // Uri videoUri = Uri.parse("http://www.quirksmode.org/html5/videos/big_buck_bunny.mp4");
        try {

            videoLayout.setVideoURI(Uri.fromFile(file));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
