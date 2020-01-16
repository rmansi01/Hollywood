package net.azarquiel.hollywood.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriaDao{
    @Query("select * from categoria")
    fun getCategorias():LiveData<List<Categoria>>


}

@Dao
interface ProductoDao{
    @Query("select * from producto where categoriaid = :categoriaid")
    fun getProductos(categoriaid : Int) : LiveData<List<Producto>>

    @Query("select * from producto where id = :id")
    fun getProductoById(id : Int) : Producto
}