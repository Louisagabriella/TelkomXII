package id.sch.smktelkom_mlg.privateassignment.xirpl516.telkomxii;

/**
 * Created by Louisa on 3/28/2017.
 */

public class datasql {
    private long id;
    private String jamke;
    private String nama_pelajaran;

    public datasql() {

    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getJamke() {
        return jamke;
    }

    public void setJamke(String jamke) {
        this.jamke = jamke;
    }

    public String getNama_pelajaran() {
        return nama_pelajaran;
    }

    public void setNama_pelajaran(String nama_pelajaran) {
        this.nama_pelajaran = nama_pelajaran;
    }

    @Override
    public String toString() {
        return "Jam Ke- " + jamke + "   " + nama_pelajaran;
    }
}
