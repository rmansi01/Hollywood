package net.azarquiel.hollywood.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_productos.*
import kotlinx.android.synthetic.main.content_productos.*
import net.azarquiel.hollywood.R
import net.azarquiel.hollywood.adapters.AdapterProductos
import net.azarquiel.hollywood.model.Categoria
import net.azarquiel.hollywood.model.Producto
import net.azarquiel.hollywood.viewmodel.ProductoViewModel

class ProductosActivity : AppCompatActivity() {

    private lateinit var categoria: Categoria
    private lateinit var adapter: AdapterProductos
    private lateinit var productoViewModel: ProductoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        setSupportActionBar(toolbar)
        categoria = intent.getSerializableExtra("categoria") as Categoria


        initRV()
        productoViewModel = ViewModelProviders.of(this).get(ProductoViewModel::class.java)




        productoViewModel.getProductos(categoria.id!!).observe(this, Observer { productos -> productos?.let{adapter.setProductos(it)} })
        fab.setOnClickListener { view ->
            mostrarFavoritos()
        }
    }

    private fun mostrarFavoritos() {
        val intentFavoritos = Intent(this, FavoritosActivity::class.java)
        startActivity(intentFavoritos)
    }



    private fun initRV() {
        adapter = AdapterProductos(this,R.layout.rowproducto)
        rvproductos.adapter = adapter
        rvproductos.layoutManager = LinearLayoutManager(this)
    }

    fun onClickProducto(v: View){
        val producto = v.tag as Producto
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("producto", producto)
        startActivity(intent)
    }

}
