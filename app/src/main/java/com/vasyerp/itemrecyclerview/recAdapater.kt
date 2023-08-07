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


class recAdapater(var context: Context,
    var List: ArrayList<PriceDto>,
    var listner: SendData
) :
    RecyclerView.Adapter<recAdapater.RecViewHolder>() {

    class RecViewHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview) {

        val Qt = itemView.findViewById<EditText>(R.id.etQty)
        val pp = itemView.findViewById<EditText>(R.id.etPrice)
        val tp = itemView.findViewById<TextView>(R.id.etTp)
        val product = itemView.findViewById<TextView>(R.id.PdtName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RecViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(
        holder: RecViewHolder,
        position: Int
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
                    updateTotalPrice(item, holder)


/*
                    val quantityStr = p0.toString()
                    if (quantityStr.isNotEmpty()) {
                        val quantity = quantityStr.toInt()
                        item.quantity = quantity
                        updateTotalPrice(item, holder)
                        p0.let {
                            listner.onQuantityChanged(holder.adapterPosition, quantity)

                        }
                    }
*/

                    /* if (!p0.isNullOrEmpty()) {
                         val quantityStr = p0.toString()
                         if (quantityStr.isNotEmpty()) {
                             val quantity = quantityStr.toInt()
                             item.quantity = quantity
                             updateTotalPrice(item, holder)
                             listner.onQuantityChanged(holder.adapterPosition, quantity*//*, item.price*//*)
*/
//                    p0.let {
//                        listner.onQuantityChanged(
//                            holder.adapterPosition
//                        )
//                    }
//                } else {
//                    listner.onQuantityChanged(
//                        holder.adapterPosition, item.quantity
//                    )


                    /*  val quantityStr = p0.toString()
                      if (quantityStr.isNotEmpty()) {
                          val quantity = quantityStr.toInt()
                          item.quantity = quantity
                          updateTotalPrice(item, holder)
                          listner.onQuantityChanged(holder.adapterPosition, quantity, item.price)
*/
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        holder.pp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!p0.isNullOrEmpty()) {
                    listner.onPriceChanged(holder.adapterPosition, p0.toString().toDouble())
                    updateTotalPrice(item, holder)

                    /*
                    val priceStr = p0.toString()
                    if (priceStr.isNotEmpty()) {
                        val price = priceStr.toDouble()
                        item.price = price
                        updateTotalPrice(item, holder)
                        p0.let {


                        }
                    }*/
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        fun updateList(newPriceList: List<PriceDto>) {
            List.clear()
            List.addAll(newPriceList)
            notifyDataSetChanged()
            listner.onListUpdated() // Call the interface method when the list is updated
        }
    }
    fun updatePriceList(newPriceList: List<PriceDto>) {
        List.addAll(newPriceList)
        notifyDataSetChanged()
    }

    private fun updateTotalPrice(item: PriceDto, holder: RecViewHolder) {
        holder.tp.setText((item.quantity * item.price).toString())
    }

    interface SendData {
        fun onQuantityChanged(position: Int, quantity: Int)
        fun onPriceChanged(position: Int, price: Double)
        fun onListUpdated()

    }

}
