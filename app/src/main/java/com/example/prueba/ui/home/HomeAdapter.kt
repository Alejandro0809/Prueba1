package com.example.prueba.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.R

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {



    private val kode = arrayOf(
        "000001",
        "000002",
        "000003",
        "000004",
        "000005",
    )

    private val name = arrayOf(
        "Flamenco",
        "Torero",
        "Payaso",
        "Ratón",
        "Bruja"
    )

    private val description = arrayOf(
        "Talla: XS, S, M Color: Rojo",
        "Talla: XS Color: Negro",
        "Talla: M Color: Unicolor",
        "Talla: XS, S, M Color: Gris",
        "Talla: S Color: Purpura ¡Oferta!",
    )

    private val unidades = arrayOf(
        "0u",
        "1u",
        "1u",
        "0u",
        "4u"
    )

    private val precio = arrayOf(
        "9,99",
        "15,80",
        "20,00",
        "14,50",
        "8,00",

        )

    private val foto = arrayOf(
        R.drawable.ic_baseline_filter_24,
        R.drawable.ic_baseline_filter_none_24,
        R.drawable.ic_baseline_filter_24,
        R.drawable.ic_baseline_filter_none_24,
        R.drawable.ic_baseline_filter_24,


        )

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var itemcode: TextView
        var itemnamee : TextView
        var itemdescription : TextView
        var itemunit : TextView
        var itemprecio : TextView
        var itempic : ImageView

        init {

            itemcode = itemView.findViewById(R.id.codArt)
            itemnamee = itemView.findViewById(R.id.nameArt)
            itemdescription = itemView.findViewById(R.id.descriptionArt)
            itemunit = itemView.findViewById(R.id.uniArt)
            itemprecio = itemView.findViewById(R.id.priceArt)
            itempic = itemView.findViewById(R.id.fotoArt)


        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i : Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.listelement, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemcode.text = kode[i]
        viewHolder.itemnamee.text = name[i]
        viewHolder.itemdescription.text = description[i]
        viewHolder.itemunit.text = unidades[i]
        viewHolder.itemprecio.text = precio[i]
        viewHolder.itempic.setImageResource(foto[i])



    }

    override fun getItemCount(): Int {
        return kode.size
    }


}

