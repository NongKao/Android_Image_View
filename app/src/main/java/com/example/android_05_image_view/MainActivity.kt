package com.example.android_05_image_view

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : Activity() {

    var bg: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_main)

//        bg.add(R.drawable.demo)
//        bg.add(R.drawable.gohan)
//        bg.add(R.drawable.goku)
//        bg.add(R.drawable.vegeta)
//        var random = Random
//        var vitri = random.nextInt(bg.size)
//        myBackGround.setBackgroundResource(bg.get(vitri))

        sw_check.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (isChecked) {
                    Toast.makeText(this@MainActivity, "Bạn mở wifi", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Bạn tắt wifi", Toast.LENGTH_LONG).show()

                }
            }

        })

        rdBtn_check.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rb_check1 -> {
//                        Toast.makeText(this@MainActivity, "Check1", Toast.LENGTH_SHORT).show()
                    }
                    R.id.rb_check2 -> {
//                        Toast.makeText(this@MainActivity, "Check2", Toast.LENGTH_SHORT).show()
                    }
                    R.id.rb_check3 -> {
//                        Toast.makeText(this@MainActivity, "Check3", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

        btn_XacNhan.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                if (rb_check1.isChecked) {
//                    Toast.makeText(this@MainActivity, "ALLOW", Toast.LENGTH_SHORT).show()
//                }

                //TODO Xu li coundown timer


                //+ tổng thời gian = 20000, thời gian lặp lại = 1000(1s)
                var timer = object : CountDownTimer(20000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        var current: Int = progressBar2.progress
                        progressBar2.progress = current + 10

                        if (current == progressBar2.max) {
                            onFinish()
                        }
                    }

                    override fun onFinish() {
                        Toast.makeText(this@MainActivity, "FINISH", Toast.LENGTH_LONG).show()
                    }

                }
                timer.start()
            }


        })

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("TAG", "GIÁ TRỊ $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("TAG", "GIÁ TRỊ START")

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("TAG", "GIÁ TRỊ STOP")

            }

        })


    }
}