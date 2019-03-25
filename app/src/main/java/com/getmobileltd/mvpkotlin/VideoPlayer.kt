package com.getmobileltd.mvpkotlin

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


/**
 * Created by themavencoder on 25,March,2019
 */

class VideoPlayer : AppCompatActivity() {

    lateinit var videoView: VideoView
    lateinit var videoUrl: String
    lateinit var controller: MediaController
    lateinit var vid_uri: Uri
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.layout_video_activity)
        init()
        videoView.setVideoURI(vid_uri)
        videoView.setMediaController(controller)
        videoView.start()

        progressBar.visibility = View.VISIBLE
        videoView.setOnPreparedListener { mp ->
            mp.start()
            mp.setOnVideoSizeChangedListener { mp, _, _ ->
                progressBar.visibility = View.GONE
                mp.start()
            }
        }

    }

    private fun init() {
        videoUrl = ""
        controller = MediaController(this)
        vid_uri = Uri.parse(videoUrl)
        progressBar = findViewById(R.id.progress_bar)
        videoView = findViewById(R.id.video_view)

    }
}