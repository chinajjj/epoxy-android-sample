package com.johnpaulcas.epoxy_sample.constant

import com.johnpaulcas.epoxy_sample.models.RvView

/**
 * Created by johnpaulcas on 21/06/2020.
 */
object DataGenerator {

    fun generateData(): MutableList<RvView> {
        val data = mutableListOf<RvView>()
        for (n in 0 until 10) {
            if (n == 0) {
                data.add(RvView(ViewType.HEADER, "Header", "Header content"))
            } else if (n == 9) {
                data.add(RvView(ViewType.FOOTER, "Footer", "Footer content"))
            } else {
                data.add(RvView(ViewType.BODY, "Content $n", "Content of $n"))
            }
        }

        val carouselData = mutableListOf<Book>(
            Book("Book 1", "Desc 1", false),
            Book("Book 2", "Desc 2", false),
            Book("Book 3", "Desc 3", false),
            Book("Book 4", "Desc 4", false)
        )

        val carouselView = RvView(ViewType.CAROUSEL, "Carousel", "Carousel content")
        carouselView.carousel = carouselData

        data.add(carouselView)

        return data
    }

    fun getBooks(): MutableList<Book> {
        return mutableListOf<Book>(
            Book("Book 1", "Desc 1", false),
            Book("Book 2", "Desc 2", false),
            Book("Book 3", "Desc 3", false),
            Book("Book 4", "Desc 4", false)
        )
    }

}