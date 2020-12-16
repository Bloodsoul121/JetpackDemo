package com.blood.jetpackdemo.databinding;

import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

import com.blood.jetpackdemo.MainApplication;
import com.bumptech.glide.Glide;

public class ImageDataBindingAdapter {

    //    @BindingAdapter("app:image")
    @BindingAdapter("image")
    public static void setImage(ImageView imageView, String url) {
        Glide.with(MainApplication.getContext()).load(url).into(imageView);
    }

    //可以把color整形转换为android:src可接受的ColorDrawable类型
//但是转换只适用于直接的赋值
//如果你写了复杂的表达式,比如使用了?:这种三元运算符
//那就照顾不到你了
//    @BindingConversion
//    public static ColorDrawable toDrawable(int color) {
//        return new ColorDrawable(color);
//    }


//    //我们可以看到源码中使用了@InverseBindingAdapter自定义了一个反向绑定器
//    //指定了其属性以及相关联的事件
//    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
//    public static String getTextString(TextView view) {
//        return view.getText().toString();
//    }
//    //并为这个事件添加了一个可接受InverseBindingListener的属性
//    //为了说明方便,下面的代码已简化,源码并非如此,但主要逻辑相同
//    @BindingAdapter(value = {"android:textAttrChanged"})
//    public static void setTextWatcher(TextView view , InverseBindingListener textAttrChanged){
//        view.addTextChangedListener(new TextWatcher(){
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            //......
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                textAttrChanged.onChange();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
//    //至此android:text的反向绑定完成
//    //当你使用@={}时实际上是用android:textAttrChanged属性向TextView设置了TextWatcher
//    //传入的InverseBindingListener是反向绑定监听器
//    //当调用InverseBindingListener的onChange时
//    //会调用@BindingAdapter所注解的方法将获得数据并写回到变量中.

}
