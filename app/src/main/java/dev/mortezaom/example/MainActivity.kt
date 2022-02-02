package dev.mortezaom.example

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dev.mortezaom.mdtoast.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.defShort).setOnClickListener {
            sToast("Hello World")
        }
        findViewById<Button>(R.id.defLong).setOnClickListener {
            lToast("Hello World")
        }
        findViewById<Button>(R.id.iShort).setOnClickListener {
            sInfoToast("Hello World")
        }
        findViewById<Button>(R.id.iLong).setOnClickListener {
            lInfoToast("Hello World")
        }
        findViewById<Button>(R.id.wShort).setOnClickListener {
            sWarningToast("Hello World")
        }
        findViewById<Button>(R.id.wLong).setOnClickListener {
            lWarningToast("Hello World")
        }
        findViewById<Button>(R.id.sShort).setOnClickListener {
            sSuccessToast("Hello World")
        }
        findViewById<Button>(R.id.sLong).setOnClickListener {
            lSuccessToast("Hello World")
        }
        findViewById<Button>(R.id.eShort).setOnClickListener {
            sErrorToast("Hello World")
        }
        findViewById<Button>(R.id.eLong).setOnClickListener {
            this.lErrorToast("Hello World")
        }
        findViewById<Button>(R.id.tCustom).setOnClickListener {
            applicationContext.customMDToast(
                "Custom Hello World :)",
                MDToast.LENGTH_LONG,
                MDToast.TYPE_SUCCESS,
                Color.parseColor("#FA23A2"),
                null,
                12,
                6
            )
        }
    }
}