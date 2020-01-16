package net.azarquiel.hollywood.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rowcategoria.*
import net.azarquiel.hollywood.R
import net.azarquiel.hollywood.adapters.AdapterCategorias
import net.azarquiel.hollywood.model.Categoria
import net.azarquiel.hollywood.util.Util
import net.azarquiel.hollywood.viewmodel.CategoriaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var categoriaViewModel: CategoriaViewModel
    private lateinit var adapter: AdapterCategorias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Util.inyecta(this,"foster")
        categoriaViewModel = ViewModelProviders.of(this).get(CategoriaViewModel::class.java)

        initRV()

        categoriaViewModel.getCategorias().observe(this, Observer { categorias -> categorias?.let{adapter.setCategorias(it)} })



    }

    private fun initRV() {
        adapter = AdapterCategorias(this, R.layout.rowcategoria)
        rvcategorias.adapter = adapter
        rvcategorias.layoutManager = LinearLayoutManager(this)
    }



    fun onClickCategoria(v: View) {
        val categoria = v.tag as Categoria
        val intent = Intent(this, ProductosActivity::class.java)
        intent.putExtra("categoria", categoria)
        startActivity(intent)
    }
}
