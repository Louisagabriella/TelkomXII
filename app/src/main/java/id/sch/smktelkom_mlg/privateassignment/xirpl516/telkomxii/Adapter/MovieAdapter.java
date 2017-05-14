package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.model.Result;

/**
 * Created by Louisa on 5/14/2017.
 */

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    Context context;
    ArrayList<Result> list;
    ISourceAdapter mISourceAdapter;


    public MovieAdapter(Context context, ArrayList<Result> list)
    {
        this.list = list;
        this.context = context;
        mISourceAdapter = (ISourceAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.lyNiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent astagfirullah = new Intent(context, detail_movie.class);
                astagfirullah.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                astagfirullah.putExtra("blog id",position);
                context.startActivity(astagfirullah);
            }
        });
        Result movie = list.get(position);
        holder.tvName.setText(movie.title);
        holder.tvDesc.setText(movie.overview);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500"+ movie.poster_path)
                .into(holder.ivPoster);
        holder.tvDate.setText(movie.release_date);
        holder.tvLanguage.setText(movie.original_language);
    }

    @Override
    public int getItemCount()
    {
        if (list != null)
            return list.size();
        return 0;
    }

    public interface ISourceAdapter
    {
        void showArticles(String title, String overview);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        TextView tvDesc;
        ImageView ivPoster;
        TextView tvDate;
        TextView tvLanguage;
        LinearLayout lyNiar;

        public ViewHolder(View itemView)
        {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            ivPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
            tvLanguage = (TextView)itemView.findViewById(R.id.textViewOriginalLanguage);
            tvDate = (TextView) itemView.findViewById(R.id.coming_textViewDate);
            lyNiar = (LinearLayout) itemView.findViewById(R.id.click);
        }
    }
}
