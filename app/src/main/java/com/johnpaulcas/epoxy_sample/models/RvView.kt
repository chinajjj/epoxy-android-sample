package com.johnpaulcas.epoxy_sample.models

import com.johnpaulcas.epoxy_sample.constant.Book
import com.johnpaulcas.epoxy_sample.constant.ViewType

/**
 * Created by johnpaulcas on 21/06/2020.
 */
data class RvView(
    val viewType: ViewType,
    val title: String,
    val description: String
) {

    var carousel = mutableListOf<Book>()

}