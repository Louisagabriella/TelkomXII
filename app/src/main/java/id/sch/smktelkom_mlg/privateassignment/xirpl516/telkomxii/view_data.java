package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii;

import android.app.Dialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class view_data extends ListActivity implements OnItemLongClickListener {

    //inisialisasi kontroller
    private DBDataSource dataSource;

    //inisialisasi arraylist
    private ArrayList<datasql> values;
    private Button editButton;
    private Button delButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        dataSource = new DBDataSource(this);
        // buka kontroller
        dataSource.open();

        // ambil semua data barang
        values = dataSource.getAllBarang();

        // masukkan data barang ke array adapter
        ArrayAdapter<datasql> adapter = new ArrayAdapter<datasql>(this,
                android.R.layout.simple_list_item_1, values);

        // set adapter pada list
        setListAdapter(adapter);

        // mengambil listview untuk diset onItemLongClickListener
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setOnItemLongClickListener(this);
    }

    //apabila ada long click
    @Override
    public boolean onItemLongClick(final AdapterView<?> adapter, View v, int pos,
                                   final long id) {

        //tampilkan alert dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_view);
        dialog.setTitle("Pilih Aksi");
        dialog.show();
        final datasql b = (datasql) getListAdapter().getItem(pos);
        editButton = (Button) dialog.findViewById(R.id.button_edit_data);

        //apabila tombol edit diklik
        editButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        switchToEdit(b.getId());
                        dialog.dismiss();
                    }
                }
        );
        return true;
    }

    //method untuk edit data
    public void switchToEdit(long id) {
        datasql b = dataSource.getBarang(id);
        Bundle bun = new Bundle();
        bun.putLong("id", b.getId());
        bun.putString("nama", b.getNama_pelajaran());
        bun.putString("harga", b.getJamke());
    }

    //method yang dipanggil ketika edit data selesai
    public void finale() {
        view_data.this.finish();
        dataSource.close();
    }

    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}