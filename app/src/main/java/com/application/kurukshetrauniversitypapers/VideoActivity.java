package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.media.MediaExtractor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;


public class VideoActivity extends AppCompatActivity {
    private YouTubePlayerView youTubePlayerView;
    private FullScreenHelper fullScreenHelper = new FullScreenHelper(this);
    float currentSeconds;
    private YouTubePlayer youTubePlayer;

    // a list of videos not available in some countries, to test if they're handled gracefully.
    // private String[] nonPlayableVideoIds = { "sop2V_MREEI" };


    String videoid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent1=getIntent();
        videoid=intent1.getStringExtra("videoId");
        youTubePlayerView = findViewById(R.id.youtube_player_view);


        initYouTubePlayerView();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfiguration) {
        super.onConfigurationChanged(newConfiguration);
        youTubePlayerView.getPlayerUiController().getMenu().dismiss();
    }

    @Override
    public void onBackPressed() {
        if (youTubePlayerView.isFullScreen())
            youTubePlayerView.exitFullScreen();
        else
            super.onBackPressed();
    }
    private void initYouTubePlayerView() {
        //initPlayerMenu();

        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer player) {
                youTubePlayer=player;
                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer,
                        getLifecycle(),
                        videoid,
                        0f
                );
//                youTubePlayer.addListener(new YouTubePlayerListener() {
//                    @Override
//                    public void onReady(@NotNull YouTubePlayer youTubePlayer) {
//
//                    }
//
//                    @Override
//                    public void onStateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerState playerState) {
//
//                    }
//
//                    @Override
//                    public void onPlaybackQualityChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlaybackQuality playbackQuality) {
//
//                    }
//
//                    @Override
//                    public void onPlaybackRateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlaybackRate playbackRate) {
//
//                    }
//
//                    @Override
//                    public void onError(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerError playerError) {
//
//                    }
//
//                    @Override
//                    public void onCurrentSecond(@NotNull YouTubePlayer youTubePlayer, float v ) {
//                        currentSeconds=v;
//                    }
//
//                    @Override
//                    public void onVideoDuration(@NotNull YouTubePlayer youTubePlayer, float v) {
//
//
//                    }
//
//                    @Override
//                    public void onVideoLoadedFraction(@NotNull YouTubePlayer youTubePlayer, float v) {
//
//                    }
//
//                    @Override
//                    public void onVideoId(@NotNull YouTubePlayer youTubePlayer, @NotNull String s) {
//
//                    }
//
//                    @Override
//                    public void onApiChange(@NotNull YouTubePlayer youTubePlayer) {
//
//                    }
//                })
                addFullScreenListenerToPlayer();
                //setPlayNextVideoButtonClickListener(youTubePlayer);
            }
            @Override
            public void onApiChange(@NotNull YouTubePlayer youTubePlayer) {
                super.onApiChange(youTubePlayer);
            }

            @Override
            public void onCurrentSecond(@NotNull YouTubePlayer youTubePlayer, float second) {
                currentSeconds = second;
            }

            @Override
            public void onError(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerError error) {
                super.onError(youTubePlayer, error);
            }

            @Override
            public void onPlaybackQualityChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlaybackQuality playbackQuality) {
                super.onPlaybackQualityChange(youTubePlayer, playbackQuality);
            }

            @Override
            public void onPlaybackRateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlaybackRate playbackRate) {
                super.onPlaybackRateChange(youTubePlayer, playbackRate);
            }

            @Override
            public void onStateChange(@NotNull YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerState state) {
                super.onStateChange(youTubePlayer, state);
            }

            @Override
            public void onVideoDuration(@NotNull YouTubePlayer youTubePlayer, float duration) {
                super.onVideoDuration(youTubePlayer, duration);
            }

            @Override
            public void onVideoId(@NotNull YouTubePlayer youTubePlayer, @NotNull String videoId) {
                super.onVideoId(youTubePlayer, videoId);
            }

            @Override
            public void onVideoLoadedFraction(@NotNull YouTubePlayer youTubePlayer, float loadedFraction) {
                super.onVideoLoadedFraction(youTubePlayer, loadedFraction);
            }


        });
    }

//    private void initPlayerMenu() {
//        youTubePlayerView.getPlayerUiController()
//                .showMenuButton(true)
//                .getMenu()
//                .addItem(new MenuItem("menu item1", R.drawable.ic_android_black_24dp,
//                        view -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show())
//                ).addItem(new MenuItem("menu item2", R.drawable.ic_mood_black_24dp,
//                view -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show())
//        ).addItem(new MenuItem("menu item no icon",
//                view -> Toast.makeText(this, "item no icon clicked", Toast.LENGTH_SHORT).show()));
//    }

    private void addFullScreenListenerToPlayer() {
        youTubePlayerView.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            @Override
            public void onYouTubePlayerEnterFullScreen() {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                fullScreenHelper.enterFullScreen();

                addCustomActionsToPlayer();
            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                fullScreenHelper.exitFullScreen();

                removeCustomActionsFromPlayer();
            }
        });
    }

    /**
     * This method adds a new custom action to the player.
     * Custom actions are shown next to the Play/Pause button in the middle of the player.
     */
    private void addCustomActionsToPlayer() {
        Drawable customAction1Icon = ContextCompat.getDrawable(this, R.drawable.ic_fast_rewind_white_24dp);
        Drawable customAction2Icon = ContextCompat.getDrawable(this, R.drawable.ic_fast_forward_white_24dp);
        assert customAction1Icon != null;
        assert customAction2Icon != null;



        youTubePlayerView.getPlayerUiController().setCustomAction1(customAction1Icon, view ->
                youTubePlayer.seekTo(currentSeconds-10));


        youTubePlayerView.getPlayerUiController().setCustomAction2(customAction2Icon, view ->
               youTubePlayer.seekTo(currentSeconds+10)

                );
    }

    private void removeCustomActionsFromPlayer() {
        youTubePlayerView.getPlayerUiController().showCustomAction1(false);
        youTubePlayerView.getPlayerUiController().showCustomAction2(false);
    }

    /**
     * Set a click listener on the "Play next video" button
     */
//    private void setPlayNextVideoButtonClickListener(final YouTubePlayer youTubePlayer) {
//        Button playNextVideoButton = findViewById(R.id.next_video_button);
//
//        playNextVideoButton.setOnClickListener(view ->
//                YouTubePlayerUtils.loadOrCueVideo(
//                        youTubePlayer, getLifecycle(),
//                        VideoIdsProvider.getNextVideoId(),0f
//                ));
//    }

    /**
     * This method is here just for reference, it is not being used because the IFrame player already shows the title of the video.
     *
     * This method is called every time a new video is being loaded/cued.
     * It uses the YouTube Data APIs to fetch the video title from the video ID.
     * The YouTube Data APIs are nothing more then a wrapper over the YouTube REST API.
     * You can learn more at the following urls:
     * https://developers.google.com/youtube/v3/docs/videos/list
     * https://developers.google.com/apis-explorer/#p/youtube/v3/youtube.videos.list?part=snippet&id=6JYIGclVQdw&fields=items(snippet(title))&_h=9&
     *
     * This method does network operations, therefore it cannot be executed on the main thread.
     * For simplicity I have used RxJava to implement the asynchronous logic. You can use whatever you want: Threads, AsyncTask ecc.
     */
//    @SuppressLint("CheckResult")
//    private void setVideoTitle(PlayerUiController playerUiController, String videoId) {
//
//        Single<VideoInfo> observable = YouTubeDataEndpoint.getVideoInfoFromYouTubeDataAPIs(videoId);
//
//        observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        videoInfo -> playerUiController.setVideoTitle(videoInfo.getVideoTitle()),
//                        error -> { Log.e(getClass().getSimpleName(), "Can't retrieve video title, are you connected to the internet?"); }
//                );
//    }

}