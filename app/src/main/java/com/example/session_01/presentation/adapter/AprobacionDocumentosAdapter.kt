package com.example.session_01.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.session_01.R
import com.example.session_01.domain.entity.AprobacionDocumento

class AprobacionDocumentosAdapter (
    var items: MutableList<AprobacionDocumento>,
    var iCard: ICard) : RecyclerView.Adapter<AprobacionDocumentosAdapter.ViewHolder>() {

    interface ICard{
        fun onCardClick(item : AprobacionDocumento)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener {
        val tvNumeroDocumento: TextView = itemView.findViewById(R.id.item_aprobacion_documentos_tvNumero)
        val tvEstadoDocumento: TextView = itemView.findViewById(R.id.item_aprobacion_documentos_tvEstado)
        val tvTipoDocumento: TextView = itemView.findViewById(R.id.item_aprobacion_documentos_tvTipoDocumento)
        val tvFechaDocumento: TextView = itemView.findViewById(R.id.item_aprobacion_documentos_tvFecha)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            iCard.onCardClick(items[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): AprobacionDocumentosAdapter.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_aprobacion_documentos,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AprobacionDocumentosAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.tvNumeroDocumento.text = item.NumeroDocumento
        holder.tvEstadoDocumento.text = item.EstadoItem
        holder.tvTipoDocumento.text = item.TipoDocumento
        holder.tvFechaDocumento.text = item.FechaRegistro
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newItems : List<AprobacionDocumento>){
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }
}