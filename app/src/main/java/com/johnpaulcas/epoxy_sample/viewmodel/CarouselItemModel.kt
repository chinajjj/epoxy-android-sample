package com.johnpaulcas.epoxy_sample.viewmodel

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.johnpaulcas.epoxy_sample.R
import kotlinx.android.synthetic.main.carousel_item_layout.view.*

/**
 * Created by johnpaulcas on 22/06/2020.
 */
@EpoxyModelClass(layout = R.layout.carousel_item_layout)
abstract class CarouselItemModel: EpoxyModelWithHolder<CarouselItemModel.CarouselItemHolder>() {

    @EpoxyAttribute
    var title: String = ""
    @EpoxyAttribute
    var status: Boolean = false

    override fun bind(holder: CarouselItemHolder) {
        super.bind(holder)
        holder.tvCarouseTitle.text = title
        holder.tvStatus.text = if (status) {
            "Sold"
        } else {
            "Available"
        }
    }

    inner class CarouselItemHolder: EpoxyHolder() {

        lateinit var tvCarouseTitle: AppCompatTextView
        lateinit var tvStatus: AppCompatTextView

        override fun bindView(itemView: View) {
            tvCarouseTitle = itemView.tvCarouselTitle
            tvStatus = itemView.tvCarouselStatus
        }

    }
}