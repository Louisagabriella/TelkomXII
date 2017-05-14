package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.R;

public class detail_movie extends AppCompatActivity {
//    ArrayList<Result> mList = new ArrayList<>();
//    MovieAdapter mAdapter;
//    String URL_DATA = "https://api.themoviedb.org/3/movie/now_playing?api_key=c1def69816c46d77a006c1a6a6de98c0";
//    public TextView textViewJudul;
//    public TextView textViewDate;
//    public TextView textViewOverview;
//    public ImageView imageViewPoster;
//    public TextView textViewVoteCount;
//    public String url;
//    private Integer mKey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
//
//        mKey = getIntent().getExtras().getInt("blog id");
//        loadRecycleViewData();
//
//        textViewJudul = (TextView) findViewById(R.id.textViewName);
//        textViewDate = (TextView) findViewById(R.id.coming_textViewDate);
//        textViewOverview = (TextView) findViewById(R.id.textViewDesc);
//        imageViewPoster = (ImageView) findViewById(R.id.imageViewPoster);
//        textViewVoteCount = (TextView) findViewById(R.id.textViewVoteCount);
//
//    }

//    private void loadRecycleViewData() {
//        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=c1def69816c46d77a006c1a6a6de98c0";
//
//        GsonGetRequest<SourcesResponse> myRequest = new GsonGetRequest<SourcesResponse>
//                (url, SourcesResponse.class, null, new Response.Listener<SourcesResponse>() {
//
//                    @Override
//                    public void onResponse(SourcesResponse response) {
//                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
//
//                        mList.addAll(response.results);
//                        mAdapter.notifyDataSetChanged();
//
//
//
//                        setTitle("");
//                        textViewDate.setText("release_date");
//                        textViewJudul.setText("title");
//                        textViewOverview.setText("overview");
//                        String url=("url");
//                        Glide.with(detail_movie.this)
//                                .load("http://image.tmdb.org/t/p/w500"+("poster_path"))
//                                .into(imageViewPoster);
//                    }
//
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("FLOW", "onErrorResponse: ", error);
//                    }
//                });
//        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }
}
