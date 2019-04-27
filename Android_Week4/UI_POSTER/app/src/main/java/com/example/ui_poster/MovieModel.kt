package com.example.ui_poster

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class MovieModel {
    data class ResultArray (
        val results : List<Results>
    )

    data class Results (
        val vote_count : Int,
        val id : Int,
        val video : Boolean,
        val vote_average : Double,
        val title : String,
        val popularity : Double,
        val poster_path : String,
        val original_language : String,
        val original_title : String,
        val genre_ids : List<Int>,
        val backdrop_path : String,
        val adult : Boolean,
        val overview : String,
        val release_date : String
    )
    private val gson = GsonBuilder().create() // tai sao khong khoi tao Gson ma lai khoi tao GsonBuilder
    private val data = FakeService.getMovieRaw()
    private val dataGson = gson.fromJson(data, ResultArray::class.java)

    fun getMovieModel() : ResultArray{
        return dataGson
    }
}

fun main(args: Array<String>){
//    val model = MovieModel()
//    for(i in model.getMovieModel().results) println(i)

}
