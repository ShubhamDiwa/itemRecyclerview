package com.vasyerp.itemrecyclerview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vasyerp.itemrecyclerview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var QTY: Int = 0
    var Price: Int = 0
    var TP: Int? = 0

    private val binding: ActivityMain2Binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)





        binding.etQty.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculatePrice()

            }

            override fun afterTextChanged(p0: Editable?) {
//                if (p0.isNullOrEmpty()) {
//                    QTY = p0.toString().toInt()
//                    Log.e("TAG", "afterTextChanged+qty:$QTY ")
//                }
//                CalculatePrice(QTY, 0)
            }
        })

        binding.etPrice.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculatePrice()

            }

            override fun afterTextChanged(p0: Editable?) {
//                if (p0.isNullOrEmpty()) {
//                    Price = p0.toString().toInt()
//                    Log.e("TAG", "afterTextChanged+price:$Price ")
//                }
//                CalculatePrice(0, Price)
            }
        })


//
//        var QTY = binding.etQty.text.toString()
//        var Price = binding.etPrice.text.toString()
//
//        var TP :Int= QTY.toString().toInt() * Price.toString().toInt()
//        binding.etTp.setText(TP.toString())
//        val price = binding.etPrice.text.toString().toInt()
//        val qty = binding.etQty.text.toString().toInt()

//         binding.etPrice.setText("10")


//        binding.etPrice.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                if (!p0.isNullOrEmpty()){
//                    val qt=binding.etQty.text.toString().toInt()
//                    val pp=binding.etPrice.text.toString().toInt()
//                    val tt=qt*pp
//
//                    binding.etTp.setText(tt.toString())
//                }
//
//
//            }
//        })
//
//


//
//        if (binding.etQty.isFocused){
//            binding.etQty.addTextChangedListener(object :TextWatcher{
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                }
//
//                override fun afterTextChanged(p0: Editable?) {
//                    if (!p0.toString().isNullOrEmpty()){
//                        if (binding.etPrice.text.toString().isNullOrEmpty()){
//                            val pp=binding.etPrice.text.toString().toInt() * p0.toString().toInt()
//                            binding.etTp.setText(pp.toString())
//                        }
//
//
//                    }
//
//
//                }
//            })
//
//        }else if(binding.etPrice.isFocused){
//            binding.etPrice.addTextChangedListener(object :TextWatcher{
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                }
//
//                override fun afterTextChanged(p0: Editable?) {
//                    if (!p0.toString().isNullOrEmpty()){
//                        val tp = binding.etPrice.text.toString().toInt() * p0.toString().toInt()
//                        Log.e("TAG", "afterTextChanged: $tp", )
//                        binding.etTp.setText(tp.toString())
//
//                    }
//
//                }
//            })
//
//
//        }else{
//            binding.etPrice.addTextChangedListener(object :TextWatcher{
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                }
//
//                override fun afterTextChanged(p0: Editable?) {
//                    p0.toString()?.let {
//                        val tp = binding.etQty.text.toString().toInt() * p0.toString().toInt()
//                        Log.e("TAG", "afterTextChanged: $tp", )
//                        binding.etTp.setText(tp.toString())
//
//                    }?.run {
//                        val tp = binding.etQty.text.toString().toInt() * p0.toString().toInt()
//                        Log.e("TAG", "afterTextChanged: $tp", )
//                        binding.etTp.setText(tp.toString())
//                    }
//
//
//                }
//            })
//
//
//        }
//
//
//        calculate(50,50)
//        val qt = binding.etQty.text.toString()
//        val qtemp = qt.toIntOrNull()
//        Log.e("TAG", "onCreate:$qtemp ")

//        binding.etPrice.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//            override fun afterTextChanged(p0: Editable?) {
//                if (!p0.isNullOrEmpty()){
//                    val tp = binding.etQty.text.toString().toInt() * p0.toString().toInt()
//                    Log.e("TAG", "afterTextChanged: $tp", )
//                    binding.etTp.setText(tp.toString())
//                }
//
//                }
//        })
//        binding.etPrice.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
////                if (!p0.isNullOrEmpty()) {
////                    var pt = p0.toString()
////                    var Ptemp = pt.toInt()
////                    Log.e("TAG", "afterTextChanged:$Ptemp")
////
////                }
//            }
//
//
//        })


//        binding.etQty.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
////                if (p0.toString().isNullOrEmpty()){
////                    val tp = p0.toString().toInt() * binding.etTp.toString().toInt()
////                    Log.e("TAG", "afterTextChanged: $tp", )
////                    binding.etTp.setText(tp.toString())
////
////                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                if ( p0.isNullOrEmpty()){
//                    val tp = p0.toString().toInt() * binding.etTp.toString().toInt()
//                    Log.e("TAG", "afterTextChanged: $tp", )
//                    binding.etTp.setText(tp.toString())
//
//                }
//
//
//            }
//        })

//        val tp = qty * price
//        Log.e("TAG", "onCreate: $tp", )

//        binding.etTp.setText(tp.toString())

    }

    private fun calculatePrice() {
        val quantityStr = binding.etQty.text.toString()
        val priceStr = binding.etPrice.text.toString()

        if (quantityStr.isNotEmpty() && priceStr.isNotEmpty()) {
            val quantity = quantityStr.toInt()
            val price = priceStr.toDouble()
            val totalPrice = quantity * price
            binding.etTp.setText(totalPrice.toString())
        } else {
            binding.etTp.text="10 "
        }
    }

    }




//    private fun calculate(qtemp: Int, p0: Int) {
//        val tp=qtemp*p0
//
//        binding.etPrice.setText(tp)
//        Log.e("TAG", "calculate: $tp", )
//
//
//    }


//
//    private fun updateOrderValue() {
//
//        val qt=binding.etQty.text.toString().toInt()
//        val pp=binding.etPrice.text.toString().toInt()
//        val tt=qt*pp
//
//        binding.etTp.setText(tt.toString())
//
//    }


