package com.androidlearn.example.colorpick

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var viewColor: ColorDrawable
    private lateinit var ColorView: View
    private lateinit var GreenBar: SeekBar
    private lateinit var BlueBar: SeekBar
    private lateinit var RedBar: SeekBar
    private lateinit var Text: TextView
    private var Green = 0
    private var Red = 0
    private var Blue = 0
    private var hexa = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ColorView = findViewById(R.id.ColorView)
        GreenBar = findViewById(R.id.seekBarGreen)
        BlueBar = findViewById(R.id.seekBarBlue)
        RedBar = findViewById(R.id.seekBarRed)
        Text = findViewById(R.id.textHexa)
        GreenBar.setOnSeekBarChangeListener(this)
        RedBar.setOnSeekBarChangeListener(this)
        BlueBar.setOnSeekBarChangeListener(this)
        viewColor = ColorView.background as ColorDrawable

    }

    @SuppressLint("SetTextI18n")
    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        when (p0){
            RedBar -> Red = p1
            GreenBar -> Green = p1
            BlueBar -> Blue = p1
        }
        val colorId = viewColor.color
        hexa = Color.rgb(Red, Green, Blue)
        ColorView.setBackgroundColor(hexa)
        Text.setTextColor(hexa)
        Text.text = "A cor em Hexa: ${Integer.toHexString(colorId)}"
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        when (p0){
            RedBar -> Toast.makeText(this, "Alterando Componente Vermelho",Toast.LENGTH_SHORT).show()
            GreenBar -> Toast.makeText(this, "Alterando Componente Verde",Toast.LENGTH_SHORT).show()
            BlueBar -> Toast.makeText(this, "Alterando Componente Azul",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }




}