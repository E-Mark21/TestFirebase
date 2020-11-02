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


public class FragmentMainView extends Fragment implements MainContract.View {

    private MainContract.Presenter presenter;
    String d;

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

        CardNewsAdapter adapter = new CardNewsAdapter(d);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;

    }

    class CardNewsAdapter extends RecyclerView.Adapter<CardNewsAdapter.ViewHolder> {
        String name;

        public CardNewsAdapter(String d) {
            this.name = d;
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
            textView.setText(d);

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

    @Override
    public void getData() {
        presenter.data();
    }
    @Override
    public void get(){

    }
}
