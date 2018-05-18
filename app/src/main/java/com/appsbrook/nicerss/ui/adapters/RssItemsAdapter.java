package com.appsbrook.nicerss.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsbrook.nicerss.R;
import com.appsbrook.nicerss.data.RssItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RssItemsAdapter extends RecyclerView.Adapter<RssItemsAdapter.RssItemViewHolder> {

    private List<RssItem> items;

    public RssItemsAdapter() {
    }

    public RssItemsAdapter(List<RssItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RssItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

        return new RssItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssItemViewHolder holder, int position) {

        RssItem item = items.get(position);

        holder.bind(item);
    }

    @Override
    public int getItemCount() {

        return items != null ? items.size() : 0;
    }

    public void updateNewsItems(List<RssItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    static class RssItemViewHolder extends RecyclerView.ViewHolder {

        private RssItem item;

        @BindView(R.id.title_text_view)
        TextView titleTextView;

        RssItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(RssItem item) {

            this.item = item;

            titleTextView.setText(item.getTitle());
        }
    }
}