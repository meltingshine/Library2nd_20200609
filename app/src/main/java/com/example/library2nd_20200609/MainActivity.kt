package com.example.library2nd_20200609

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setValues() {

    Glide.with(mContext).load("http://image.ytn.co.kr/general/jpg/2020/0211/202002111418090858_d.jpg").into(profileImg)
    }

    override fun setupEvents() {
        profileImg.setOnClickListener {

            val myIntent = Intent(mContext, LargePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }
    }



