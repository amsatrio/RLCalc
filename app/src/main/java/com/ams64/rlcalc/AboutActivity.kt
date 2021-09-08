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

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Load Preferences for Theme
        //fetch data from shared preferences
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        // set your custom theme here before setting layout
        super.setTheme(sharedPreferences.getInt("theme",R.style.Theme_RLCalc))


        //BACK BUTTON
        // showing the back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_about)
        val textViewAbout: TextView = findViewById(R.id.textViewAbout)
        textViewAbout.text = HtmlCompat.fromHtml(
            "<h4 style=\"text-align: left;\">" +
                    "${getString(R.string.string_version)}</h4>" +
                    "${packageManager.getPackageInfo(packageName, 0).versionName}<br/>" +

//                    "&nbsp;<h4 style=\"text-align: left;\">" +
//                    "${getString(R.string.string_author)}</h4>" +
//                    "AMS64<br/>" +

                    "&nbsp;<h4 style=\"text-align: left;\">" +
                    "${getString(R.string.string_privacy_policy)}</h4>" +
                    "<a href=https://ams64pro.blogspot.com/p/privacy-policy-foss-app.html>" +
                    "${getString(R.string.string_privacy_policy)}</a><br/>" +

                    "&nbsp;<h4 style=\"text-align: left;\">" +
                    "${getString(R.string.string_open_source)}</h4>${getString(R.string.string_source_program)}&nbsp;" +
                    "<a href=https://github.com/amsatrio/PembangkitSandi rel target=_blank>Github</a>",0)
        textViewAbout.movementMethod = LinkMovementMethod.getInstance()
    }


    //OPTION MENU (TOP RIGHT)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        return when (item.itemId) {

            //BUTTON BACK
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}