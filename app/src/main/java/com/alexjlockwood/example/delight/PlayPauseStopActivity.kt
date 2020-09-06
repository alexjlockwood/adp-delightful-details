package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class PlayPauseStopActivity : AppCompatActivity() {
    @BindView(R.id.icon)
    var iconView: ImageView? = null

    @BindView(R.id.play)
    var playButton: View? = null

    @BindView(R.id.pause)
    var pauseButton: View? = null

    @BindView(R.id.stop)
    var stopButton: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playpausestop)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.play)
    fun setPlay() {
        playButton!!.isEnabled = false
        pauseButton!!.isEnabled = true
        stopButton!!.isEnabled = true
        iconView!!.setImageState(STATE_SET_PLAY, true)
    }

    @OnClick(R.id.pause)
    fun setPause() {
        playButton!!.isEnabled = true
        pauseButton!!.isEnabled = false
        stopButton!!.isEnabled = true
        iconView!!.setImageState(STATE_SET_PAUSE, true)
    }

    @OnClick(R.id.stop)
    fun setStop() {
        playButton!!.isEnabled = true
        pauseButton!!.isEnabled = true
        stopButton!!.isEnabled = false
        iconView!!.setImageState(STATE_SET_STOP, true)
    }

    companion object {
        private val STATE_SET_PLAY = intArrayOf(R.attr.state_play, -R.attr.state_pause, -R.attr.state_stop)
        private val STATE_SET_PAUSE = intArrayOf(-R.attr.state_play, R.attr.state_pause, -R.attr.state_stop)
        private val STATE_SET_STOP = intArrayOf(-R.attr.state_play, -R.attr.state_pause, R.attr.state_stop)
    }
}