package com.shengqf.view.bottom_pw

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.layout_pw_bottom.view.*
import kotlinx.android.synthetic.main.layout_title.view.*
import java.util.*

/**
 * Created by shengqf
 * Email : shengqf@bsoft.com.cn
 * date : 2019/7/28
 * describe :
 */
class BottomPW(activity: Activity) {

    private val mActivity: Activity = activity
    private val mDecorView: ViewGroup = activity.window.decorView as ViewGroup
    private val mBgView: View = View(activity)
    private val mPopupWindow: PopupWindow = PopupWindow(mActivity)

    init {
        mBgView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        mBgView.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.overlay))
    }

    private lateinit var mContentView: View
    private var mList: ArrayList<String> = ArrayList()//列表数据源
    private var mOnPwItemClickListener: OnPwItemClickListener? = null
    private var mOnPwDismissListener: OnPwDismissListener? = null

    private var mPwPadding: Int = dp2px(10f)//Pw默认padding10dp
    private var mCornerRadius: Int = dp2px(10f)//圆角默认大小10dp
    private  var mShowTitleTv = false //是否显示标题
    private var mTitleStr: String = "请选择" //标题字体内容
    private var mTitleHeight: Int = dp2px(49f) //title的行高
    private var mTitleColor: Int = ContextCompat.getColor(mActivity, R.color.text_tips) //title字体颜色
    private var mTitleSize: Int = 16 //title字体大小
    private var mItemHeight: Int = dp2px(49f) //列表Item的行高
    private var mItemTextColor: Int = ContextCompat.getColor(mActivity, R.color.text_primary) //列表Item的字体颜色
    private var mItemTextSize: Int = 16 //列表Item的字体大小
    private var mShowCancelTv = true //是否显示底部的取消
    private var mCancelHeight: Int = dp2px(49f) //取消字体的行高
    private var mCancelTextColor: Int = ContextCompat.getColor(mActivity, R.color.text_tips) //取消字体的颜色
    private var mCancelTextSize: Int = 16 //取消字体的大小
    private var mCancelTextStr: String = "取消" //取消字体的内容

    //设置列表数据源
    fun setList(list: ArrayList<String>): BottomPW {
        mList.clear()
        mList.addAll(list)
        return this
    }

    //列表Item点击事件
    fun setOnPwItemClickListener(onPwItemClickListener: OnPwItemClickListener): BottomPW {
        this.mOnPwItemClickListener = onPwItemClickListener
        return this
    }

    //Pw消失回调接口
    fun setOnPwDismissListener(onPwDismissListener: OnPwDismissListener): BottomPW {
        this.mOnPwDismissListener = onPwDismissListener
        return this
    }

    fun setPwPadding(pwPadding: Int): BottomPW {
        this.mPwPadding = pwPadding
        return this
    }

    fun setCornerRadius(cornerRadius: Int): BottomPW {
        this.mCornerRadius = cornerRadius
        return this
    }

    fun setShowTitleTv(showTitleTv: Boolean): BottomPW {
        this.mShowTitleTv = showTitleTv
        return this
    }

    fun setTitleStr(titleStr: String): BottomPW {
        this.mTitleStr = titleStr
        return this
    }

    fun setTitleHeight(titleHeight: Int): BottomPW {
        this.mTitleHeight = titleHeight
        return this
    }

    fun setTitleColor(titleColor: Int): BottomPW {
        this.mTitleColor = titleColor
        return this
    }

    fun setTitleSize(titleSize: Int): BottomPW {
        this.mTitleSize = titleSize
        return this
    }

    fun setItemHeight(itemHeight: Int): BottomPW {
        this.mItemHeight = itemHeight
        return this
    }

    fun setItemTextColor(itemTextColor: Int): BottomPW {
        this.mItemTextColor = itemTextColor
        return this
    }

    fun setItemTextSize(itemTextSize: Int): BottomPW {
        this.mItemTextSize = itemTextSize
        return this
    }

    fun setShowCancelTv(showCancelTv: Boolean): BottomPW {
        this.mShowCancelTv = showCancelTv
        return this
    }

    fun setCancelHeight(cancelHeight: Int): BottomPW {
        this.mCancelHeight = cancelHeight
        return this
    }

    fun setCancelTextColor(cancelTextColor: Int): BottomPW {
        this.mCancelTextColor = cancelTextColor
        return this
    }

    fun setCancelTextSize(cancelTextSize: Int): BottomPW {
        this.mCancelTextSize = cancelTextSize
        return this
    }

    fun setCancelTextStr(cancelTextStr: String): BottomPW {
        this.mCancelTextStr = cancelTextStr
        return this
    }

    fun create(): BottomPW {
        initView()
        mPopupWindow.contentView = mContentView
        mPopupWindow.width = ViewGroup.LayoutParams.MATCH_PARENT
        mPopupWindow.height = ViewGroup.LayoutParams.WRAP_CONTENT
        mPopupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mPopupWindow.isFocusable = true//false时PopupWindow不处理返回键
        mPopupWindow.isTouchable = true//false为pw内容区域才响应点击事件
        mPopupWindow.animationStyle = R.style.PopupWindowAnimationBottomToTop
        mPopupWindow.setOnDismissListener {
            mDecorView.removeView(mBgView)
            mOnPwDismissListener?.onDismiss()
        }
        return this
    }

    private fun initView() {
        mContentView = LayoutInflater.from(mActivity).inflate(R.layout.layout_pw_bottom, null)
        //pw内边距
        mContentView.setPadding(mPwPadding, mPwPadding, mPwPadding, mPwPadding)

        with(mContentView) {
            //设置圆角
            round_layout.delegate.cornerRadius = mCornerRadius
            cancel_tv.delegate.cornerRadius = mCornerRadius

            //标题
            if (mShowTitleTv) {
                view_stub.inflate()
                title_tv.text = mTitleStr
                title_tv.layoutParams.height = mTitleHeight
                title_tv.textSize = mTitleSize.toFloat()
                title_tv.setTextColor(mTitleColor)
            }

            //列表
            recyclerView.layoutManager = LinearLayoutManager(mActivity)
            recyclerView.adapter = getAdapter()
            recyclerView.overScrollMode = View.OVER_SCROLL_NEVER//去掉边缘的光晕效果

            //取消按钮
            cancel_tv.visibility = if (mShowCancelTv) View.VISIBLE else View.GONE
            cancel_tv.setTextColor(mCancelTextColor)
            cancel_tv.textSize = mCancelTextSize.toFloat()
            cancel_tv.layoutParams.height = mCancelHeight
            cancel_tv.text = mCancelTextStr
            cancel_tv.setOnClickListener {
                mPopupWindow.dismiss()
                mDecorView.removeView(mBgView)
            }
        }
    }

    private fun getAdapter(): PwAdapter {
        return PwAdapter(mActivity)
            .setList(mList)
            .setItemHeight(mItemHeight)
            .setItemTextColor(mItemTextColor)
            .setItemTextSize(mItemTextSize)
            .setOnItemClickListener(getOnItemClickListener())
    }

    private fun getOnItemClickListener(): PwAdapter.OnItemClickListener {
        return object : PwAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                mOnPwItemClickListener?.onItemClick(position)
                mPopupWindow.dismiss()
                mDecorView.removeView(mBgView)
            }
        }
    }

    fun show() {
        mDecorView.addView(mBgView)
        mPopupWindow.showAtLocation(
            mBgView, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0
        )
    }

    interface OnPwItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnPwDismissListener {
        fun onDismiss()
    }

    private fun dp2px(dpValue: Float): Int {
        val scale = mActivity.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

}