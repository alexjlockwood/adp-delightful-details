package com.alexjlockwood.example.delight

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class ClockActivity : AppCompatActivity() {
    @BindView(R.id.alarm)
    var alarmView: ImageView? = null

    @BindView(R.id.clock)
    var clockView: ImageView? = null

    @BindView(R.id.timer)
    var timerView: ImageView? = null

    @BindView(R.id.stopwatch)
    var stopWatchView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        (alarmView!!.drawable as Animatable).start()
        (clockView!!.drawable as Animatable).start()
        (timerView!!.drawable as Animatable).start()
        (stopWatchView!!.drawable as Animatable).start()
    }
}