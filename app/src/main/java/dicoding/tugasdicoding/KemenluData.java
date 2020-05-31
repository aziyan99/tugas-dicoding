package dicoding.tugasdicoding;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KemenluData {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("namaNegara")
    @Expose
    private String namaNegara;

    @SerializedName("bendera")
    @Expose
    private String bendera;

    @SerializedName("ambassador")
    @Expose
    private String ambassador;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("noTelp")
    @Expose
    private String noTelp;

    @SerializedName("fax")
    @Expose
    private String fax;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("body")
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public String getBendera() {
        return bendera;
    }

    public void setBendera(String bendera) {
        this.bendera = bendera;
    }

    public String getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(String ambassador) {
        this.ambassador = ambassador;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
