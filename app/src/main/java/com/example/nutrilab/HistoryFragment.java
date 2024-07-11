package com.example.nutrilab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutrilab.model.HistoryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<HistoryResponse.HistoryData> historyList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.history_recyclervw);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        historyList = new ArrayList<>();
        adapter = new MyAdapter(historyList);
        recyclerView.setAdapter(adapter);

        ApiService apiService = RetrofitClient.getApiService();
        String userId = "5fb3aa47-f976-4781-9c95-a6e65e8d9194";
        Call<HistoryResponse> call = apiService.getUserHistory(userId);

        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if (response.isSuccessful() && response.body() !=null) {
                    historyList.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                Log.e("HistoryFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
