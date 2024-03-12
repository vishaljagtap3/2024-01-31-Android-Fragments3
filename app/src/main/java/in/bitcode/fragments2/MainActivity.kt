package `in`.bitcode.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnReset : Button
    private lateinit var edtCount : EditText

    private lateinit var counterFragmentAndroid : CounterFragment
    private lateinit var counterFragmentIos : CounterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initFragments()
        initListeners()

        counterFragmentAndroid.title = "Android Students"
        counterFragmentIos.title = "iOS Students"
    }

    private fun initListeners() {
        btnReset.setOnClickListener {
            val count = edtCount.text.toString().toInt()
            counterFragmentAndroid.reset(count)
            counterFragmentIos.reset(count)
        }
    }

    private fun initFragments() {
        counterFragmentAndroid =
            supportFragmentManager.findFragmentById(R.id.counterFragment1) as CounterFragment
        counterFragmentIos =
            supportFragmentManager.findFragmentById(R.id.counterFragment2) as CounterFragment
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        btnReset = findViewById(R.id.btnReset)
        edtCount = findViewById(R.id.edtCount)
    }
}