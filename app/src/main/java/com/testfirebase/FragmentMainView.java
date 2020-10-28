package com.testfirebase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMainView extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_main, container, false);

        CardNewsAdapter adapter = new CardNewsAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;
    }

    static class CardNewsAdapter extends RecyclerView.Adapter<CardNewsAdapter.ViewHolder> {


        @NonNull
        @Override
        public CardNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cardmodel, parent, false);
            return new ViewHolder(cardView);
        }

        @Override
        public void onBindViewHolder(@NonNull CardNewsAdapter.ViewHolder holder, int position) {
            CardView cardView = holder.cardView;


        }

        @Override
        public int getItemCount() {
            return 3;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private CardView cardView;

            public ViewHolder(@NonNull CardView v) {
                super(v);
                cardView = v;
            }
        }
    }
}
