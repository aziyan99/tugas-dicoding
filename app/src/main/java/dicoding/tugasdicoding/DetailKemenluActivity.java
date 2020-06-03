package dicoding.tugasdicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailKemenluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kemenlu);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ImageView bendera = findViewById(R.id.img_country);
        TextView namaNegara = findViewById(R.id.tv_nama_negara);
        TextView ambassador = findViewById(R.id.tv_ambassador);
        TextView alamat = findViewById(R.id.tv_alamat);
        TextView noTelp = findViewById(R.id.tv_no_telp);
        TextView fax = findViewById(R.id.tv_fax);
        TextView email = findViewById(R.id.tv_email);
        TextView web = findViewById(R.id.tv_website);


        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            Glide.with(getApplicationContext())
                    .load(getIntent().getStringExtra("URL_BENDERA"))
                    .into(bendera);
            namaNegara.setText(bundle.getString("NAMA_NEGARA"));
            ambassador.setText(bundle.getString("AMBASSADOR"));
            alamat.setText(bundle.getString("ALAMAT"));
            noTelp.setText(bundle.getString("NO_TELP"));
            fax.setText(bundle.getString("FAX"));
            email.setText(bundle.getString("EMAIL"));
            web.setText(bundle.getString("WEB"));

        }else{
            Glide.with(getApplicationContext())
                    .load(getIntent().getStringExtra("URL_BENDERA"))
                    .into(bendera);
            namaNegara.setText(getIntent().getStringExtra("NAMA_NEGARA"));
            ambassador.setText(getIntent().getStringExtra("AMBASSADOR"));
            alamat.setText(getIntent().getStringExtra("ALAMAT"));
            noTelp.setText(getIntent().getStringExtra("NO_TELP"));
            fax.setText(getIntent().getStringExtra("FAX"));
            email.setText(getIntent().getStringExtra("EMAIL"));
            web.setText(getIntent().getStringExtra("WEB"));
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}