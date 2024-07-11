package com.example.nutrilab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutrilab.model.HistoryResponse;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HistoryViewHolder> {
    private List<HistoryResponse.HistoryData> historyList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(HistoryResponse.HistoryData historyData);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        public TextView tvFoodName, tvFoodInformation, tvCalorie, tvCarbohydrate, tvProteins, tvFat, tvSugar;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            tvFoodName = itemView.findViewById(R.id.tvfood_name);
            tvFoodInformation = itemView.findViewById(R.id.tvfood_information);
            tvCalorie = itemView.findViewById(R.id.tvCalories);
            tvCarbohydrate = itemView.findViewById(R.id.tvCarbohydrates);
            tvProteins = itemView.findViewById(R.id.tvProteins);
            tvFat = itemView.findViewById(R.id.tvFat);
            tvSugar = itemView.findViewById(R.id.tvGlucose);
        }

        public void bind(final HistoryResponse.HistoryData historyData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(historyData);
                }
            });
        }
    }

    public MyAdapter(List<HistoryResponse.HistoryData> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new HistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        HistoryResponse.HistoryData historyData = historyList.get(position);
        holder.tvFoodName.setText(historyData.getFoodName());
        holder.tvFoodInformation.setText(historyData.getFoodInformation());
        holder.tvCalorie.setText(String.valueOf(historyData.getTotalCalorie()));
        holder.tvCarbohydrate.setText(String.valueOf(historyData.getTotalCarbohydrate()));
        holder.tvProteins.setText(String.valueOf(historyData.getTotalProtein()));
        holder.tvFat.setText(String.valueOf(historyData.getTotalFat()));
        holder.tvSugar.setText(String.valueOf(historyData.getTotalSugar()));

        holder.bind(historyData, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
}
