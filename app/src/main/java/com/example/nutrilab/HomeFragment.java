package com.example.nutrilab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Data Dummy
        List<Item> items = new ArrayList<>();
        items.add(new Item("Salad Buah", 50, 75, 80, 30, 10));
        items.add(new Item("Pasta Primavera", 300, 15, 60, 10, 5));
        items.add(new Item("Grilled Chicken Salad", 200, 25, 15, 10, 8));
        items.add(new Item("Salad Buah", 50, 75, 80, 30, 10));
        items.add(new Item("Pasta Primavera", 300, 15, 60, 10, 5));
        items.add(new Item("Grilled Chicken Salad", 200, 25, 15, 10, 8));

        // RecyclerView setup
        RecyclerView recyclerView = view.findViewById(R.id.history_recyclervw);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MyAdapter(requireContext(), items));

        return view;
    }
}
