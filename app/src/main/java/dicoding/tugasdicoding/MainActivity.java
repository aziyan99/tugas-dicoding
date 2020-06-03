package dicoding.tugasdicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvKemenlu;
    public static final String BASE_URL = "https://raw.githubusercontent.com/aziyan99/json-data-serve/master/kemenlu/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }


        rvKemenlu = findViewById(R.id.rv_data);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvKemenlu.setLayoutManager(layoutManager);
        rvKemenlu.setHasFixedSize(true);
        getKemenluData();
    }

    @Override
    protected void onResume(){
        super.onResume();
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null &&
                networkInfo.isConnectedOrConnecting();
        if(!isConnected){
            Toast toast = Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            rvKemenlu = findViewById(R.id.rv_data);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            rvKemenlu.setLayoutManager(layoutManager);
            rvKemenlu.setHasFixedSize(true);
            getKemenluData();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.profile, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.goToProfilePage) {
            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
            return true;
        }
        return false;
    }

    void getKemenluData(){

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null &&
                networkInfo.isConnectedOrConnecting();
        if(!isConnected){
            Toast toast = Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_LONG);
            toast.show();
        }else {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            KemenluService service = retrofit.create(KemenluService.class);
            Call<KemenluResult> getKemenlu = service.getKemenlu();
            getKemenlu.enqueue(new Callback<KemenluResult>() {
                @Override
                public void onResponse(Call<KemenluResult> call, Response<KemenluResult> response) {
                    KemenluAdapter adapter = new KemenluAdapter(MainActivity.this, response.body().getResult());
                    adapter.notifyDataSetChanged();
                    rvKemenlu.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<KemenluResult> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }

}
