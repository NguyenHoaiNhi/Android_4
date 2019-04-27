package com.example.ui_poster

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var filmAdapter: FilmAdapter
    var film: ArrayList<MovieModel.Results> = ArrayList()
    val model = MovieModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // init clone film data
        addFilms()
        // set up layout manager and recyclerview
        rvFilms.layoutManager = LinearLayoutManager(this)
        filmAdapter = FilmAdapter(film, this)
        rvFilms.adapter = filmAdapter
        filmAdapter.setListenner(filmItemClickListener)

    }
    private val filmItemClickListener = object: FilmItemClickListener {
        override fun onItemClicked(position: Int) {
            var intent = Intent(this@MainActivity, ProfileFilm::class.java)
            intent.putExtra(FILM_TITILE_KEY, film.get(position).title)
            intent.putExtra(FILM_VIDEO_KEY, film.get(position).video)
            intent.putExtra(FILM_CONTENT_KEY,film.get(position).overview)
            intent.putExtra(FILM_POSTER_PATH_KEY, film.get(position).poster_path)
            intent.putExtra(FILM_VOTE_KEY, film.get(position).vote_average)
            startActivity(intent)
        }

    }
    private fun addFilms(){
        for(i in model.getMovieModel().results){
            film.add(i)
            Log.i("film array", film.toString())
        }


    }

}
