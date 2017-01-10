package com.albertliu.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener{

    private String googleApiKey = "AIzaSyBJar--euTVQmthTioqiouiskePAe8DSh8";
    private String youtubeVideoId = "0mbGUld2w-s";
    private String youTubePlaylist = "PL55713C70BA91BD6E";
    private Button btnPlayVideo, btnPlayPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button)findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button)findViewById(R.id.btnPlaylist);

        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, googleApiKey, youtubeVideoId);

                break;

            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, googleApiKey, youTubePlaylist);

                break;

            default:

        }
        if (intent != null){
            startActivity(intent);
        }
    }
}
