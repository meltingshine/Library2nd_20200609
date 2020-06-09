package com.example.library2nd_20200609

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        callBtn.setOnClickListener(){
            val pl = object : PermissionListener {
                override fun onPermissionGranted()
                {//허가가 나면 실행할 일 = 실제로 전화 연결 을 함
                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                  //거부되면 실행할 내용
                    Toast.makeText(mContext,"권한없음 ㅗㅗ",Toast.LENGTH_SHORT).show()
                }

            }
            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("통화 권한을 거부하면 안되지임마 설정>권한에서 고치세요 얼른")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }
    }



