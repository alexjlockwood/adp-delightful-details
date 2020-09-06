package com.alexjlockwood.example.delight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class CountdownActivity : AppCompatActivity() {
    @BindView(R.id.countdownIcon)
    var countdownView: ImageView? = null
    private var nextDigitStateIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.rootview)
    fun onClick() {
        // Decrement the countdown view by one.
        val numStates = DIGIT_STATES.size
        val stateSet = IntArray(numStates)
        for (i in stateSet.indices) {
            if (i == nextDigitStateIndex) {
                stateSet[i] = DIGIT_STATES[numStates - i - 1]
            } else {
                stateSet[i] = -DIGIT_STATES[numStates - i - 1]
            }
        }
        countdownView!!.setImageState(stateSet, true)
        nextDigitStateIndex = (nextDigitStateIndex + 1) % numStates
    }

    companion object {
        private val DIGIT_STATES = intArrayOf(
                R.attr.state_zero,
                R.attr.state_one,
                R.attr.state_two,
                R.attr.state_three,
                R.attr.state_four,
                R.attr.state_five,
                R.attr.state_six,
                R.attr.state_seven,
                R.attr.state_eight,
                R.attr.state_nine)
    }
}