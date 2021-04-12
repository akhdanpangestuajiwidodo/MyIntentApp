package org.d3if0008.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityData: Button
    private lateinit var btnDialNumber: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityData = findViewById(R.id.btn_move_activity_data)
        btnDialNumber = findViewById(R.id.btn_dial_number)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityData.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveActivity = Intent(this, MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.btn_move_activity_data ->{
                val moveActivityData = Intent(this, MoveWithDataActivity::class.java)
                moveActivityData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Akhdan Pangestuaji")
                moveActivityData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                startActivity(moveActivityData)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081345678"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}