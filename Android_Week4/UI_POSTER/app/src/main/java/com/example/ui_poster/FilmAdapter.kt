package com.example.ui_poster

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*
import java.text.FieldPosition

/**
 * Created by Nhi Nguyen on 4/25/19
 */
class FilmAdapter(var items: ArrayList<MovieModel.Results>, val context: Context) : RecyclerView.Adapter<FilmViewHolder>(){
    lateinit var mListener: FilmItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FilmViewHolder {
        return FilmViewHolder(LayoutInflater.from(context).inflate(R.layout.item_film, parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(filmViewHolder: FilmViewHolder, position: Int) {
        filmViewHolder.tvName.text = items.get(position).title
        filmViewHolder.tvReleaseDate.text = "Release date: "+items.get(position).release_date
        filmViewHolder.tvLanguage.text = "Original language: "+items.get(position).original_language
        filmViewHolder.tvPopularity.text = "Popularity: "+items.get(position).popularity
        filmViewHolder.tvVote.text = "Vote count: "+items.get(position).vote_count
        var value_video: Boolean = items.get(position).video
        if(value_video ==true){
            filmViewHolder.tvPlay.visibility = View.VISIBLE
        }
        else
        {
            filmViewHolder.tvPlay.visibility = View.INVISIBLE
        }

        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500/"+items.get(position).poster_path)
            .centerCrop()
            .placeholder(R.drawable.student_place_holder)
            .into(filmViewHolder.tvAvatar)
        filmViewHolder.itemView.setOnClickListener{
            mListener.onItemClicked(position)
        }
    }
    fun setListenner(listener: FilmItemClickListener){
        this.mListener = listener
    }



}
class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var tvAvatar = view.ivAvatar
    var tvName = view.NameFilm
    var tvPlay = view.play
    var tvReleaseDate = view.Release
    var tvLanguage = view.language
    var tvPopularity = view.popularity
    var tvVote = view.vote_count
}
