package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii;

import android.app.Activity;
import android.os.Bundle;

public class detail_movie extends Activity {
//    implements OnClickListener
//    //inisilisasi elemen-elemen pada layout
//    private Button buttonSubmit;
//    private TextView edJam;
//    private TextView edNama;
//    //inisialisasi kontroller/Data Source
//    private DBDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

//        buttonSubmit = (Button) findViewById(R.id.button);
//        buttonSubmit.setOnClickListener(this);
//        edNama = (TextView) findViewById(R.id.textViewDesc);
//        edJam = (TextView) findViewById(R.id.textViewName);
//
//        // instanstiasi kelas DBDataSource
//        dataSource = new DBDataSource(this);
//
//        //membuat sambungan baru ke database
//        dataSource.open();
    }

//    //KETIKA Tombol Submit Diklik
//    @Override
//    public void onClick(View v) {
//        // Inisialisasi data datasql
//        String jam = null;
//        String nama = null;
//        @SuppressWarnings("unused")
//
//        //inisialisasi datasql baru (masih kosong)
//                datasql datasql = null;
//        if (edNama.getText() != null && edJam.getText() != null) {
//            /* jika field nama, merk, dan harga tidak kosong
//             * maka masukkan ke dalam data datasql*/
//            jam = edJam.getText().toString();
//            nama = edNama.getText().toString();
//        }
//
//        switch (v.getId()) {
//            case R.id.button:
//                // insert data datasql baru
//                datasql = dataSource.createBarang(jam, nama);
//
//                //konfirmasi kesuksesan
//                Toast.makeText(this, "Data Berhasil Ditambahkan\n" +
//                        "Jam Ke-" + datasql.getJamke() +
//                        "Nama Pelajaran" + datasql.getNama_pelajaran(), Toast.LENGTH_LONG).show();
//                break;
//        }
//
//    }
}
