package com.capwaydemo.ui.newsFeed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capwaydemo.R
import com.capwaydemo.model.ArticlesEntity
import android.graphics.drawable.Drawable

import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


class NewsFeedAdapter(var context: Context, var items: List<ArticlesEntity>, var onArticleClickListener: OnArticleClickListener) : RecyclerView.Adapter<NewsFeedAdapter.ViewHolder>() {

//    private var mArticlesList: List<ArticlesEntity> = items
//    private var mArticleClick: OnArticleClickListener = onArticleClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_feed_item, parent, false)
        return ViewHolder(view, onArticleClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvAuthor.text = item.author
        holder.tvDate.text = item.date
        holder.tvTitle.text = item.title
        Glide.with(context).load(item.mainIconImageUrl).into(holder.ivIcon)
//
//        Glide.with(context)
//            .setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.ic_menu_camera).error(R.drawable.ic_menu_gallery))
//            .load(item.mainIconImageUrl)
//            .into(holder.ivIcon)
//            Glide.with(context).load(item.mainIconImageUrl).into(holder.ivIcon)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View, private var onItemClick: OnArticleClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
        var ivIcon: ImageView = itemView.findViewById(R.id.ivMainIcon)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            onItemClick.onArticleClickListener(items[adapterPosition])
        }
    }
}

interface OnArticleClickListener {
    fun onArticleClickListener(articlesEntity: ArticlesEntity)
}
