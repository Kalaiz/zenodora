package com.kalai.zenodora.view.waveview


import android.content.Context
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import android.util.AttributeSet
import android.widget.LinearLayout
import com.kalai.zenodora.R


/**
 * Created by John on 2014/10/15.
 * Translated to Kotlin by Kalai
 */
class WaveView(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {
    private val mAboveWaveColor: Int
    private val mBlowWaveColor: Int
    private var mProgress: Int
    private val mWaveHeight: Int
    private val mWaveMultiple: Int
    private val mWaveHz: Int
    private var mWaveToTop = 0
    private val mWave: Wave
    private val mSolid: Solid

    private fun setProgress(progress: Int) {
        mProgress = if (progress > 100) 100 else progress
        computeWaveToTop()
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        if (hasWindowFocus) {
            computeWaveToTop()
        }
    }

    private fun computeWaveToTop() {
        mWaveToTop = (height * (1f - mProgress / 100f)).toInt()
        val params = mWave.layoutParams
        if (params != null) {
            (params as LayoutParams).topMargin = mWaveToTop
        }
        mWave.layoutParams = params
    }

    public override fun onSaveInstanceState(): Parcelable {
        // Force our ancestor class to save its state
        val superState = super.onSaveInstanceState()
        val ss = SavedState(superState)
        ss.progress = mProgress
        return ss
    }

    public override fun onRestoreInstanceState(state: Parcelable) {
        val ss = state as SavedState
        super.onRestoreInstanceState(ss.superState)
        setProgress(ss.progress)
    }

    private class SavedState : BaseSavedState {
        var progress = 0

        /**
         * Constructor called from [android.widget.ProgressBar.onSaveInstanceState]
         */
        internal constructor(superState: Parcelable?) : super(superState) {}

        /**
         * Constructor called from [.CREATOR]
         */
        private constructor(`in`: Parcel) : super(`in`) {
            progress = `in`.readInt()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeInt(progress)
        }

        companion object {
            @JvmField val CREATOR: Creator<SavedState?> = object : Creator<SavedState?> {
                override fun createFromParcel(`in`: Parcel): SavedState {
                    return SavedState(`in`)
                }

                override fun newArray(size: Int): Array<SavedState?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }

    companion object {
        const val LARGE = 1
        const val MIDDLE = 2
        const val LITTLE = 3
        private const val DEFAULT_ABOVE_WAVE_COLOR = Color.WHITE
        private const val DEFAULT_BLOW_WAVE_COLOR = Color.WHITE
        private const val DEFAULT_PROGRESS = 80
    }

    init {
        orientation = VERTICAL
        val attributes = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.WaveView,
            R.attr.wave_view_style,
            0
        )
        mAboveWaveColor =
            attributes.getColor(R.styleable.WaveView_above_wave_color, DEFAULT_ABOVE_WAVE_COLOR)
        mBlowWaveColor =
            attributes.getColor(R.styleable.WaveView_blow_wave_color, DEFAULT_BLOW_WAVE_COLOR)
        mProgress = attributes.getInt(R.styleable.WaveView_progress, DEFAULT_PROGRESS)
        mWaveHeight = attributes.getInt(R.styleable.WaveView_wave_height, MIDDLE)
        mWaveMultiple = attributes.getInt(R.styleable.WaveView_wave_length, LARGE)
        mWaveHz = attributes.getInt(R.styleable.WaveView_wave_hz, MIDDLE)
        attributes.recycle()
        mWave = Wave(context, null)
        mWave.initializeWaveSize(mWaveMultiple, mWaveHeight, mWaveHz)
        mWave.setAboveWaveColor(mAboveWaveColor)
        mWave.setBlowWaveColor(mBlowWaveColor)
        mWave.initializePainters()
        mSolid = Solid(context, null)
        mSolid.setAboveWavePaint(mWave.aboveWavePaint)
        mSolid.setBlowWavePaint(mWave.blowWavePaint)
        addView(mWave)
        addView(mSolid)
        setProgress(mProgress)
    }
}
