package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.database.Barang;
import id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii.database.DBDataSource;

public class detail_movie extends Activity implements OnClickListener {
    public String url = "http://image.tmdb.org/t/p/w500";
    public String title, desc, pic, gambar, tanggal;
    private Button buttonSubmit;
    private TextView edNama;
    private TextView edMerk;
    private TextView edHarga;
    //inisialisasi kontroller/Data Source
    private DBDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        pic = intent.getStringExtra("poster_path");
        desc = intent.getStringExtra("overview");
        tanggal = intent.getStringExtra("original_language");
        setTitle(title);
        gambar = url + pic;
        buttonSubmit = (Button) findViewById(R.id.button);
        buttonSubmit.setOnClickListener(this);
        ImageView detail = (ImageView) findViewById(R.id.imageViewPoster);
        TextView deskripsi = (TextView) findViewById(R.id.textViewOverview);
        Glide.with(this).load(gambar)
                .crossFade()
                .centerCrop()
                .placeholder(R.drawable.ic_arrow_downward_black_24dp)
                .error(R.drawable.ic_arrow_downward_black_24dp)
                .into(detail);
        deskripsi.setText(desc);
        edNama = (TextView) findViewById(R.id.textViewOverview);
        edHarga = (TextView) findViewById(R.id.textViewName);
        edMerk = (TextView) findViewById(R.id.textViewDesc);
        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSource(this);

        //membuat sambungan baru ke database
        dataSource.open();
    }

    @Override
    public void onClick(View v) {
        // Inisialisasi data barang
        String nama = null;
        String merk = null;
        String harga = null;
        @SuppressWarnings("unused")

        //inisialisasi barang baru (masih kosong)
                Barang barang = null;
        if (edNama.getText() != null && edMerk.getText() != null && edHarga.getText() != null) {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            nama = edNama.getText().toString();
            merk = edMerk.getText().toString();
            harga = edHarga.getText().toString();
        }

        switch (v.getId()) {
            case R.id.button:
                // insert data barang baru
                barang = dataSource.createBarang(nama, merk, harga);

                //konfirmasi kesuksesan
                Toast.makeText(this, "masuk Barang\n" +
                        "nama" + barang.getNama_barang() +
                        "merk" + barang.getMerk_barang() +
                        "harga" + barang.getHarga_barang(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
