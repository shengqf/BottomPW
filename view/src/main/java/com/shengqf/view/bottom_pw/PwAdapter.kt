package com.shengqf.view.bottom_pw

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rv_item.view.*
import java.util.*


/**
 * Created by shengqf
 * Email : shengqf@bsoft.com.cn
 * date : 2019/7/28
 * describe :
 */
class PwAdapter constructor(context: Context) : RecyclerView.Adapter<PwAdapter.PwViewHolder>() {

    private val mContext = context
    private var mList: ArrayList<String> = ArrayList()
    private var mOnItemClickListener: OnItemClickListener? = null

    fun setList(list: ArrayList<String>): PwAdapter {
        mList.clear()
        mList.addAll(list)
        return this
    }

    private var mItemHeight: Int = dp2px(49f) //列表Item的行高
    private var mItemTextColor: Int = ContextCompat.getColor(mContext,R.color.text_primary) //列表Item的字体颜色
    private var mItemTextSize: Int = 16 //列表Item的字体大小

    fun setItemHeight(itemHeight: Int): PwAdapter {
        this.mItemHeight = itemHeight
        return this
    }

    fun setItemTextColor(itemTextColor: Int): PwAdapter {
        this.mItemTextColor = itemTextColor
        return this
    }

    fun setItemTextSize(itemTextSize: Int): PwAdapter {
        this.mItemTextSize = itemTextSize
        return this
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener): PwAdapter {
        this.mOnItemClickListener = onItemClickListener
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PwViewHolder {
        //val itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_item, null)
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false)
        return PwViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: PwViewHolder, position: Int) {
        with(holder.itemView) {
            item_tv.text = mList[position]
            item_tv.setTextColor(mItemTextColor)
            item_tv.textSize = mItemTextSize.toFloat()
            item_tv.layoutParams.height = mItemHeight
            divider.visibility = if (position == mList.size - 1) View.GONE else View.VISIBLE
            item_tv.setOnClickListener {
                mOnItemClickListener?.onItemClick(position)
            }
        }
    }

    class PwViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private fun dp2px(dpValue: Float): Int {
        val scale = mContext.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}