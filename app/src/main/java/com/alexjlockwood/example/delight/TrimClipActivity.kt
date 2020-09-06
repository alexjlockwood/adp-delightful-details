package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class TrimClipActivity : AppCompatActivity() {
    @BindView(R.id.airplane)
    var airplaneView: ImageView? = null

    @BindView(R.id.eye)
    var eyeView: ImageView? = null

    @BindView(R.id.flashlight)
    var flashlightView: ImageView? = null

    @BindView(R.id.searchback)
    var searchbackView: ImageView? = null

    @BindView(R.id.heart)
    var heartView: ImageView? = null
    private var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trimclip)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        isChecked = !isChecked
        val stateSet = intArrayOf(android.R.attr.state_checked * if (isChecked) 1 else -1)
        airplaneView!!.setImageState(stateSet, true)
        eyeView!!.setImageState(stateSet, true)
        flashlightView!!.setImageState(stateSet, true)
        searchbackView!!.setImageState(stateSet, true)
        heartView!!.setImageState(stateSet, true)
    }
}