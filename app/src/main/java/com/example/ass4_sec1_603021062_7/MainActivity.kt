package com.example.ass4_sec1_603021062_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var selected: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radioGroup = findViewById<RadioGroup>(R.id.radio)
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            var select = ""
            select += if (R.id.male == checkedId)
                "Male"
            else if (R.id.female == checkedId)
                "Female"
            else
                ""
            selected = select
        }
    }


        fun showRegister(view: View) {
            text_show.text =
                "Name: ${edit_user.text} \nPassword: ${edit_pass.text} \nGender: $selected \nE-mail: ${edit_mail.text} \nBirthday: ${bday.text}"
        }

        fun showDatePickerDialog(v: View) {
            val newDateFragment = DatePickerFragment()
            newDateFragment.show(supportFragmentManager, "Date Picker")
        }

        fun reset(v: View) {
            edit_user.text.clear()
            edit_pass.text.clear()
            edit_mail.text.clear()
            radio.clearCheck() //clearButton
            bday.text = "mm/dd/yy"
            text_show.text = "Show Information"
        }
    }
