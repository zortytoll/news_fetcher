package com.example.newsfetcher.presentation.news_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsfetcher.R
import com.example.newsfetcher.presentation.NewsViewModel
import com.example.newsfetcher.presentation.news_list_fragment.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class NewsListFragment : Fragment() {

    private val adapter = NewsAdapter()
    private val viewModel: NewsViewModel by lazy { ViewModelProviders.of(this)[NewsViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.liveData.observe(this, Observer(::render))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
    }

    private fun render(viewState: ViewState) {
        adapter.setItems(viewState.newsList)
    }
}