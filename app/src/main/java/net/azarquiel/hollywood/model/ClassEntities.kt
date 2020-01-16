package net.azarquiel.hollywood.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "categoria")
data class Categoria(@PrimaryKey
                        var id:Int?,
                        var nombre:String,
                        var descripcion:String,
                        var guarnicion:String) : Serializable

@Entity(tableName = "producto",
    foreignKeys = [ForeignKey(entity=Categoria::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoriaid"))])
data class Producto(@PrimaryKey
                        var id:Int?,
                        var titulo:String,
                        var body:String,
                        var categoriaid:Int?,
                        var imagen:String,
                        var fondo:String,
                        var sumario:String) : Serializable


