package net.azarquiel.hollywood.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import net.azarquiel.hollywood.model.Categoria
import net.azarquiel.hollywood.model.CategoriaRepository
import net.azarquiel.hollywood.model.Producto
import net.azarquiel.hollywood.model.ProductoRepository

class CategoriaViewModel (application: Application) : AndroidViewModel(application){
    private var repository : CategoriaRepository = CategoriaRepository(application)

    fun getCategorias() : LiveData<List<Categoria>>{
        return repository.getCategorias()
    }
}

class ProductoViewModel (application: Application) : AndroidViewModel(application){
    private var repository : ProductoRepository = ProductoRepository(application)

    fun getProductos(categoriaid : Int) : LiveData<List<Producto>>{
        return repository.getProductos(categoriaid)
    }

    fun getProductoById(id : Int): Producto{
        return repository.getProductoById(id)
    }
}