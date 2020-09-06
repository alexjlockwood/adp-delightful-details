package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class CheckableActivity : AppCompatActivity() {
    @BindView(R.id.radiobutton)
    var radioButtonView: ImageView? = null

    @BindView(R.id.checkbox)
    var checkBoxView: ImageView? = null

    @BindView(R.id.expandcollapse)
    var expandCollapseView: ImageView? = null
    private var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkable)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        isChecked = !isChecked
        val stateSet = intArrayOf(android.R.attr.state_checked * if (isChecked) 1 else -1)
        radioButtonView!!.setImageState(stateSet, true)
        checkBoxView!!.setImageState(stateSet, true)
        expandCollapseView!!.setImageState(stateSet, true)
    }
}