package com.vasyerp.itemrecyclerview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class recAdapater(
    var context: Context, var List: ArrayList<PriceDto>, var listner: SendData
) : RecyclerView.Adapter<recAdapater.RecViewHolder>() {

//    var valChange: Boolean = false

    class RecViewHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview) {

        val Qt = itemView.findViewById<EditText>(R.id.etQty)
        val pp = itemView.findViewById<EditText>(R.id.etPrice)
        val tp = itemView.findViewById<TextView>(R.id.etTp)
        val product = itemView.findViewById<TextView>(R.id.PdtName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return RecViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(
        holder: RecViewHolder, position: Int
    ) {
        val item = List[position]
        holder.Qt.setText(item.quantity.toString())
        holder.pp.setText(item.price.toString())
        holder.product.setText(item.productName)
        holder.tp.setText((item.quantity * item.price).toString())

        holder.Qt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    if (!p0.isNullOrEmpty()) {
                        listner.onQuantityChanged(holder.adapterPosition, p0.toString().toInt())
//                        updateTotalPrice(item, holder)
                    }
            }

            override fun afterTextChanged(p0: Editable?) {
                var price=holder.pp.text.toString()
                if (!p0.isNullOrEmpty()){
                    var qt=p0.toString().toInt()
                    netPrice(qt,price,holder)
                }


            }
        })

        holder.pp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    if (!p0.isNullOrEmpty()) {
                        listner.onPriceChanged(holder.adapterPosition,p0.toString().toDouble())
//                        updateTotalPrice(item,holder)
                    }
            }

            override fun afterTextChanged(p0: Editable?) {

                var qt=holder.Qt.text.toString().toInt()
                if (!p0.toString().isNullOrEmpty()){
                    var price=p0.toString()
                    netPrice(qt,price,holder)

                }





            }
        })


    }

    private fun netPrice(qt: Int, price: String, holder: recAdapater.RecViewHolder) {
        var netSum= qt.toInt() * price.toDouble()
        listner.sendTotal(holder.adapterPosition,netSum)
        holder.tp.setText(netSum.toString())


    }


    private fun updateTotalPrice(item: PriceDto, holder: RecViewHolder) {
        var net = (item.quantity * item.price)
//        List[holder.adapterPosition].net = net // yaha pe humne net value ka position bhej aur update kr dia
        holder.tp.setText(net.toString())
//        listner.sendTotal(holder.adapterPosition,net)

    }


    interface SendData {
        fun onQuantityChanged(position: Int, quantity: Int)
        fun onPriceChanged(position: Int, price: Double)
        fun sendTotal(position: Int,total:Double)

    }
//    fun getLatestList(): List<PriceDto> {
//        return List
//    }
//

}
