package com.jeff_skillrill.book_shop_application.books

import android.content.Context
import com.google.gson.Gson
import com.jeff_skillrill.book_shop_application.R
import com.jeff_skillrill.book_shop_application.model.Book

class BookApi(context: Context) {
    companion object {
        private var instance: BookApi? = null
        fun newInstance(context: Context): BookApi {
            if (instance == null) {
                instance = BookApi(context)
            }
            return instance!!
        }
    }

    private val shared = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveAllBooksToShared() {
        var books = ArrayList<Book>()

        books.add(
            Book(
                "Doxology",
                "Nell Zink",
                450,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.7,
                "9.6 mb",
                "$17.99",
                R.drawable.doxology,
                "Thriller",
                null
            )
        )

        books.add(
            Book(
                "The Final Revival of Opal & Nev",
                "Dawnie Walton",
                237,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.9,
                "7.9 mb",
                "$28.50",
                R.drawable.opal,
                "Romance",
                null
            )
        )

        books.add(
            Book(
                "An Equal Music",
                "Vikram Seth",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.9,
                "6.9 mb",
                "$8.50",
                R.drawable.music,
                "Thriller",
                null
            )
        )

        books.add(
            Book(
                "The Vallentine's Hate",
                "Sidney Halston",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.1,
                "5.6 mb",
                "$10.50",
                R.drawable.valentines,
                "Romance",
                null
            )
        )

        books.add(
            Book(
                "The Commitments",
                "Roddy Doyle ",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.2,
                "6.9 mb",
                "$8.50",
                R.drawable.action1,
                "Action",
                null
            )
        )

        books.add(
            Book(
                "Keeper of Secrets",
                "Denise Grover",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.3,
                "5.6 mb",
                "$11.50",
                R.drawable.img_3,
                "Romance",
                null
            )
        )

        val booksJson = gson.toJson(books)
        shared.edit().putString("books", booksJson).apply()
    }
}