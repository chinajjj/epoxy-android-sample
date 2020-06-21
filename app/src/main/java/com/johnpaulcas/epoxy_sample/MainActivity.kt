package com.johnpaulcas.epoxy_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.epoxy.carousel
import com.johnpaulcas.epoxy_sample.constant.DataGenerator
import com.johnpaulcas.epoxy_sample.constant.ViewType
import com.johnpaulcas.epoxy_sample.models.RvView
import com.johnpaulcas.epoxy_sample.viewmodel.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = mutableListOf<RvView>()
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        btnUpdateCarousel.setOnClickListener {
            updateCarouselData()
        }
    }

    private fun updateCarouselData() {
        data[data.size - 1].carousel[0].isSold = true
        rvEpoxySample.requestModelBuild()
//        if (counter < data.size) {
//            data[counter].title = "Awesomeness"
//            rvEpoxySample.requestModelBuild()
//            counter++
//        }
    }

    private fun initRecyclerView() {
        data = DataGenerator.generateData()

        rvEpoxySample.withModels {
            data.forEachIndexed { position, data ->
                when (data.viewType) {
                    ViewType.HEADER -> {
                        header {
                            id(position)
                            title(data.title)
                        }
                    }
                    ViewType.CAROUSEL -> {
                       carouselView {
                            id(position)
                            context(this@MainActivity)
                            carouselTitle(data.title)
                            books(data.carousel)
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
