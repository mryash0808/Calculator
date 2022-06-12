package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var data : String
    lateinit var input : String
    var l1 = arrayListOf<datamodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"0"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn1.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"1"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn2.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"2"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"        }
        binding.btn3.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"3"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn4.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"4"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn5.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"5"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn6.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"6"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn7.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"7"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn8.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"8"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }
        binding.btn9.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data"+"9"
            val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            binding.inputoutput.text = "$result"
        }



        binding.btnMinus.setOnClickListener{
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data - "
        }
        binding.btnPlus.setOnClickListener{
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data + "
        }
        binding.btnMulti.setOnClickListener{
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data * "
        }
        binding.btnModule.setOnClickListener{
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data % "
        }
        binding.btnDivide.setOnClickListener{
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data / "
        }
        binding.btnAc.setOnClickListener {
            binding.inputtext.text = ""
            binding.inputoutput.text = ""
        }
        binding.btnDot.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.text = "$data."
        }

        binding.btnEqual.setOnClickListener {
             input = binding.inputtext.text.toString()
            val expression = ExpressionBuilder(input).build()
            val result = expression.evaluate()
            binding.inputoutput.text = ""
            binding.inputtext.text = "$result"

            var db = dbhelper(this)
            db.insertdata(input,result)
        }
        binding.history.setOnClickListener {
            var db = dbhelper(this)
            var l1 = db.readdata()
           val dialogue = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottomsheetdialogue,null)
            val recy =  view.findViewById<RecyclerView>(R.id.reccy)
            val clr = view.findViewById<Button>(R.id.cler)

            clr.setOnClickListener{
                dialogue.dismiss()
            }

            val adape = Adapter(this,l1)
            val dm = LinearLayoutManager(this)
            recy.layoutManager = dm
            recy.adapter = adape

            dialogue.setContentView(view)
            dialogue.setCancelable(false)
            dialogue.show()


        }

    }
}