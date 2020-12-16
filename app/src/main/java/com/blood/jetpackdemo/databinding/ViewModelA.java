package com.blood.jetpackdemo.databinding;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blood.jetpackdemo.BR;
import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.activity.DataBindingActivity;
import com.blood.jetpackdemo.other.DataBindingRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewModelA {

    private final DataBindingRecyclerViewAdapter adapter;
    private final List<Person> personList = new ArrayList<>();

    public ViewModelA(final DataBindingActivity activity) {
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.name.set("热巴我老婆<^_^>  " + i);
            p.url.set("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506868893&di=ce03509d972bd0d535a1fdcc20c9d202&imgtype=jpg&er=1&src=http%3A%2F%2Fn.sinaimg.cn%2Fent%2Ftransform%2F20170818%2FIAPS-fykcppx9377606.jpg");
            personList.add(p);
        }

        adapter = new DataBindingRecyclerViewAdapter(activity, R.layout.item_person, BR.person, personList);
        activity.mDataBinding.recyclerview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        activity.mDataBinding.recyclerview.setAdapter(adapter);
        adapter.setOnItemCkickListener(new DataBindingRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void itemClick(View view, int position) {
                Toast.makeText(activity, position + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void remove() {
        if (personList.size() != 0)
            personList.remove(0);
        adapter.notifyDataSetChanged();
    }

    public void add() {
        Person p = new Person();
        p.name.set("热巴我老婆<^_^>  我是新来的");
        p.url.set("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506868893&di=ce03509d972bd0d535a1fdcc20c9d202&imgtype=jpg&er=1&src=http%3A%2F%2Fn.sinaimg.cn%2Fent%2Ftransform%2F20170818%2FIAPS-fykcppx9377606.jpg");
        personList.add(0, p);
        adapter.notifyDataSetChanged();
    }

    public void update() {
        Person person = personList.get(0);
        person.name.set("热巴我老婆 热巴我老婆");
    }

    public static class Person {

        ObservableField<String> name = new ObservableField<>();
        ObservableField<String> url = new ObservableField<>();

        public ObservableField<String> getName() {
            return name;
        }

        public void setName(ObservableField<String> name) {
            this.name = name;
        }

        public ObservableField<String> getUrl() {
            return url;
        }

        public void setUrl(ObservableField<String> url) {
            this.url = url;
        }
    }

}
