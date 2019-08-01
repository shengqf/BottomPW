package com.shengqf.bottompw

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.shengqf.view.bottom_pw.BottomPW
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mList = arrayListOf("apple", "orange", "banana", "pear")
    private var mBottomPW: BottomPW? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            if (mBottomPW == null) {
                mBottomPW = BottomPW(this)
                    .setList(mList)
                    .setPwPadding(10f)//BottomPW的内边距，单位dp（默认是10dp）
                    .setCornerRadius(10)//圆角大小，单位dp（默认是10dp）
                    .setShowTitleTv(true)//是否显示列表上方的标题，默认不显示
                    .setTitleStr("请选择")//列表上方的标题内容，默认为"请选择"
                    .setTitleHeight(49f)//列表上方的标题高度，单位dp（默认是49dp）
                    .setTitleColor(R.color.red)//列表上方的标题字体颜色，默认颜色是：#999999
                    .setTitleSize(16)//列表上方的标题字体大小，默认是16sp
                    .setItemHeight(49f)//列表Item的高度，单位dp（默认是49dp）
                    .setItemTextColor(R.color.blue)//列表Item的字体颜色，默认颜色是：#333333
                    .setItemTextSize(16)//列表Item的字体大小，默认是16sp
                    .setShowCancelTv(true)//是否显示底部的cancel按钮，默认显示
                    .setCancelHeight(49f)//cancel按钮的高度，单位dp（默认是49dp）
                    .setCancelTextColor(R.color.text_primary)//cancel按钮的字体颜色，默认颜色是：#999999
                    .setCancelTextSize(16)//cancel按钮字体大小，默认是16sp
                    .setCancelTextStr("取消")//默认文字是"取消"
                    .setOnPwItemClickListener(getOnPwItemClickListener())//列表Item点击事件
                    .setOnPwDismissListener(getOnPwDismissListener())//BottomPW消失回调
                    .create()
            }
            mBottomPW?.show()
        }
    }

    private fun getOnPwDismissListener(): BottomPW.OnPwDismissListener {
        return object : BottomPW.OnPwDismissListener {
            override fun onDismiss() {
                Toast.makeText(this@MainActivity, "pw has dismissed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getOnPwItemClickListener(): BottomPW.OnPwItemClickListener {
        return object : BottomPW.OnPwItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, mList[position], Toast.LENGTH_SHORT).show()
            }
        }
    }

}
