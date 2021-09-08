/*
 * MIT License
 *
 * Copyright (c) 2021 A M Satrio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ams64.rlcalc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.ClipData
import android.content.ClipboardManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class RLCActivity : AppCompatActivity() {
    private var clipData: ClipData? = null
    private var clipboardManager: ClipboardManager? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rlc)

        //BACK BUTTON
        // showing the back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Clipboard
        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

        var r1 = 0.0
        var r2 = 0.0
        var r3 = 0.0
        var r4 = 0.0
        var r5 = 0.0
        var r6 = 0.0
        var r7 = 0.0

        var l1 = 0.0
        var l2 = 0.0
        var l3 = 0.0
        var l4 = 0.0
        var l5 = 0.0
        var l6 = 0.0
        var l7 = 0.0

        var c1 = 0.0
        var c2 = 0.0
        var c3 = 0.0
        var c4 = 0.0
        var c5 = 0.0
        var c6 = 0.0
        var c7 = 0.0


        val editTextNumberR1: EditText = findViewById(R.id.editTextNumberR1)
        val editTextNumberR2: EditText = findViewById(R.id.editTextNumberR2)
        val editTextNumberR3: EditText = findViewById(R.id.editTextNumberR3)
        val editTextNumberR4: EditText = findViewById(R.id.editTextNumberR4)
        val editTextNumberR5: EditText = findViewById(R.id.editTextNumberR5)
        val editTextNumberR6: EditText = findViewById(R.id.editTextNumberR6)
        val editTextNumberR7: EditText = findViewById(R.id.editTextNumberR7)

        val editTextNumberC1: EditText = findViewById(R.id.editTextNumberC1)
        val editTextNumberC2: EditText = findViewById(R.id.editTextNumberC2)
        val editTextNumberC3: EditText = findViewById(R.id.editTextNumberC3)
        val editTextNumberC4: EditText = findViewById(R.id.editTextNumberC4)
        val editTextNumberC5: EditText = findViewById(R.id.editTextNumberC5)
        val editTextNumberC6: EditText = findViewById(R.id.editTextNumberC6)
        val editTextNumberC7: EditText = findViewById(R.id.editTextNumberC7)

        val editTextNumberL1: EditText = findViewById(R.id.editTextNumberL1)
        val editTextNumberL2: EditText = findViewById(R.id.editTextNumberL2)
        val editTextNumberL3: EditText = findViewById(R.id.editTextNumberL3)
        val editTextNumberL4: EditText = findViewById(R.id.editTextNumberL4)
        val editTextNumberL5: EditText = findViewById(R.id.editTextNumberL5)
        val editTextNumberL6: EditText = findViewById(R.id.editTextNumberL6)
        val editTextNumberL7: EditText = findViewById(R.id.editTextNumberL7)

        val editTextNumberVAC: EditText = findViewById(R.id.editTextNumberVAC)
        val editTextNumberVHz: EditText = findViewById(R.id.editTextNumberVHz)

        var vAC = 220.0
        var vHz = 50.0

        val buttonResult: Button = findViewById(R.id.buttonResult)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        val electricalConnection: String? =
            intent.getStringExtra("Electrical Connection")
        val electricalComponent: String? =
            intent.getStringExtra("Electrical Component")

        val linearLayoutR: LinearLayout = findViewById(R.id.linearLayoutRSection)
        val linearLayoutL: LinearLayout = findViewById(R.id.linearLayoutLSection)
        val linearLayoutC: LinearLayout = findViewById(R.id.linearLayoutCSection)
        val linearLayoutVAC: LinearLayout = findViewById(R.id.linearLayoutVAC)

        var dimensionRLC = ""
        if(electricalComponent == "R"){
            linearLayoutR.visibility = View.VISIBLE
            linearLayoutL.visibility = View.GONE
            linearLayoutC.visibility = View.GONE
            linearLayoutVAC.visibility = View.GONE
            dimensionRLC = "Ohm"
        }
        if(electricalComponent == "L"){
            linearLayoutR.visibility = View.GONE
            linearLayoutL.visibility = View.VISIBLE
            linearLayoutC.visibility = View.GONE
            linearLayoutVAC.visibility = View.GONE
            dimensionRLC = "H"
        }
        if(electricalComponent == "C"){
            linearLayoutR.visibility = View.GONE
            linearLayoutL.visibility = View.GONE
            linearLayoutC.visibility = View.VISIBLE
            linearLayoutVAC.visibility = View.GONE
            dimensionRLC = "F"
        }

        if(electricalComponent == "RL"){
            linearLayoutR.visibility = View.VISIBLE
            linearLayoutL.visibility = View.VISIBLE
            linearLayoutC.visibility = View.GONE
            linearLayoutVAC.visibility = View.VISIBLE
            editTextNumberR2.visibility = View.GONE
            editTextNumberR3.visibility = View.GONE
            editTextNumberR4.visibility = View.GONE
            editTextNumberR5.visibility = View.GONE
            editTextNumberR6.visibility = View.GONE
            editTextNumberR7.visibility = View.GONE
            editTextNumberC2.visibility = View.GONE
            editTextNumberC3.visibility = View.GONE
            editTextNumberC4.visibility = View.GONE
            editTextNumberC5.visibility = View.GONE
            editTextNumberC6.visibility = View.GONE
            editTextNumberC7.visibility = View.GONE
            editTextNumberL2.visibility = View.GONE
            editTextNumberL3.visibility = View.GONE
            editTextNumberL4.visibility = View.GONE
            editTextNumberL5.visibility = View.GONE
            editTextNumberL6.visibility = View.GONE
            editTextNumberL7.visibility = View.GONE
        }
        if(electricalComponent == "RC"){
            linearLayoutR.visibility = View.VISIBLE
            linearLayoutL.visibility = View.GONE
            linearLayoutC.visibility = View.VISIBLE
            linearLayoutVAC.visibility = View.VISIBLE
            editTextNumberR2.visibility = View.GONE
            editTextNumberR3.visibility = View.GONE
            editTextNumberR4.visibility = View.GONE
            editTextNumberR5.visibility = View.GONE
            editTextNumberR6.visibility = View.GONE
            editTextNumberR7.visibility = View.GONE
            editTextNumberC2.visibility = View.GONE
            editTextNumberC3.visibility = View.GONE
            editTextNumberC4.visibility = View.GONE
            editTextNumberC5.visibility = View.GONE
            editTextNumberC6.visibility = View.GONE
            editTextNumberC7.visibility = View.GONE
            editTextNumberL2.visibility = View.GONE
            editTextNumberL3.visibility = View.GONE
            editTextNumberL4.visibility = View.GONE
            editTextNumberL5.visibility = View.GONE
            editTextNumberL6.visibility = View.GONE
            editTextNumberL7.visibility = View.GONE
        }
        if(electricalComponent == "LC"){
            linearLayoutR.visibility = View.GONE
            linearLayoutL.visibility = View.VISIBLE
            linearLayoutC.visibility = View.VISIBLE
            linearLayoutVAC.visibility = View.VISIBLE
            editTextNumberR2.visibility = View.GONE
            editTextNumberR3.visibility = View.GONE
            editTextNumberR4.visibility = View.GONE
            editTextNumberR5.visibility = View.GONE
            editTextNumberR6.visibility = View.GONE
            editTextNumberR7.visibility = View.GONE
            editTextNumberC2.visibility = View.GONE
            editTextNumberC3.visibility = View.GONE
            editTextNumberC4.visibility = View.GONE
            editTextNumberC5.visibility = View.GONE
            editTextNumberC6.visibility = View.GONE
            editTextNumberC7.visibility = View.GONE
            editTextNumberL2.visibility = View.GONE
            editTextNumberL3.visibility = View.GONE
            editTextNumberL4.visibility = View.GONE
            editTextNumberL5.visibility = View.GONE
            editTextNumberL6.visibility = View.GONE
            editTextNumberL7.visibility = View.GONE
        }

        if(electricalComponent == "RLC"){
            linearLayoutR.visibility = View.VISIBLE
            linearLayoutL.visibility = View.VISIBLE
            linearLayoutC.visibility = View.VISIBLE
            linearLayoutVAC.visibility = View.VISIBLE
            editTextNumberR2.visibility = View.GONE
            editTextNumberR3.visibility = View.GONE
            editTextNumberR4.visibility = View.GONE
            editTextNumberR5.visibility = View.GONE
            editTextNumberR6.visibility = View.GONE
            editTextNumberR7.visibility = View.GONE
            editTextNumberC2.visibility = View.GONE
            editTextNumberC3.visibility = View.GONE
            editTextNumberC4.visibility = View.GONE
            editTextNumberC5.visibility = View.GONE
            editTextNumberC6.visibility = View.GONE
            editTextNumberC7.visibility = View.GONE
            editTextNumberL2.visibility = View.GONE
            editTextNumberL3.visibility = View.GONE
            editTextNumberL4.visibility = View.GONE
            editTextNumberL5.visibility = View.GONE
            editTextNumberL6.visibility = View.GONE
            editTextNumberL7.visibility = View.GONE
        }

        buttonResult.setOnClickListener{
            if(
                (electricalConnection == "Series" && (
                        electricalComponent == "R" || electricalComponent == "L")) ||
                (electricalConnection == "Parallel" && electricalComponent == "C" )
            ) {
                if(editTextNumberR1.text.isNotEmpty()){
                    r1 = editTextNumberR1.text.toString().toDouble()
                }
                if(editTextNumberR2.text.isNotEmpty()){
                    r2 = editTextNumberR2.text.toString().toDouble()
                }
                if(editTextNumberR3.text.isNotEmpty()){
                    r3 = editTextNumberR3.text.toString().toDouble()
                }
                if(editTextNumberR4.text.isNotEmpty()){
                    r4 = editTextNumberR4.text.toString().toDouble()
                }
                if(editTextNumberR5.text.isNotEmpty()){
                    r5 = editTextNumberR5.text.toString().toDouble()
                }
                if(editTextNumberR6.text.isNotEmpty()){
                    r6 = editTextNumberR6.text.toString().toDouble()
                }
                if(editTextNumberR7.text.isNotEmpty()){
                    r7 = editTextNumberR7.text.toString().toDouble()
                }

                if(editTextNumberC1.text.isNotEmpty()){
                    c1 = editTextNumberC1.text.toString().toDouble()
                }
                if(editTextNumberC2.text.isNotEmpty()){
                    c2 = editTextNumberC2.text.toString().toDouble()
                }
                if(editTextNumberC3.text.isNotEmpty()){
                    c3 = editTextNumberC3.text.toString().toDouble()
                }
                if(editTextNumberC4.text.isNotEmpty()){
                    c4 = editTextNumberC4.text.toString().toDouble()
                }
                if(editTextNumberC5.text.isNotEmpty()){
                    c5 = editTextNumberC5.text.toString().toDouble()
                }
                if(editTextNumberC6.text.isNotEmpty()){
                    c6 = editTextNumberC6.text.toString().toDouble()
                }
                if(editTextNumberC7.text.isNotEmpty()){
                    c7 = editTextNumberC7.text.toString().toDouble()
                }

                if(editTextNumberL1.text.isNotEmpty()){
                    l1 = editTextNumberL1.text.toString().toDouble()
                }
                if(editTextNumberL2.text.isNotEmpty()){
                    l2 = editTextNumberL2.text.toString().toDouble()
                }
                if(editTextNumberL3.text.isNotEmpty()){
                    l3 = editTextNumberL3.text.toString().toDouble()
                }
                if(editTextNumberL4.text.isNotEmpty()){
                    l4 = editTextNumberL4.text.toString().toDouble()
                }
                if(editTextNumberL5.text.isNotEmpty()){
                    l5 = editTextNumberL5.text.toString().toDouble()
                }
                if(editTextNumberL6.text.isNotEmpty()){
                    l6 = editTextNumberL6.text.toString().toDouble()
                }
                if(editTextNumberL7.text.isNotEmpty()){
                    l7 = editTextNumberL7.text.toString().toDouble()
                }
                textViewResult.text = "$electricalComponent $electricalConnection Total = ${seriesCircuit(
                    r1,r2,r3,r4,r5,r6,r7,l1,l2,l3,l4,l5,l6,l7,c1,c2,c3,c4,c5,c6,c7
                )} $dimensionRLC"


            }
            else if(
                (electricalConnection == "Parallel" &&
                        (electricalComponent == "R" || electricalComponent == "L")) ||
                (electricalConnection == "Series" && electricalComponent == "C" )
            ) {
                r1 = if(editTextNumberR1.text.isNotEmpty()){
                    editTextNumberR1.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r2 = if(editTextNumberR2.text.isNotEmpty()){
                    editTextNumberR2.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r3 = if(editTextNumberR3.text.isNotEmpty()){
                    editTextNumberR3.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r4 = if(editTextNumberR4.text.isNotEmpty()){
                    editTextNumberR4.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r5 = if(editTextNumberR5.text.isNotEmpty()){
                    editTextNumberR5.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r6 = if(editTextNumberR6.text.isNotEmpty()){
                    editTextNumberR6.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r7 = if(editTextNumberR7.text.isNotEmpty()){
                    editTextNumberR7.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }

                l1 = if(editTextNumberL1.text.isNotEmpty()){
                    editTextNumberL1.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l2 = if(editTextNumberL2.text.isNotEmpty()){
                    editTextNumberL2.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l3 = if(editTextNumberL3.text.isNotEmpty()){
                    editTextNumberL3.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l4 = if(editTextNumberL4.text.isNotEmpty()){
                    editTextNumberL4.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l5 = if(editTextNumberL5.text.isNotEmpty()){
                    editTextNumberL5.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l6 = if(editTextNumberL6.text.isNotEmpty()){
                    editTextNumberL6.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l7 = if(editTextNumberL7.text.isNotEmpty()){
                    editTextNumberL7.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }

                c1 = if(editTextNumberC1.text.isNotEmpty()){
                    editTextNumberC1.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c2 = if(editTextNumberC2.text.isNotEmpty()){
                    editTextNumberC2.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c3 = if(editTextNumberC3.text.isNotEmpty()){
                    editTextNumberC3.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c4 = if(editTextNumberC4.text.isNotEmpty()){
                    editTextNumberC4.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c5 = if(editTextNumberC5.text.isNotEmpty()){
                    editTextNumberC5.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c6 = if(editTextNumberC6.text.isNotEmpty()){
                    editTextNumberC6.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c7 = if(editTextNumberC7.text.isNotEmpty()){
                    editTextNumberC7.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }

                textViewResult.text = "$electricalComponent $electricalConnection Total = ${parallelCircuit(
                    r1,r2,r3,r4,r5,r6,r7,l1,l2,l3,l4,l5,l6,l7,c1,c2,c3,c4,c5,c6,c7
                )} $dimensionRLC"

            }
            else if (
                (electricalConnection == "Series" && (
                        electricalComponent == "RL" ||
                                electricalComponent == "RC" ||
                                electricalComponent == "LC" ||
                                electricalComponent == "RLC"))
            ) {
                if(editTextNumberR1.text.isNotEmpty()){
                    r1 = editTextNumberR1.text.toString().toDouble()
                }
                if(editTextNumberR2.text.isNotEmpty()){
                    r2 = editTextNumberR2.text.toString().toDouble()
                }
                if(editTextNumberR3.text.isNotEmpty()){
                    r3 = editTextNumberR3.text.toString().toDouble()
                }
                if(editTextNumberR4.text.isNotEmpty()){
                    r4 = editTextNumberR4.text.toString().toDouble()
                }
                if(editTextNumberR5.text.isNotEmpty()){
                    r5 = editTextNumberR5.text.toString().toDouble()
                }
                if(editTextNumberR6.text.isNotEmpty()){
                    r6 = editTextNumberR6.text.toString().toDouble()
                }
                if(editTextNumberR7.text.isNotEmpty()){
                    r7 = editTextNumberR7.text.toString().toDouble()
                }

                if(editTextNumberL1.text.isNotEmpty()){
                    l1 = editTextNumberL1.text.toString().toDouble()
                }
                if(editTextNumberL2.text.isNotEmpty()){
                    l2 = editTextNumberL2.text.toString().toDouble()
                }
                if(editTextNumberL3.text.isNotEmpty()){
                    l3 = editTextNumberL3.text.toString().toDouble()
                }
                if(editTextNumberL4.text.isNotEmpty()){
                    l4 = editTextNumberL4.text.toString().toDouble()
                }
                if(editTextNumberL5.text.isNotEmpty()){
                    l5 = editTextNumberL5.text.toString().toDouble()
                }
                if(editTextNumberL6.text.isNotEmpty()){
                    l6 = editTextNumberL6.text.toString().toDouble()
                }
                if(editTextNumberL7.text.isNotEmpty()){
                    l7 = editTextNumberL7.text.toString().toDouble()
                }

                c1 = if(editTextNumberC1.text.isNotEmpty()){
                    editTextNumberC1.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c2 = if(editTextNumberC2.text.isNotEmpty()){
                    editTextNumberC2.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c3 = if(editTextNumberC3.text.isNotEmpty()){
                    editTextNumberC3.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c4 = if(editTextNumberC4.text.isNotEmpty()){
                    editTextNumberC4.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c5 = if(editTextNumberC5.text.isNotEmpty()){
                    editTextNumberC5.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c6 = if(editTextNumberC6.text.isNotEmpty()){
                    editTextNumberC6.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                c7 = if(editTextNumberC7.text.isNotEmpty()){
                    editTextNumberC7.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }

                if(editTextNumberVAC.text.isNotEmpty()){
                    vAC = editTextNumberVAC.text.toString().toDouble()
                }
                if(editTextNumberVHz.text.isNotEmpty()){
                    vHz = editTextNumberVHz.text.toString().toDouble()
                }

                val omega: Double = 2*vHz*PI
                val zTotal: Double = impedanceRLC(
                    "Series", r1*r1, r2*r2, r3*r3,
                    r4*r4, r5*r5, r6*r6, r7*r7,
                    (omega*l1 - 1/(omega*c1)).pow(2.0),
                    (omega*l2 - 1/(omega*c2)).pow(2.0),
                    (omega*l3 - 1/(omega*c3)).pow(2.0),
                    (omega*l4 - 1/(omega*c4)).pow(2.0),
                    (omega*l5 - 1/(omega*c5)).pow(2.0),
                    (omega*l6 - 1/(omega*c6)).pow(2.0),
                    (omega*l7 - 1/(omega*c7)).pow(2.0)
                )
                val iTotal: Double = vAC/zTotal
                val xLTotal: Double = omega*l1
                val xRTotal: Double = r1
                val xCTotal: Double = 1/(omega*c1)

                var powerFactor = 0.0
                var phaseAngle = 0.0
                if(xRTotal == 0.0){
                    powerFactor = (xLTotal - xCTotal)/zTotal
                    phaseAngle = asin(powerFactor)*180/PI
                } else if (xRTotal != 0.0) {
                    powerFactor = xRTotal/zTotal
                    phaseAngle = acos(powerFactor)*180/PI
                }


                textViewResult.text = "Resistance (R) = $xRTotal Ohm" +'\n'+'\n'+
                        "Reactance L (Xl) = $xLTotal Ohm"  +'\n'+'\n'+
                        "Reactance C (Xc) = $xCTotal Ohm" +'\n'+'\n'+
                        "Impedance (Z) = $zTotal Ohm"  +'\n'+'\n'+
                        "Current Total (It) = $iTotal A" +'\n'+'\n'+
                        "Voltage R (Vr) = ${iTotal*r1} V"  +'\n'+'\n'+
                        "Voltage L (Vl) = ${iTotal*xLTotal} V"  +'\n'+'\n'+
                        "Voltage C (Vc) = ${iTotal*xCTotal} V"  +'\n'+'\n'+
                        "Power Factor = $powerFactor dimensionless"  +'\n'+'\n'+
                        "Phase Angle = $phaseAngle degree"
            }
            else if (
                (electricalConnection == "Parallel" && (
                        electricalComponent == "RL" ||
                                electricalComponent == "RC" ||
                                electricalComponent == "LC" ||
                                electricalComponent == "RLC"))
            ) {
                if(editTextNumberR1.text.isNotEmpty()){
                    r1 = editTextNumberR1.text.toString().toDouble()
                }
                r1 = if(editTextNumberR1.text.isNotEmpty()){
                    editTextNumberR1.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r2 = if(editTextNumberR2.text.isNotEmpty()){
                    editTextNumberR2.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r3 = if(editTextNumberR3.text.isNotEmpty()){
                    editTextNumberR3.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r4 = if(editTextNumberR4.text.isNotEmpty()){
                    editTextNumberR4.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r5 = if(editTextNumberR5.text.isNotEmpty()){
                    editTextNumberR5.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r6 = if(editTextNumberR6.text.isNotEmpty()){
                    editTextNumberR6.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                r7 = if(editTextNumberR7.text.isNotEmpty()){
                    editTextNumberR7.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }

                l1 = if(editTextNumberL1.text.isNotEmpty()){
                    editTextNumberL1.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l2 = if(editTextNumberL2.text.isNotEmpty()){
                    editTextNumberL2.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l3 = if(editTextNumberL3.text.isNotEmpty()){
                    editTextNumberL3.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l4 = if(editTextNumberL4.text.isNotEmpty()){
                    editTextNumberL4.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l5 = if(editTextNumberL5.text.isNotEmpty()){
                    editTextNumberL5.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l6 = if(editTextNumberL6.text.isNotEmpty()){
                    editTextNumberL6.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }
                l7 = if(editTextNumberL7.text.isNotEmpty()){
                    editTextNumberL7.text.toString().toDouble()
                } else {
                    Double.POSITIVE_INFINITY
                }

                if(editTextNumberC1.text.isNotEmpty()){
                    c1 = editTextNumberC1.text.toString().toDouble()
                }
                if(editTextNumberC2.text.isNotEmpty()){
                    c2 = editTextNumberC2.text.toString().toDouble()
                }
                if(editTextNumberC3.text.isNotEmpty()){
                    c3 = editTextNumberC3.text.toString().toDouble()
                }
                if(editTextNumberC4.text.isNotEmpty()){
                    c4 = editTextNumberC4.text.toString().toDouble()
                }
                if(editTextNumberC5.text.isNotEmpty()){
                    c5 = editTextNumberC5.text.toString().toDouble()
                }
                if(editTextNumberC6.text.isNotEmpty()){
                    c6 = editTextNumberC6.text.toString().toDouble()
                }
                if(editTextNumberC7.text.isNotEmpty()){
                    c7 = editTextNumberC7.text.toString().toDouble()
                }

                if(editTextNumberVAC.text.isNotEmpty()){
                    vAC = editTextNumberVAC.text.toString().toDouble()
                }
                if(editTextNumberVHz.text.isNotEmpty()){
                    vHz = editTextNumberVHz.text.toString().toDouble()
                }

                val omega: Double = 2*vHz*PI
                val zTotal: Double = impedanceRLC(
                    "Parallel",
                    (1/r1).pow(2.0),
                    (1/r2).pow(2.0),
                    (1/r3).pow(2.0),
                    (1/r4).pow(2.0),
                    (1/r5).pow(2.0),
                    (1/r6).pow(2.0),
                    (1/r7).pow(2.0),
                    (omega*c1 - 1/(omega*l1)).pow(2.0),
                    (omega*c2 - 1/(omega*l2)).pow(2.0),
                    (omega*c3 - 1/(omega*l3)).pow(2.0),
                    (omega*c4 - 1/(omega*l4)).pow(2.0),
                    (omega*c5 - 1/(omega*l5)).pow(2.0),
                    (omega*c6 - 1/(omega*l6)).pow(2.0),
                    (omega*c7 - 1/(omega*l7)).pow(2.0)
                )
                //val iTotal: Double = vAC/zTotal
                val xLTotal: Double = omega*l1
                val xRTotal: Double = r1
                val xCTotal: Double = 1/(omega*c1)

                val iRTotal = vAC/r1
                val iLTotal = vAC/xLTotal
                val iCTotal = vAC/xCTotal

                val iTotal = sqrt(iRTotal.pow(2.0) + (iLTotal - iCTotal).pow(2.0))

                val conductanceG = 1/xRTotal
                val inductiveSusceptanceBl = 1/xLTotal
                val capacitiveSusceptanceBc = 1/xCTotal
                val admittanceY = 1/zTotal


                val powerFactor: Double = conductanceG/admittanceY
                val phaseAngle: Double = acos(powerFactor)*180/PI


                textViewResult.text = "Resistance = $xRTotal Ohm" +'\n'+'\n'+
                        "Reactance L (Xl) = $xLTotal Ohm"  +'\n'+'\n'+
                        "Reactance C (Xc) = $xCTotal Ohm" +'\n'+'\n'+
                        "Impedance (Z) = $zTotal Ohm"  +'\n'+'\n'+
                        "Current R (Ir) = $iRTotal A"  +'\n'+'\n'+
                        "Current L (Il) = $iLTotal A"  +'\n'+'\n'+
                        "Current C (Ic) = $iCTotal A"  +'\n'+'\n'+
                        "Current Total (It) = $iTotal A" +'\n'+'\n'+
                        "Susceptance L (Bl) = $inductiveSusceptanceBl anti Ohm" +
                        '\n'+'\n'+
                        "Conductance (G) = $conductanceG anti Ohm"  +'\n'+'\n'+
                        "Susceptance C (Bc) = $capacitiveSusceptanceBc anti Ohm" +
                        '\n'+'\n'+
                        "Admittance (Y) = $admittanceY anti Ohm"  +'\n'+'\n'+
                        "Power Factor = $powerFactor dimensionless" +'\n'+'\n'+
                        "Phase Angle = $phaseAngle degree"
            }
        }

        textViewResult.setOnLongClickListener{
            clipData = ClipData.newPlainText("text", textViewResult.text)
            clipData?.let { it1 -> clipboardManager?.setPrimaryClip(it1) }

            Toast.makeText(this, "Your Result Copied to Clipboard.", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun impedanceRLC(
        str: String,
        xR1: Double,
        xR2: Double,
        xR3: Double,
        xR4: Double,
        xR5: Double,
        xR6: Double,
        xR7: Double,
        xLC1: Double,
        xLC2: Double,
        xLC3: Double,
        xLC4: Double,
        xLC5: Double,
        xLC6: Double,
        xLC7: Double
    ): Double {

        var resultSeriesRLC = 0.0
        if(str == "Series"){
            resultSeriesRLC = sqrt(seriesCircuit(xR1, xR2, xR3, xR4, xR5, xR6, xR7, xLC1, xLC2, xLC3, xLC4, xLC5, xLC6, xLC7, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0))
        } else if (str == "Parallel"){
            resultSeriesRLC = 1/sqrt(seriesCircuit(xR1, xR2, xR3, xR4, xR5, xR6, xR7, xLC1, xLC2, xLC3, xLC4, xLC5, xLC6, xLC7, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0))
        }
        return resultSeriesRLC
    }

    private fun seriesCircuit(
        R1: Double,
        R2: Double,
        R3: Double,
        R4: Double,
        R5: Double,
        R6: Double,
        R7: Double,
        L1: Double,
        L2: Double,
        L3: Double,
        L4: Double,
        L5: Double,
        L6: Double,
        L7: Double,
        C1: Double,
        C2: Double,
        C3: Double,
        C4: Double,
        C5: Double,
        C6: Double,
        C7: Double
    ): Double{
        return R1 + R2 + R3 + R4 + R5 + R6 + R7 +
                C1 + C2 + C3 + C4 + C5 + C6 + C7 +
                L1 + L2 + L3 + L4 + L5 + L6 + L7
    }
    private fun parallelCircuit(
        R1: Double,
        R2: Double,
        R3: Double,
        R4: Double,
        R5: Double,
        R6: Double,
        R7: Double,
        C1: Double,
        C2: Double,
        C3: Double,
        C4: Double,
        C5: Double,
        C6: Double,
        C7: Double,
        L1: Double,
        L2: Double,
        L3: Double,
        L4: Double,
        L5: Double,
        L6: Double,
        L7: Double
    ): Double{
        return 1/(1/(R1) + 1/(R2) + 1/(R3) + 1/(R4) + 1/(R5) + 1/(R6) + 1/(R7) +
                1/(C1) + 1/(C2) + 1/(C3) + 1/(C4) + 1/(C5) + 1/(C6) + 1/(C7) +
                1/(L1) + 1/(L2) + 1/(L3) + 1/(L4) + 1/(L5) + 1/(L6) + 1/(L7))
    }



    //OPTION MENU (TOP RIGHT)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        return true
    }


    //OPTION MENU (TOP RIGHT)
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }


    //OPTION MENU (TOP RIGHT)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Handle presses on the action bar menu items
        return when (item.itemId) {
            R.id.about -> {
                val intentAboutActivity =
                    Intent(this, AboutActivity::class.java)
                startActivity(intentAboutActivity)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }

    override fun onBackPressed() {
        val intentMainActivity =
            Intent(this, MainActivity::class.java)
        startActivity(intentMainActivity)
        finish()

    }
}