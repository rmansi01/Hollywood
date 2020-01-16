package net.azarquiel.hollywood.adapters


import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rowcategoria.view.*
import kotlinx.android.synthetic.main.rowproducto.view.*
import net.azarquiel.hollywood.model.Categoria
import net.azarquiel.hollywood.model.Producto
import org.jetbrains.anko.image


/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterProductos(val context: Context,
                       val layout: Int
) : RecyclerView.Adapter<AdapterProductos.ViewHolder>() {

    private var dataList: List<Producto> = emptyList()

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

    internal fun setProductos(productos: List<Producto>) {
        this.dataList = productos
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        //private val meses = arrayOf("Enero","Febrero","Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
        fun bind(dataItem: Producto ){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            itemView.tvnombreproducto.text = dataItem.titulo

            // Empleamos Picasso para añadir las imagenes de los productos
            var foto = dataItem.imagen
            Picasso.get().load(foto).into(itemView.ivProductorow)

            itemView.tag = dataItem
        }

    }
}