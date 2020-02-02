package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var _binding: ActivityMainBinding

    val myName: MyName = MyName("Daniele De Padova")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        _binding.myName = myName

        val button: Button = _binding.doneBtn
        button.setOnClickListener { addDoneButtonHandler(it) }
    }

    private fun addDoneButtonHandler(view: View) {
        /* val editText = findViewById<TextView>(R.id.nickname_edit)
        val nicknameText = findViewById<TextView>(R.id.nickname_text) */
        _binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
