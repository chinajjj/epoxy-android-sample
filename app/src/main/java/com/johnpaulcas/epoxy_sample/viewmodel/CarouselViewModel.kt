package com.johnpaulcas.epoxy_sample.viewmodel

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.*
import com.johnpaulcas.epoxy_sample.R
import com.johnpaulcas.epoxy_sample.constant.Book
import kotlinx.android.synthetic.main.carouselview_layout.view.*

/**
 * Created by johnpaulcas on 21/06/2020.
 */
@EpoxyModelClass(layout = R.layout.carouselview_layout)
abstract class CarouselViewModel: EpoxyModelWithHolder<CarouselViewModel.CarouselViewHolder>() {

    private var counter = 0

    @EpoxyAttribute
    var context: Context? = null

    @EpoxyAttribute
    var carouselTitle: String? = null

    @EpoxyAttribute
    var books: MutableList<Book> = mutableListOf()

    override fun bind(holder: CarouselViewHolder) {
        super.bind(holder)
        holder.rvCarouselTitle.text = carouselTitle
        holder.rvCarousel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.rvCarousel.withModels {
            books.forEachIndexed { position, book ->
                carouselItem {
                    id(position)
                    title(book.title)
                    status(book.isSold)
                }
            }
        }

        holder.btnUpdateStatus.setOnClickListener {
            if (counter < books.size) {
                books[counter].isSold = true
                holder.rvCarousel.requestModelBuild()
                counter ++
            }
        }

    }

    inner class CarouselViewHolder: EpoxyHolder() {

        lateinit var rvCarousel: EpoxyRecyclerView
        lateinit var rvCarouselTitle: AppCompatTextView
        lateinit var btnUpdateStatus: Button

        override fun bindView(itemView: View) {
            rvCarousel = itemView.rvCarousel
            rvCarouselTitle = itemView.tvCarouselTitle
            btnUpdateStatus = itemView.btnUpdateStatus
        }
    }
}