package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class FingerprintActivity : AppCompatActivity() {
    @BindView(R.id.icon)
    var iconView: ImageView? = null

    @BindView(R.id.on)
    var onButton: View? = null

    @BindView(R.id.off)
    var offButton: View? = null

    @BindView(R.id.error)
    var errorButton: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.on)
    fun setFingerprintOn() {
        onButton!!.isEnabled = false
        offButton!!.isEnabled = true
        errorButton!!.isEnabled = true
        iconView!!.setImageState(STATE_SET_ON, true)
    }

    @OnClick(R.id.off)
    fun setFingerprintOff() {
        onButton!!.isEnabled = true
        offButton!!.isEnabled = false
        errorButton!!.isEnabled = false
        iconView!!.setImageState(STATE_SET_OFF, true)
    }

    @OnClick(R.id.error)
    fun setFingerprintError() {
        onButton!!.isEnabled = true
        offButton!!.isEnabled = false
        errorButton!!.isEnabled = false
        iconView!!.setImageState(STATE_SET_ERROR, true)
    }

    companion object {
        private val STATE_SET_ON = intArrayOf(R.attr.state_on, -R.attr.state_off, -R.attr.state_error)
        private val STATE_SET_OFF = intArrayOf(-R.attr.state_on, R.attr.state_off, -R.attr.state_error)
        private val STATE_SET_ERROR = intArrayOf(-R.attr.state_on, -R.attr.state_off, R.attr.state_error)
    }
}