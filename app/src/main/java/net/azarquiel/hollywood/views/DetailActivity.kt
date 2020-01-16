package net.azarquiel.hollywood.views

import android.os.Bundle
import android.text.Html
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import net.azarquiel.hollywood.R

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.rowproducto.view.*
import net.azarquiel.hollywood.model.Producto
import net.azarquiel.hollywood.viewmodel.ProductoViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailActivity : AppCompatActivity() {

    private lateinit var productoViewModel: ProductoViewModel
    private lateinit var producto: Producto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        producto = intent.getSerializableExtra("producto") as Producto
        getData()



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun getData() {
        productoViewModel = ViewModelProviders.of(this).get(ProductoViewModel::class.java)
        doAsync {
            producto = productoViewModel.getProductoById(producto.id!!)
            uiThread {
              tvtituloproducto.text = producto.titulo
                tvbodyproducto.text = Html.fromHtml(producto.body)
                var foto = producto.imagen
                Picasso.get().load(foto).into(ivproductodetail)
                tvsumary.text = Html.fromHtml(producto.sumario)
            }
        }
    }

}
