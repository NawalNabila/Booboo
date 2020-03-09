package com.nabil.booboo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val book_name = intent.getStringExtra(MainActivity.BOOK_NAME)
        val book_detail = intent.getStringExtra(MainActivity.BOOK_DETAIL)
        val book_image = intent.getIntExtra(MainActivity.BOOK_IMAGE, 0)
        val book_genre = intent.getStringExtra(MainActivity.BOOK_GENRE)
        val book_reads = intent.getStringExtra(MainActivity.BOOK_READ)
        val book_parts = intent.getStringExtra(MainActivity.BOOK_PART)
        val book_author_name = intent.getStringExtra(MainActivity.BOOK_AUTHOR_NAME)
        val book_author_image = intent.getIntExtra(MainActivity.BOOK_AUTHOR_IMAGE, 0)

        supportActionBar?.title = book_name

        Glide.with(this)
            .load(book_image)
            .into(detail_photo)

        tv_book_name.text = book_name
        tv_deskripsi.text = book_detail
        tv_genre.text = book_genre
        tv_reads.text = book_reads
        tv_parts.text = book_parts
        author_name.text = book_author_name

        Glide.with(this)
            .load(book_author_image)
            .into(author_image)

    }
}
