package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.study;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mockingbird.spinkevich.newwords.R;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private List<WordEntity> words;

    public void setWords(List<WordEntity> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.study_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(words.get(position));
    }

    @Override
    public int getItemCount() {
        if (words == null) {
            return 0;
        }
        return words.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.word)
        TextView word;
        @BindView(R.id.translation)
        TextView translation;
        @BindView(R.id.translate_direction)
        TextView translate_direction;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bind(WordEntity wordEntity) {
            word.setText(wordEntity.getWord());
            translation.setText(wordEntity.getTranslation());
            translate_direction.setText(wordEntity.getTranslateDirection());
        }
    }
}
