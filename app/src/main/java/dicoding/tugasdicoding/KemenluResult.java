package dicoding.tugasdicoding;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KemenluResult {
    @SerializedName("result")
    ArrayList<KemenluData> result;

    public ArrayList<KemenluData> getResult(){
        return result;
    }

    public void setResult(ArrayList<KemenluData> result){
        this.result = result;
    }
}
