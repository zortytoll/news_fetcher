package com.example.newsfetcher.presentation.news_list_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import kotlinx.android.synthetic.main.news_title.view.*

class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var newslist: List<ArticleItem> = emptyList()

    fun setItems(list: List<ArticleItem>) {
        this.newslist = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.news_title, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newslist[position])
    }

    override fun getItemCount() = newslist.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ArticleItem) {
            itemView.viewTitle.text = item.title
            itemView.viewAbstract.text = item.abstract
        }
    }
}