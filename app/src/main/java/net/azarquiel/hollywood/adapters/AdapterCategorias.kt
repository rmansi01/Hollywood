package net.azarquiel.hollywood.adapters


import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rowcategoria.view.*
import net.azarquiel.hollywood.model.Categoria


/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterCategorias(val context: Context,
                    val layout: Int
) : RecyclerView.Adapter<AdapterCategorias.ViewHolder>() {

    private var dataList: List<Categoria> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setCategorias(categorias: List<Categoria>) {
        this.dataList = categorias
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        private val meses = arrayOf("Enero","Febrero","Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
        fun bind(dataItem: Categoria ){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            itemView.tvnombre.text = dataItem.nombre
            itemView.tvdescripcion.text = Html.fromHtml(dataItem.descripcion)

            itemView.tag = dataItem
        }

    }
}