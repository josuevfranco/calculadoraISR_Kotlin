package com.example.calculadora_isr

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double.parseDouble

class ResultadoCalculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        //Abrir Spinner con opciones de los datos
        val datos = arrayOf("2021")
        val adaptador1 = ArrayAdapter(this,android.R.layout.simple_spinner_item,datos)

        val cmbOpciones1 : Spinner = findViewById(R.id.cmbOpciones1)
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_item)
        cmbOpciones1.adapter = adaptador1

        //Para cambiar la opción que seleccione el usuario.
        cmbOpciones1.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    applicationContext,
                    "Sin selección Spinner1",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position:
            Int, id: Long) {
                val pos = parent?.getItemAtPosition(position)
                Toast.makeText(
                    applicationContext,
                    "Seleccionaste: $pos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //Selección de Cálculos para ISR
        // (DIARIO, SEMANAL, MENSUAL, ANUAL)
        val rbOpc1 : RadioButton =  findViewById(R.id.rbOpc1)
        val rbOpc2 : RadioButton =  findViewById(R.id.rbOpc2)
        val rbOpc3 : RadioButton =  findViewById(R.id.rbOpc3)
        val rbOpc4 : RadioButton =  findViewById(R.id.rbOpc4)
        val rbOpc5 : RadioButton =  findViewById(R.id.rbOpc5)

        //Funcionamiento de RadioButtons
        val opcion1 : RadioButton = findViewById(R.id.rbOpc1)
        val opcion2 : RadioButton = findViewById(R.id.rbOpc2)
        val opcion3 : RadioButton = findViewById(R.id.rbOpc3)
        val opcion4 : RadioButton = findViewById(R.id.rbOpc4)
        val opcion5 : RadioButton = findViewById(R.id.rbOpc5)

        //Para datos de entrad y salida
        var unidadEntrada : String = ""
        var unidadSalida  : String = ""
        var unidad : String = ""


        val entrada : EditText =  findViewById(R.id.entrada)
        val salida  : TextView =  findViewById(R.id.salida)
        val btnCalcular : Button =  findViewById(R.id.btnCalcular)

        //Para guardar el tipo de retención seleccionada
        val handler = View.OnClickListener { view ->
            if (view is RadioButton){
                when(view.id){
                    R.id.rbOpc1 ->
                        unidadEntrada = "1" //Diaria
                    R.id.rbOpc2 ->
                        unidadEntrada = "2" //Semanal
                    R.id.rbOpc3 ->
                        unidadEntrada = "3" //Decenal
                    R.id.rbOpc4 ->
                        unidadEntrada = "4" //Quincenal
                    R.id.rbOpc5 ->
                        unidadEntrada = "5" //Mensual
                }
            }
        }

        //Guardamos en opciones lo que se seleccionó
        opcion1.setOnClickListener(handler)
        opcion2.setOnClickListener(handler)
        opcion3.setOnClickListener(handler)
        opcion4.setOnClickListener(handler)
        opcion5.setOnClickListener(handler)


        //Funcionamiento al dar clic al botón de calcular
        //Primero dentro de un when revisamos que opción de retención de ISR
        //se seleccionó, luego en cada uno en la variable ya traía anteriormente de la entrada del suedo
        //vamos revisando en qué intervalo está y se sigue todo el proceso para obtener
        //la retención total.
        btnCalcular.setOnClickListener{
            when (unidadEntrada){
                //Calculo para IS2 2021: retención diaria
                "1" -> {
                    var sueldoBruto : Double = (parseDouble(entrada.text.toString()))
                    var copiaBruto  : Double = 0.0
                    if (sueldoBruto in 0.01..21.20){
                        sueldoBruto -= 0.01
                        sueldoBruto = ((sueldoBruto * 1.92) / 100)
                        sueldoBruto += 0.0
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if (sueldoBruto in 21.21..179.26){
                        sueldoBruto -= 21.21
                        sueldoBruto = ((sueldoBruto * 6.40) / 100)
                        sueldoBruto += 0.41
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 179.27..316.27){
                        sueldoBruto -= 179.27
                        sueldoBruto = ((sueldoBruto * 10.88) / 100)
                        sueldoBruto += 10.57
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if (sueldoBruto in 316.28..367.65){
                        sueldoBruto -= 316.28
                        sueldoBruto = ((sueldoBruto * 16.0) / 100)
                        sueldoBruto += 25.40
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if (sueldoBruto in 367.28..440.18){
                        sueldoBruto -= 367.28
                        sueldoBruto = ((sueldoBruto * 17.92) / 100)
                        sueldoBruto += 33.62
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 440.19..887.78){
                        sueldoBruto -= 440.19
                        sueldoBruto = ((sueldoBruto * 21.36) / 100)
                        sueldoBruto += 46.62
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if (sueldoBruto in 887.79..1399.26){
                        sueldoBruto -= 887.29
                        sueldoBruto = ((sueldoBruto * 23.52) / 100)
                        sueldoBruto += 142.22
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if (sueldoBruto in 1399.27..2671.42){
                        sueldoBruto -= 1399.27
                        sueldoBruto = ((sueldoBruto * 30.0) / 100)
                        sueldoBruto += 262.52
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 3671.43..3561.90){
                        sueldoBruto -= 3671.43
                        sueldoBruto = ((sueldoBruto * 32.0) / 100)
                        sueldoBruto += 644.17
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 3561.91..10685.69){
                        sueldoBruto -= 3561.91
                        sueldoBruto = ((sueldoBruto * 34.0) / 100)
                        sueldoBruto += 929.12
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if (sueldoBruto >= 10685.70){
                        sueldoBruto -= 10685.70
                        sueldoBruto = ((sueldoBruto * 35.0) / 100)
                        sueldoBruto += 3351.21
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else{
                        salida.setText("Ingresa una cantidad Válida")
                    }
                }
                //Cálculo ISR 2021: retenciones semanales
                "2" -> {
                    var sueldoBruto : Double = (parseDouble(entrada.text.toString()))
                    if (sueldoBruto in 0.01..148.40){
                        sueldoBruto -= 0.01
                        sueldoBruto = ((sueldoBruto * 1.92) / 100)
                        sueldoBruto += 0.0
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 148.41..1259.72){
                        sueldoBruto -= 148.41
                        sueldoBruto = ((sueldoBruto * 6.40) / 100)
                        sueldoBruto += 2.87
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 1259.73..2213.89){
                        sueldoBruto -= 1259.73
                        sueldoBruto = ((sueldoBruto * 10.88) / 100)
                        sueldoBruto += 73.99
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 2213.90..2573.55){
                        sueldoBruto -= 2213.90
                        sueldoBruto = ((sueldoBruto * 16) / 100)
                        sueldoBruto += 177.80
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 2573.56..3081.26){
                        sueldoBruto -= 2573.56
                        sueldoBruto = ((sueldoBruto * 17.92) / 100)
                        sueldoBruto += 235.34
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 3081.27..6214.46){
                        sueldoBruto -= 3081.27
                        sueldoBruto = ((sueldoBruto * 21.36) / 100)
                        sueldoBruto += 326.34
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 6214.47..9794.82){
                        sueldoBruto -= 6214.47
                        sueldoBruto = ((sueldoBruto * 23.52) / 100)
                        sueldoBruto += 995.54
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 9794.83..18699.94){
                        sueldoBruto -= 6214.47
                        sueldoBruto = ((sueldoBruto * 30) / 100)
                        sueldoBruto += 995.54
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 18699.95..24933.30){
                        sueldoBruto -= 18699.95
                        sueldoBruto = ((sueldoBruto * 32) / 100)
                        sueldoBruto += 4059.19
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 24933.31..79799.83){
                        sueldoBruto -= 24933.31
                        sueldoBruto = ((sueldoBruto * 34) / 100)
                        sueldoBruto += 6503.84
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto >= 74799.84){
                        sueldoBruto -= 74799.84
                        sueldoBruto = ((sueldoBruto * 35) / 100)
                        sueldoBruto += 23458.47
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else{
                        salida.setText("Ingresa una cantidad válida")
                    }
                }
                //Cálculo ISR 2021: retenciones decenales
                "3" -> {
                    var sueldoBruto : Double = (parseDouble(entrada.text.toString()))
                    if (sueldoBruto in 0.01..212.00){
                        sueldoBruto -= 0.01
                        sueldoBruto = ((sueldoBruto * 1.92) / 100)
                        sueldoBruto += 0.0
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 212.01..1799.60){
                        sueldoBruto -= 212.01
                        sueldoBruto = ((sueldoBruto * 6.40) / 100)
                        sueldoBruto += 4.10
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 1799.61..3162.70){
                        sueldoBruto -= 1799.61
                        sueldoBruto = ((sueldoBruto * 10.88) / 100)
                        sueldoBruto += 105.70
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 3162.71..3676.50){
                        sueldoBruto -= 3162.71
                        sueldoBruto = ((sueldoBruto * 16) / 100)
                        sueldoBruto += 254.0
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 3676.51..4401.80){
                        sueldoBruto -= 3676.51
                        sueldoBruto = ((sueldoBruto * 17.92) / 100)
                        sueldoBruto += 336.20
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 40401.81..8877.80){
                        sueldoBruto -= 40401.81
                        sueldoBruto = ((sueldoBruto * 21.36) / 100)
                        sueldoBruto += 466.20
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 8877.81..13992.60){
                        sueldoBruto -= 8877.81
                        sueldoBruto = ((sueldoBruto * 23.52) / 100)
                        sueldoBruto += 1422.20
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 13992.61..26714.20){
                        sueldoBruto -= 13992.61
                        sueldoBruto = ((sueldoBruto * 30) / 100)
                        sueldoBruto += 2625.20
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 26714.21..35619.00){
                        sueldoBruto -= 26714.21
                        sueldoBruto = ((sueldoBruto * 32) / 100)
                        sueldoBruto += 6441.70
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 35619.01..106856.90){
                        sueldoBruto -=  35619.01
                        sueldoBruto = ((sueldoBruto * 34) / 100)
                        sueldoBruto += 9291.20
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto >= 106856.91){
                        sueldoBruto -= 106856.91
                        sueldoBruto = ((sueldoBruto * 35) / 100)
                        sueldoBruto += 33512.10
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else{
                        salida.setText("Ingresa una cantidad válida")
                    }
                }
                //Cálculo ISR 2021: retenciones quincenal.
                "4" -> {
                    var sueldoBruto : Double = (parseDouble(entrada.text.toString()))
                    if (sueldoBruto in 0.01..318.00){
                        sueldoBruto -= 0.01
                        sueldoBruto = ((sueldoBruto * 1.92) / 100)
                        sueldoBruto += 0.0
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 318.01..2699.40){
                        sueldoBruto -= 318.01
                        sueldoBruto = ((sueldoBruto * 6.40) / 100)
                        sueldoBruto += 6.15
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 2699.41..4744.05){
                        sueldoBruto -= 2699.41
                        sueldoBruto = ((sueldoBruto * 10.88) / 100)
                        sueldoBruto += 158.55
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 4744.06..5514.75){
                        sueldoBruto -= 4744.06
                        sueldoBruto = ((sueldoBruto * 16) / 100)
                        sueldoBruto += 341.00
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 5514.76..6602.70){
                        sueldoBruto -= 5514.76
                        sueldoBruto = ((sueldoBruto * 17.92) / 100)
                        sueldoBruto += 504.30
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 6602.71..13316.70){
                        sueldoBruto -= 6602.71
                        sueldoBruto = ((sueldoBruto * 21.36) / 100)
                        sueldoBruto += 699.30
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 13316.71..20988.90){
                        sueldoBruto -= 13316.71
                        sueldoBruto = ((sueldoBruto * 23.52) / 100)
                        sueldoBruto += 2133.30
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 20988.91..40071.30){
                        sueldoBruto -= 20988.91
                        sueldoBruto = ((sueldoBruto * 30) / 100)
                        sueldoBruto += 3937.80
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 40071.31..53428.50){
                        sueldoBruto -=  40071.31
                        sueldoBruto = ((sueldoBruto * 32) / 100)
                        sueldoBruto += 9662.55
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 53428.51..160285.35){
                        sueldoBruto -=  53428.51
                        sueldoBruto = ((sueldoBruto * 34) / 100)
                        sueldoBruto += 13936.80
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto >= 160285.36){
                        sueldoBruto -= 160285.36
                        sueldoBruto = ((sueldoBruto * 35) / 100)
                        sueldoBruto += 50268.15
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else{
                        salida.setText("Ingresa una cantidad válida")
                    }
                }
                //Cálculo ISR 2021: retenciones mensual.
                "5" -> {
                    var sueldoBruto : Double = (parseDouble(entrada.text.toString()))
                    if (sueldoBruto in 0.01..644.58){
                        sueldoBruto -= 0.01
                        sueldoBruto = ((sueldoBruto * 1.92) / 100)
                        sueldoBruto += 0.0
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 644.59..5470.92){
                        sueldoBruto -= 644.59
                        sueldoBruto = ((sueldoBruto * 6.40) / 100)
                        sueldoBruto += 12.38
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 5470.93..9614.66){
                        sueldoBruto -= 5470.93
                        sueldoBruto = ((sueldoBruto * 10.88) / 100)
                        sueldoBruto += 321.26
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 9614.67..11176.62){
                        sueldoBruto -= 9614.67
                        sueldoBruto = ((sueldoBruto * 16) / 100)
                        sueldoBruto += 772.10
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 11176.63..13381.47){
                        sueldoBruto -= 11176.63
                        sueldoBruto = ((sueldoBruto * 17.92) / 100)
                        sueldoBruto += 1022.01
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 13381.48..26988.50){
                        sueldoBruto -= 13381.48
                        sueldoBruto = ((sueldoBruto * 21.36) / 100)
                        sueldoBruto += 1417.12
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 26988.51..42537.58){
                        sueldoBruto -=  26988.51
                        sueldoBruto = ((sueldoBruto * 23.52) / 100)
                        sueldoBruto += 4223.58
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 42537.59..81211.25){
                        sueldoBruto -= 42537.59
                        sueldoBruto = ((sueldoBruto * 30) / 100)
                        sueldoBruto += 7980.73
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 81211.26..108281.67){
                        sueldoBruto -=  81211.26
                        sueldoBruto = ((sueldoBruto * 32) / 100)
                        sueldoBruto += 19582.83
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto in 108281.68..324845.01){
                        sueldoBruto -= 108281.68
                        sueldoBruto = ((sueldoBruto * 34) / 100)
                        sueldoBruto += 28245.36
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else if(sueldoBruto >= 324845.02){
                        sueldoBruto -= 324845.02
                        sueldoBruto = ((sueldoBruto * 35) / 100)
                        sueldoBruto += 101876.90
                        Math.round(sueldoBruto)
                        salida.setText(sueldoBruto.toString())
                    }else{
                        salida.setText("Ingresa una cantidad válida")
                    }
                }
            }
        }

    }
}