package com.johnpaulcas.epoxy_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.johnpaulcas.epoxy_sample.constant.DataGenerator
import com.johnpaulcas.epoxy_sample.constant.ViewType
import com.johnpaulcas.epoxy_sample.viewmodel.carouselView
import com.johnpaulcas.epoxy_sample.viewmodel.footer
import com.johnpaulcas.epoxy_sample.viewmodel.header
import com.johnpaulcas.epoxy_sample.viewmodel.item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val data = DataGenerator.generateData()

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
