package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class AnimalsActivity : AppCompatActivity() {
    @BindView(R.id.icon)
    var iconView: ImageView? = null

    @BindView(R.id.hippo)
    var hippoButton: View? = null

    @BindView(R.id.buffalo)
    var buffaloButton: View? = null

    @BindView(R.id.elephant)
    var elephantButton: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.hippo)
    fun setHippo() {
        hippoButton!!.isEnabled = false
        buffaloButton!!.isEnabled = true
        elephantButton!!.isEnabled = true
        iconView!!.setImageState(STATE_SET_HIPPO, true)
    }

    @OnClick(R.id.buffalo)
    fun setBuffalo() {
        hippoButton!!.isEnabled = true
        buffaloButton!!.isEnabled = false
        elephantButton!!.isEnabled = true
        iconView!!.setImageState(STATE_SET_BUFFALO, true)
    }

    @OnClick(R.id.elephant)
    fun setElephant() {
        hippoButton!!.isEnabled = true
        buffaloButton!!.isEnabled = true
        elephantButton!!.isEnabled = false
        iconView!!.setImageState(STATE_SET_ELEPHANT, true)
    }

    companion object {
        private val STATE_SET_HIPPO = intArrayOf(R.attr.state_hippo, -R.attr.state_buffalo, -R.attr.state_elephant)
        private val STATE_SET_BUFFALO = intArrayOf(-R.attr.state_hippo, R.attr.state_buffalo, -R.attr.state_elephant)
        private val STATE_SET_ELEPHANT = intArrayOf(-R.attr.state_hippo, -R.attr.state_buffalo, R.attr.state_elephant)
    }
}