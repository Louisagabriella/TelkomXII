package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii;

/**
 * Created by Louisa on 3/28/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBDataSource {
    //inisialiasi SQLite Database
    private SQLiteDatabase database;

    //inisialisasi kelas DBHelper
    private DBHelper dbHelper;

    //ambil semua nama kolom
    private String[] allColumns = {DBHelper.COLUMN_ID, DBHelper.COLUMN_JAM,
            DBHelper.COLUMN_NAME};

    //DBHelper diinstantiasi pada constructor
    public DBDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    //membuka/membuat sambungan baru ke database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //menutup sambungan ke database
    public void close() {
        dbHelper.close();
    }

    //method untuk create/insert barang ke database
    public datasql createBarang(String jam, String nama) {

        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_JAM, jam);
        values.put(DBHelper.COLUMN_NAME, nama);

        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);

        // setelah data dimasukkan, memanggil
        // perintah SQL Select menggunakan Cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuaikan ID = insertID
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();

        // mengubah objek pada kursor pertama tadi
        // ke dalam objek barang
        datasql newDatasql = cursorToBarang(cursor);

        // close cursor
        cursor.close();

        // mengembalikan barang baru
        return newDatasql;
    }

    private datasql cursorToBarang(Cursor cursor) {
        // buat objek datasql baru
        datasql datasql = new datasql();
        // debug LOGCAT
        Log.v("info", "The getLONG " + cursor.getLong(0));
        Log.v("info", "The setLatLng " + cursor.getString(1) + "," + cursor.getString(2));

        /* Set atribut pada objek datasql dengan
         * data kursor yang diambil dari database*/
        datasql.setId(cursor.getLong(0));
        datasql.setJamke(cursor.getString(1));
        datasql.setNama_pelajaran(cursor.getString(2));

        //kembalikan sebagai objek datasql
        return datasql;
    }

    //mengambil semua data barang
    public ArrayList<datasql> getAllBarang() {
        ArrayList<datasql> daftarDatasql = new ArrayList<datasql>();

        // select all SQL query
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukkan data barang ke
        // daftar barang
        while (!cursor.isAfterLast()) {
            datasql datasql = cursorToBarang(cursor);
            daftarDatasql.add(datasql);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return daftarDatasql;
    }

    //ambil satu barang sesuai id
    public datasql getBarang(long id) {
        datasql datasql = new datasql(); //inisialisasi datasql
        //select query
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, "_id =" + id, null, null, null, null);
        //ambil data yang pertama
        cursor.moveToFirst();
        //masukkan data cursor ke objek datasql
        datasql = cursorToBarang(cursor);
        //tutup sambungan
        cursor.close();
        //return datasql
        return datasql;
    }

    //update barang yang diedit
    public void updateBarang(datasql b) {
        //ambil id barang
        String strFilter = "_id=" + b.getId();
        //memasukkan ke content values
        ContentValues args = new ContentValues();
        //masukkan data sesuai dengan kolom pada database
        args.put(DBHelper.COLUMN_JAM, b.getJamke());
        args.put(DBHelper.COLUMN_NAME, b.getNama_pelajaran());
        //update query
        database.update(DBHelper.TABLE_NAME, args, strFilter, null);
    }
}
