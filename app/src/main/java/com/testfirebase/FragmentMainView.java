package com.testfirebase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FragmentMainView extends Fragment implements MainContract.View {

    private MainContract.Presenter presenter;
    ArrayList mName = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_main, container, false);

        CardNewsAdapter adapter = new CardNewsAdapter(mName);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;

    }

    private void updateUI(CardNewsAdapter adapter) {
        adapter.updateItem(mName);
    }


    class CardNewsAdapter extends RecyclerView.Adapter<CardNewsAdapter.ViewHolder> {
        ArrayList<String> mName;


        public CardNewsAdapter(ArrayList<String> mName) {
            this.mName = mName;
        }

        public void updateItem(ArrayList mName) {
            mName.clear();
            this.mName = mName;
            notifyDataSetChanged();
        }

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

            TextView textView = cardView.findViewById(R.id.name);
            for (String name : mName) {
                textView.setText(name);
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private final CardView cardView;

            public ViewHolder(@NonNull CardView v) {
                super(v);
                cardView = v;
            }
        }
    }

    @Override
    public void getData() {
        mName = presenter.data();
    }

    @Override
    public void updateAdapter(ArrayList mList) {
        updateUI( new  CardNewsAdapter (mList));
    }
}