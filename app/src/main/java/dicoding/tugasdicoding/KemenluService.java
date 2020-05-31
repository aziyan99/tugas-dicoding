package dicoding.tugasdicoding;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KemenluService {
    @GET("kemenlu.json")
    Call<KemenluResult> getKemenlu();
}
