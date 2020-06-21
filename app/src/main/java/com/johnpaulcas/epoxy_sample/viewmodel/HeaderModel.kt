package com.johnpaulcas.epoxy_sample.viewmodel

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.johnpaulcas.epoxy_sample.R
import kotlinx.android.synthetic.main.header_layout.view.*

/**
 * Created by johnpaulcas on 21/06/2020.
 */
@EpoxyModelClass(layout = R.layout.header_layout)
abstract class HeaderModel: EpoxyModelWithHolder<HeaderModel.HeaderHolder>() {

    @EpoxyAttribute
    var title: String? = ""

    override fun bind(holder: HeaderHolder) {
        super.bind(holder)
        holder.tvHeader.text = title

    }

    inner class HeaderHolder: EpoxyHolder() {
        lateinit var tvHeader: AppCompatTextView

        override fun bindView(itemView: View) {
            tvHeader = itemView.tvHeader
        }
    }

}