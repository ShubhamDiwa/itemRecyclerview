package com.vasyerp.itemrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vasyerp.itemrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: recAdapater
    val priceList = ArrayList<PriceDto>()
    val updatePriceList = ArrayList<PriceDto>()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))
        priceList.add(PriceDto("balaji wafers", 10.0, 2))
        priceList.add(PriceDto("kitkat", 20.0, 4))
        priceList.add(PriceDto("Five star", 5.0, 6))



        adapter = recAdapater(this, priceList, object : recAdapater.SendData {

            override fun onQuantityChanged(position: Int, quantity: Int) {
                priceList[position].quantity = quantity
                Log.e("TAG", "onQuantityChanged:$quantity ")
//                adapter.getLatestList()
                /*
                netSum()
*/
            }

            override fun onPriceChanged(position: Int, price: Double) {
                priceList[position].price = price
//                adapter.getLatestList()
                Log.e("TAG", "onPriceChanged:$price ")
                /*
                netSum()
*/

            }

            override fun sendTotal(position: Int, total: Double) {
                priceList[position].net=total
                calculate()

//              var totalsum =+  total
/*
                calculate(total)
*/
                Log.e("TAG", "sendTotalgggg:${position}$total",)
            }

        })


        binding.Mainrec.adapter = adapter
//        adapter.notifyDataSetChanged()
    }

    private fun calculate() {
       val finalTotal = priceList.sumOf { it ->
           it.net ?: 0.0
       }
        binding.tvNet.setText(finalTotal.toString())
    }

    /* private fun calculate(total: Double) {
         val sum = total.sumOf { itp ->
             itp.net ?: 0.0
             Log.e("TAG", "netSum0000:${itp.net} ",)



         }*/

//        private fun netSum() {
////        val sum=priceList.sumOf {itp->
////            itp.net?:0.0
////            Log.e("TAG", "netSum:${itp.net} ", )
////        }
//            var sum: Double = 0.0
//            for (i in 0..priceList.size - 1) {
//                sum = sum + (priceList[i].net).toString().toDouble()
//                Log.e("TAG", "netSum==:$sum ")
//            }
//            var s: String = sum.toString()
//            binding.tvNet.setText(s)
//
//        }


    }

