package com.nabil.booboo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewBookAdapter(private val listBooks: ArrayList<Book>, val context: Context) : RecyclerView.Adapter<CardViewBookAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewBookAdapter.CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_books, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }

    override fun onBindViewHolder(holder: CardViewBookAdapter.CardViewViewHolder, position: Int) {
        val book = listBooks[position]
        Glide.with(holder.itemView.context)
            .load(book.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = book.name
        holder.tvDetail.text = book.detail
        holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Buku Favorite mu: " + listBooks[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.btnRead.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MainActivity.BOOK_NAME, book.name)
            intent.putExtra(MainActivity.BOOK_DETAIL, book.detail)
            Log.i("TAG", ""+book.detail)
            intent.putExtra(MainActivity.BOOK_IMAGE, book.photo)
            intent.putExtra(MainActivity.BOOK_GENRE, book.genre)
            intent.putExtra(MainActivity.BOOK_READ, book.reads)
            intent.putExtra(MainActivity.BOOK_PART, book.parts)
            intent.putExtra(MainActivity.BOOK_AUTHOR_NAME, book.author_name)
            intent.putExtra(MainActivity.BOOK_AUTHOR_IMAGE, book.author_photo)

            context.startActivity(intent)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MainActivity.BOOK_NAME, book.name)
            intent.putExtra(MainActivity.BOOK_DETAIL, book.detail)
            Log.i("TAG", ""+book.detail)
            intent.putExtra(MainActivity.BOOK_IMAGE, book.photo)
            intent.putExtra(MainActivity.BOOK_GENRE, book.genre)
            intent.putExtra(MainActivity.BOOK_READ, book.reads)
            intent.putExtra(MainActivity.BOOK_PART, book.parts)
            intent.putExtra(MainActivity.BOOK_AUTHOR_NAME, book.author_name)
            intent.putExtra(MainActivity.BOOK_AUTHOR_IMAGE, book.author_photo)

            context.startActivity(intent)
        }
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnRead: Button = itemView.findViewById(R.id.btn_set_read)
    }
}