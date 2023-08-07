package com.vasyerp.itemrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vasyerp.itemrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: recAdapater
    val priceList = ArrayList<PriceDto>()

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
        adapter = recAdapater(this,priceList, object : recAdapater.SendData {

            override fun onQuantityChanged(position: Int, quantity: Int) {
                priceList[position].quantity = quantity
                Log.e("TAG", "onQuantityChanged:$quantity ")
                adapter.updatePriceList(priceList)
                netSum()
            }

            override fun onPriceChanged(position: Int, price: Double) {
                priceList[position].price = price
                Log.e("TAG", "onPriceChanged:$price ")
                adapter.updatePriceList(priceList)
            }

            override fun onListUpdated() {
                netSum()

            }
        })

//        netSum()

        binding.Mainrec.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun netSum() {
//        val sum=priceList.sumOf {itp->
//            itp.net?:0.0
//            Log.e("TAG", "netSum:${itp.net} ", )
//        }
        var sum: Double = 0.0
        for (i in 0..priceList.size - 1) {
            sum = sum + (priceList[i].net).toString().toDouble()
            Log.e("TAG", "netSum==:$sum ")
        }
        var s: String = sum.toString()
        binding.tvNet.setText(s)

//                var sum: Double = 0.0
//                for (i in priceList) {
//                    sum += i.net!!.toDouble()
//                    Log.e("HHH", "netSum:$sum ", )
//                }
//                var s: String = sum.toString()
//                binding.tvNet.setText(s)

    }


    /*
        override fun onQuantityChanged(position: Int, quantity: Int*/
    /*, price: Double*//*
) {

        Log.e("TAg", "onQuantityChanged==quant:${item.quantity} ")
        //item.price = price
        Log.e("TAg", "onQuantityChanged==price:${item.price} ")
//        netSum()

    }
*/

}