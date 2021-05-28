package com.example.calculator
//
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding

import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main)



          binding.tvOne.setOnClickListener {
            evaluateExpression("1", clear = true)

        }
        binding.tvTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

    binding.tvThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
    binding.tvFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

    binding.tvFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

    binding.tvSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

    binding.tvSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

    binding.tvEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

    binding.tvNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

    binding.tvZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

    binding.tvPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        binding.tvMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        binding.tvMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        binding.tvDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        binding.tvDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        binding.tvClear.setOnClickListener {
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }
        binding.tvEquals.setOnClickListener {
            val text = binding.tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                binding.tvResult.text = longResult.toString()
            } else {
                binding.tvResult.text = result.toString()
            }
        }
        binding.tvBack.setOnClickListener {
            val text = binding.tvExpression.text.toString()
            if (text.isNotEmpty()) {
                binding.tvExpression.text = text.drop(1)
            } else {

                binding.tvResult.text = ""
            }
        }

    }

    private fun evaluateExpression(string: String, clear: Boolean) {

        if (clear) {
            binding.tvResult.text =  ""
            binding.tvExpression.append(string)
        } else {
            binding.tvExpression.append(binding.tvResult.text)
            binding.tvExpression.append(string)
            binding.tvResult.text = ""
        }
    }
}