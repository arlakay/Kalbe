package id.co.octolink.loyaltysystem.history.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.co.octolink.R;
import id.co.octolink.model.History;

/**
 * Created by FirdaRinoa on 8/22/16.
 */
public class History2Adapter extends RecyclerView.Adapter<History2ViewHolder>{

    private List<History> historyList;
    private int rowLayout;
    Context context;
    OnItemClickListener clickListener;

    public History2Adapter(List<History> login, int rowLayout, Context context, OnItemClickListener listener) {
        this.historyList = login;
        this.rowLayout = rowLayout;
        this.context = context;
        this.clickListener = listener;
    }

    @Override
    public History2ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history2_card, viewGroup, false);
        History2ViewHolder viewHolder = new History2ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(History2ViewHolder versionViewHolder, int i) {
        final History model = historyList.get(i);
        versionViewHolder.bind(model, clickListener);
    }

    @Override
    public int getItemCount() {
        return historyList == null ? 0 : historyList.size();
    }

    public void animateTo(List<History> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<History> newModels) {
        for (int i = historyList.size() - 1; i >= 0; i--) {
            final History model = historyList.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<History> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final History model = newModels.get(i);
            if (!historyList.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<History> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final History model = newModels.get(toPosition);
            final int fromPosition = historyList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public History removeItem(int position) {
        final History model = historyList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, History model) {
        historyList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final History model = historyList.remove(fromPosition);
        historyList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    public interface OnItemClickListener {
        public void onItemClick(History model);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
