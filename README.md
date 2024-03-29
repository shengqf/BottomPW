# BottomPW

---

##### 1、项目根目录build.gradle文件添加maven地址：
```ruby
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

##### 2、需要使用的BottomPW的模块的build.gradle文件添加：
```ruby
dependencies {
    implementation 'com.github.shengqf:BottomPW:v1.0.1'
}

```

##### 3、使用：

（1）关于BottomPW所有属性的设置方法如下：

```kotlin
       BottomPW(this)
            .setList(mList)//设置列表数据源
            .setPwPadding(10f)//BottomPW的内边距，单位dp（默认是10dp）
            .setCornerRadius(10)//圆角大小，单位dp（默认是10dp）
            .setShowTitleTv(false)//是否显示列表上方的标题，默认不显示
            .setTitleStr("请选择")//列表上方的标题内容，默认为"请选择"
            .setTitleHeight(49f)//列表上方的标题高度，单位dp（默认是49dp）
            .setTitleColor(R.color.text_tips))//列表上方的标题字体颜色，默认颜色是：#999999
            .setTitleSize(16)//列表上方的标题字体大小，默认是16sp
            .setItemHeight(49f)//列表Item的高度，单位dp（默认是49dp）
            .setItemTextColor(R.color.text_primary)//列表Item的字体颜色，默认颜色是：#333333
            .setItemTextSize(16)//列表Item的字体大小，默认是16sp
            .setShowCancelTv(true)//是否显示底部的cancel按钮，默认显示
            .setCancelHeight(49f)//cancel按钮的高度，单位dp（默认是49dp）
            .setCancelTextColor(R.color.text_tips)//cancel按钮的字体颜色，默认颜色是：#999
            .setCancelTextSize(16)//cancel按钮字体大小，默认是16sp
            .setCancelTextStr("取消")//默认文字是"取消"
            .setOnPwItemClickListener(getOnPwItemClickListener())//列表Item点击事件
            .setOnPwDismissListener(getOnPwDismissListener())//BottomPW消失回调
            .create()
            .show()                  
```

（2）如果你只使用BottomPW的默认样式，不需要修改任何属性：

```kotlin
       BottomPW(this)
            .setList(mList)//设置列表数据源
            .setOnPwItemClickListener(getOnPwItemClickListener())//列表Item点击事件
            .create()
            .show()
```
默认样式图如下：

![]( https://github.com/shengqf/BottomPW/raw/master/img/01.png)


（3）你也可通过BottomPW的set方法设置你想要的样式，这里截取了几个图：

![]( https://github.com/shengqf/BottomPW/raw/master/img/02.png)  ![]( https://github.com/shengqf/BottomPW/raw/master/img/03.png)

![]( https://github.com/shengqf/BottomPW/raw/master/img/04.png)  ![]( https://github.com/shengqf/BottomPW/raw/master/img/05.png)

![]( https://github.com/shengqf/BottomPW/raw/master/img/06.png)

