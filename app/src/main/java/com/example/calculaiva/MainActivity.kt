package com.example.calculaiva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var precio: EditText
    lateinit var calcular: Button
    lateinit var subtotal: TextView
    lateinit var iva: TextView
    lateinit var total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        precio = findViewById(R.id.precio)

        calcular = findViewById(R.id.calcular)
        subtotal = findViewById(R.id.subtotal)
        iva = findViewById(R.id.iva)
        total = findViewById(R.id.total)

    }

    fun calcularIVA(view: View) {

        if (precio.text.toString().isEmpty()) {
            var alerta = AlertDialog.Builder(this)
                .setTitle("Error!!")
                .setMessage("No ha ingresado un precio ")
            alerta.show()

        } else {

            val monto = precio.text.toString().toDoubleOrNull() ?: 0.0
            val tasaIVA = 0.160
            val ivaCalculado = monto * tasaIVA
            val subTotCal = monto - ivaCalculado
            val sumatot = ivaCalculado + subTotCal

            subtotal.text = "\$${String.format("%.2f", subTotCal)}"
            iva.text = "\$${String.format("%.2f", ivaCalculado)}"
            total.text = "\$${String.format("%.2f", sumatot)}"

        }

    }

    fun borrartext(view: View) {
        precio.setText(" ")
        subtotal.setText(" ")
        iva.setText(" ")
        total.setText(" ")


    }
}