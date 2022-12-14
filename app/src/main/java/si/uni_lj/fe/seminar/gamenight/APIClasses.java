package si.uni_lj.fe.seminar.gamenight;



import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://20.86.63.141:5000/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
class IgreResponse {
    private final List<Igra> igreResponse;

     IgreResponse(List<Igra> igreResponse) {
        this.igreResponse = igreResponse;
    }

    public Igra getPrva(){
        return (Igra) igreResponse.get(0);
    }
}
class Igra {
    @SerializedName("ime_igre")
    private String ime_igre;
    @SerializedName("ocena")
    private String ocena;
    @SerializedName("tezavnost")
    private String tezavnost;
    @SerializedName("min_stevilo_igralcev")
    private int min_stevilo_igralcev;
    @SerializedName("max_stevilo_igralcev")
    private int max_stevilo_igralcev;
    @SerializedName("dolzina_igre")
    private String dolzina_igre;
    @SerializedName("slika_url")
    private String slika_url;

    public void setIgra(String ime_igre, String ocena, String tezavnost, int min_stevilo_igralcev, int max_stevilo_igralcev, String dolzina_igre, String slika_url){

        this.ime_igre = ime_igre;
        this.ocena = ocena;
        this.tezavnost = tezavnost;
        this.min_stevilo_igralcev = min_stevilo_igralcev;
        this.max_stevilo_igralcev = max_stevilo_igralcev;
        this.dolzina_igre = dolzina_igre;
        this.slika_url = slika_url;
    }

    public String getIme_igre() {
        return this.ime_igre;
    }

    public String getOcena() {
        return ocena;
    }

    public String getTezavnost() {
        return tezavnost;
    }

    public int getMin_stevilo_igralcev() {
        return min_stevilo_igralcev;
    }

    public int getMax_stevilo_igralcev() {
        return max_stevilo_igralcev;
    }

    public String getDolzina_igre() {
        return dolzina_igre;
    }

    public String getSlika_url() {
        return slika_url;
    }
}
class Dogodek {
    private String ime_skupine;
    private String datum;
    private String odigrana_igra;
    private String zmagovalec;

    public void setDogodek(String ime_skupine, String datum, String odigrana_igra, String zmagovalec){
        this.ime_skupine = ime_skupine;
        this.datum = datum;
        this.odigrana_igra = odigrana_igra;
        this.zmagovalec = zmagovalec;
    }
    public String getIme_skupine() {
        return ime_skupine;
    }

    public String getDatum() {
        return datum;
    }

    public String getOdigrana_igra() {
        return odigrana_igra;
    }

    public String getZmagovalec() {
        return zmagovalec;
    }
}
class LoginPodatki {
    private String token;
    private String duration;

    public void setLogin(JSONObject response) {
        try {
            token = response.getString("token");
            duration = response.getString("duration");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getToken() {
        return token;
    }
}
class Uporabnik {
    private String ime;
    private String priimek;
    private String uporabnisko_ime;
    private String geslo;
    private String email;

    public void setUser(String ime, String priimek, String uporabnisko_ime, String geslo, String email){
        this.ime = ime;
        this.priimek = priimek;
        this.uporabnisko_ime = uporabnisko_ime;
        this.geslo = geslo;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public String getUporabnisko_ime() {
        return uporabnisko_ime;
    }

    public String getGeslo() {
        return geslo;
    }

    public String getEmail() {
        return email;
    }
}







