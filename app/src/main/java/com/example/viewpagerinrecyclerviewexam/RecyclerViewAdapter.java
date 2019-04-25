package com.example.viewpagerinrecyclerviewexam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by junsuk on 2017. 7. 4..
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_PAGER = 0;
    public static final int TYPE_NORMAL = 1;

    private final FragmentManager mFragmentManager;
    private List<Item> mItems;

    public RecyclerViewAdapter(FragmentManager fm, List<Item> items) {
        mFragmentManager = fm;
        mItems = items;
    }

    static class PagerViewHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;

        public PagerViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.view_pager);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_PAGER : TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_PAGER:
                return new PagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager, parent, false));
            case TYPE_NORMAL:
                return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_PAGER:
                List<Fragment> item = (List<Fragment>) mItems.get(position).getItem();
                PagerViewHolder holder1 = (PagerViewHolder) holder;
                ViewPagerAdapter adapter = new ViewPagerAdapter(mFragmentManager,item);
                holder1.viewPager.setAdapter(adapter);
                break;
            case TYPE_NORMAL:
                String item1 = (String) mItems.get(position).getItem();
                ItemViewHolder holder2 = (ItemViewHolder) holder;
                holder2.textView.setText(item1);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
