# BottomPW

---

### 使用：

1、项目根目录build.gradle文件添加maven地址：
```ruby
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

2、需要使用的BottomPW的模块的build.gradle文件添加：
```ruby
dependencies {
    implementation 'com.github.shengqf:BottomPW:v1.0.0'
}

```

3、同步工程即可使用

4、使用：
```kotlin
    BottomPW(this)
        .setList(mList)//设置列表数据源
        .setPwPadding(10)//BottomPW的内边距，单位dp（默认是10dp）
        .setCornerRadius(10)//圆角大小，单位dp（默认是10dp）
        .setShowTitleTv(false)//是否显示列表上方的标题，默认不显示
        .setTitleStr("请选择")//列表上方的标题内容，默认为
        .setTitleHeight(49)//列表上方的标题高度，单位dp（默认是49dp）
        .setTitleColor(ContextCompat.getColor(this@MainActivity, R.color.text_tips))//列表上方的标题字体颜色，默认是ContextCompat.getColor(mActivity, R.color.text_tips)，text_tips：#999
        .setTitleSize(16)//列表上方的标题字体大小，默认是16sp
        .setItemHeight(49)//列表Item的高度，单位dp（默认是49dp）
        .setItemTextColor(ContextCompat.getColor(this@MainActivity, R.color.text_primary))//列表Item的字体颜色，默认是ContextCompat.getColor(mActivity, R.color.text_primary)，text_primary：#333
        .setItemTextSize(16)//列表Item的字体大小，默认是16sp
        .setShowCancelTv(true)//是否显示底部的cancel按钮，默认显示
        .setCancelHeight(49)//cancel按钮的高度，单位dp（默认是49dp）
        .setCancelTextColor(ContextCompat.getColor(this@MainActivity, R.color.text_tips))//cancel按钮的字体颜色，默认是ContextCompat.getColor(mActivity, R.color.text_tips)，text_tips：#999
        .setCancelTextSize(16)//cancel按钮字体大小，默认是16sp
        .setCancelTextStr("取消")//默认文字是"取消"
        .setOnPwItemClickListener(getOnPwItemClickListener())//列表Item点击事件
        .setOnPwDismissListener(getOnPwDismissListener())//BottomPW消失回调
        .create()
        .show()                
```

---
默认样式：
![]( https://github.com/shengqf/BottomPW/raw/master/img/01.png)

以下为设置了属性样式：
![]( https://github.com/shengqf/BottomPW/raw/master/img/02.png)

![]( https://github.com/shengqf/BottomPW/raw/master/img/03.png)

![]( https://github.com/shengqf/BottomPW/raw/master/img/04.png)

![]( https://github.com/shengqf/BottomPW/raw/master/img/05.png)

![]( https://github.com/shengqf/BottomPW/raw/master/img/06.png)
