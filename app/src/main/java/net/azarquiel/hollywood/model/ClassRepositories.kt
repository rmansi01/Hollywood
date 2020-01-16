package net.azarquiel.hollywood.model

import android.app.Application
import androidx.lifecycle.LiveData

class CategoriaRepository(application: Application){
    val categoriaDao = FosterDB.getDatabase(application)!!.categoriaDao()

    // select
    fun getCategorias() : LiveData<List<Categoria>>{
        return categoriaDao.getCategorias()
    }
}

class ProductoRepository(application: Application){
    val productoDao = FosterDB.getDatabase(application)!!.productoDao()

    // select
    fun getProductos(categoriaid : Int):LiveData<List<Producto>>{
        return productoDao.getProductos(categoriaid)
    }
    fun getProductoById(id:Int):Producto{
        return productoDao.getProductoById(id)
    }
}