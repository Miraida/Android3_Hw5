package com.geek.android3_hw5.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.android3_hw5.R;
import com.geek.android3_hw5.databinding.ItemFilmsAdapterBinding;
import com.geek.android3_hw5.domain.model.Film;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
    private final Listener<String> itemListener;
    private final Listener<Film> favListener;
    private ItemFilmsAdapterBinding binding;
    private final List<Film> list;
    private final String tag;

    public FilmsAdapter(String tag, List<Film> list, Listener<String> itemListener, Listener<Film> favListener) {
        this.itemListener = itemListener;
        this.favListener = favListener;
        this.list = list;
        this.tag = tag;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemFilmsAdapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemFilmsAdapterBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.getRoot().setOnClickListener(v -> itemListener.onClick(list.get(getAdapterPosition()).getFilmId()));
            binding.itemImageView.setOnClickListener(v -> favListener.onClick(list.get(getAdapterPosition())));
        }

        public void onBind(Film film) {
            binding.itemTextView.setText(film.getTitle());
            if (tag.equals(itemView.getResources().getString(R.string.Saved)))
                binding.itemImageView.setImageResource(R.drawable.ic_selected_star);
            else
                binding.itemImageView.setImageResource(R.drawable.ic_save_alt_24);
        }
    }

    public interface Listener<ContentData> {
        void onClick(ContentData data);
    }
}
