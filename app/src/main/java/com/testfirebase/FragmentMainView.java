package com.testfirebase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FragmentMainView extends Fragment implements MainContract.View {

    private MainContract.Presenter presenter;
    RecyclerView mRecyclerView;
    CardNewsAdapter adapter;
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private ArrayList<String> mUrl = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        downloadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_main, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        updateAdapter(mName, mDescription, mUrl);
        return mRecyclerView;
    }


    static class CardNewsAdapter extends RecyclerView.Adapter<CardNewsAdapter.ViewHolder> {
        private ArrayList<String> mName;
        private ArrayList<String> mDescription;
        private ArrayList<String> mUrl;


        public CardNewsAdapter(ArrayList mName, ArrayList mDescription, ArrayList mUrl) {
            this.mName = mName;
            this.mDescription = mDescription;
            this.mUrl = mUrl;
        }

        public void updateItem(ArrayList mName, ArrayList mDescription, ArrayList mUrl) {
            mName.clear();
            mDescription.clear();
            mUrl.clear();
            this.mName = mName;
            this.mDescription = mDescription;
            this.mUrl = mUrl;
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
            TextView name = cardView.findViewById(R.id.name);
            TextView description = cardView.findViewById(R.id.description);
            ImageView image = cardView.findViewById(R.id.image);
            name.setText(mName.get(position));
            description.setText(mDescription.get(position));
            Picasso.with(holder.itemView.getContext()).
                    load(mUrl.get(position))
                    .placeholder(R.drawable.placeholder)
                    .into(image);
        }

        @Override
        public int getItemCount() {
            return mName.size();
        }


        static class ViewHolder extends RecyclerView.ViewHolder {
            private final CardView cardView;

            public ViewHolder(@NonNull CardView v) {
                super(v);
                cardView = v;
            }
        }
    }

    @Override
    public void downloadData() {
        presenter.getData();
    }

    @Override
    public void updateAdapter(ArrayList mName, ArrayList mDescription, ArrayList mUrl) {
        if (adapter == null) {
            adapter = new CardNewsAdapter(mName, mDescription, mUrl);
            mRecyclerView.setAdapter(adapter);
        } else {
            adapter.updateItem(mName, mDescription, mUrl);
            adapter.notifyDataSetChanged();
        }
    }
}