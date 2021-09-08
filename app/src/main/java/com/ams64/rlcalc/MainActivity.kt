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


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button Section
        val buttonR: Button = findViewById(R.id.buttonR)
        val buttonL: Button = findViewById(R.id.buttonL)
        val buttonC: Button = findViewById(R.id.buttonC)
        val buttonRL: Button = findViewById(R.id.buttonRL)
        val buttonRC: Button = findViewById(R.id.buttonRC)
        val buttonLC: Button = findViewById(R.id.buttonLC)
        val buttonRLC: Button = findViewById(R.id.buttonRLC)

        //Radio Button Section
        val radioGroupElectricalConnection: RadioGroup = findViewById(R.id.radioGroupElectricalConnection)

        buttonR.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "R")
            startActivity(intentRLCActivity)
            finish()
        }
        buttonL.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "L")
            startActivity(intentRLCActivity)
            finish()
        }
        buttonC.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "C")
            startActivity(intentRLCActivity)
            finish()
        }
        buttonRL.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "RL")
            startActivity(intentRLCActivity)
            finish()
        }
        buttonRC.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "RC")
            startActivity(intentRLCActivity)
            finish()
        }
        buttonLC.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "LC")
            startActivity(intentRLCActivity)
            finish()
        }
        buttonRLC.setOnClickListener{
            val radioButtonElectricalConnection: RadioButton = findViewById(radioGroupElectricalConnection.checkedRadioButtonId)
            val intentRLCActivity = Intent(this, RLCActivity::class.java)
            intentRLCActivity.putExtra("Electrical Connection", radioButtonElectricalConnection.text.toString())
            intentRLCActivity.putExtra("Electrical Component", "RLC")
            startActivity(intentRLCActivity)
            finish()
        }

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
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setCancelable(false)

        builder.setMessage("Do you want to Exit?")
        builder.setPositiveButton("Yes") { _, _ ->
            finish()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.cancel()
        }
        val alert: AlertDialog = builder.create()
        alert.show()
    }
}