package net.azarquiel.hollywood.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import net.azarquiel.hollywood.R

import kotlinx.android.synthetic.main.activity_favoritos.*
import kotlinx.android.synthetic.main.content_favoritos.*
import net.azarquiel.hollywood.adapters.AdapterFavoritos
import net.azarquiel.hollywood.model.Producto


class FavoritosActivity : AppCompatActivity() {

    private lateinit var listener: FavoritosActivity
    private lateinit var adapter: AdapterFavoritos
    private lateinit var favoritosShare: SharedPreferences
    private var contador = 0
    private lateinit var contadorShare: SharedPreferences
    private lateinit var favoritosAL: java.util.ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)
        setSupportActionBar(toolbar)
        listener = this


        fab.setOnClickListener { view ->
            finish()
        }


    }

    private fun initRV() {
        adapter = AdapterFavoritos(this, R.layout.rowproducto)
        rvfavoritos.adapter = adapter
        rvfavoritos.layoutManager = LinearLayoutManager(this)
    }

    private fun initShare() {
        // get id last
        contadorShare  = getSharedPreferences("contador", Context.MODE_PRIVATE)
        contador = contadorShare.getInt("contador", -1)
        if (contador==-1)
            contador=0
        // get amigosAL
        favoritosShare = getSharedPreferences("agenda", Context.MODE_PRIVATE)
    }
    private fun showData() {
        val favoritosShare = favoritosShare.all
        favoritosAL = ArrayList()
        for (entry in favoritosShare.entries) {
            val jsonFav = entry.value.toString()
            val fav = Gson().fromJson(jsonFav, Producto::class.java)
            favoritosAL.add(fav)
        }

        adapter.setFavs(favoritosAL.sortedBy { it.titulo })

    }

}
