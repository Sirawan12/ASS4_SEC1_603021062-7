package com.example.ass4_sec1_603021062_7

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*


class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener{

    private lateinit var calender: Calendar
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        calender = Calendar.getInstance()

        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), 2, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year:Int, month:Int, day:Int) {
        Toast.makeText(activity, "Date Set : ${formatDate(year,month,day)}", Toast.LENGTH_SHORT).show()
        activity!!.findViewById<TextView>(R.id.bday).text = formatDate(year,month,day)
    }

    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity, "Please select a date", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }

    private fun formatDate(year: Int, month: Int, day: Int):String{
        calender.set(year,month,day,0,0,0)
        val chosenDate = calender.time
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }




}