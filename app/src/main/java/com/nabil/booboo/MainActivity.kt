package com.nabil.booboo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvBooks: RecyclerView

    private var list: ArrayList<Book> = arrayListOf()

    companion object {
        const val BOOK_NAME = "a"
        const val BOOK_IMAGE = "v"
        const val BOOK_DETAIL = "c"
        const val BOOK_GENRE = "d"
        const val BOOK_READ = "b"
        const val BOOK_PART = "n"
        const val BOOK_AUTHOR_NAME  = "m"
        const val BOOK_AUTHOR_IMAGE = "x"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(BooksData.bookListData)
        showRecyclerCardView()
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.profil,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.profil){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerCardView() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val cardViewBookAdapter = CardViewBookAdapter(list, this)
        rvBooks.adapter = cardViewBookAdapter
    }
}
