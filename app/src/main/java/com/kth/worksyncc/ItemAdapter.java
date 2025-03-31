package com.kth.worksyncc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kth.worksyncc.database.EmployeeModel;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<EmployeeModel> itemList;
 private onItemClickListener listener;
    public interface onItemClickListener {
        void onItemClick(int position);
    }
    public ItemAdapter(List<EmployeeModel> itemList, onItemClickListener listener) {
        this.itemList = itemList;
        this.listener= listener;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        EmployeeModel item = itemList.get(position);
        holder.tvID.setText(String.valueOf(item.getId()));
        holder.tvName.setText(item.getName());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvID;
        TextView tvName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
