package com.johnpaulcas.epoxy_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel
import com.johnpaulcas.epoxy_sample.constant.Book
import com.johnpaulcas.epoxy_sample.constant.DataGenerator
import com.johnpaulcas.epoxy_sample.constant.ViewType
import com.johnpaulcas.epoxy_sample.models.RvView
import com.johnpaulcas.epoxy_sample.viewmodel.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = mutableListOf<RvView>()
    var carouselData = mutableListOf<Book>()
    var counter = 0
    var carouselToogleChange = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carouselData = DataGenerator.getBooks()

        initRecyclerView()
        btnUpdateCarousel.setOnClickListener {
            updateCarouselData()
        }
    }

    private fun updateCarouselData() {
//        data[data.size - 1].carousel[0].isSold = true
        if (counter < carouselData.size) {
            carouselData[counter].isSold = true
            carouselToogleChange = !carouselToogleChange
            rvEpoxySample.requestModelBuild()
            counter ++
        }
        rvEpoxySample.requestModelBuild()
//        if (counter < data.size) {
//            data[counter].title = "Awesomeness"
//            rvEpoxySample.requestModelBuild()
//            counter++
//        }
    }

    private fun initRecyclerView() {
        data = DataGenerator.generateData()

        val models = carouselData.map {
            CarouselItemModel_()
                .id(it.title)
                .status(it.isSold)
        }

        rvEpoxySample.withModels {

            carousel {
                id("carousel")
                hasFixedSize(true)
//                padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
                models(models)
            }

//            carouselView {
//                id("carousel")
//                context(this@MainActivity)
//                carouselTitle("Carousel")
//                toggleChange(carouselToogleChange)
//                books(carouselData)
//            }
            data.forEachIndexed { position, data ->
                when (data.viewType) {
                    ViewType.HEADER -> {
                        header {
                            id(position)
                            title(data.title)
                        }
                    }
                    ViewType.FOOTER -> {
                        footer {
                            id(position)
                            footerTitle(data.title)
                        }
                    }
                    else -> {
                        item {
                            id(position)
                            contentTitle(data.title)
                            clickButtonListener(View.OnClickListener {
                                Toast.makeText(this@MainActivity, "Awesome", Toast.LENGTH_SHORT).show()
                            })
                        }
                    }
                }

            }
        }
    }
}
