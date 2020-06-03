package dicoding.tugasdicoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {
    Button githubBtn;
    Button showInfoBtn;
    private static final String textInfo = "Aplikasi Data Duta Luar Negeri Indonesia.\nInformasi lengkap bisa kunjungi link projek di github.\nTerima kasih :)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        githubBtn = findViewById(R.id.btn_github);
        githubBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/aziyan99/tugas-dicoding"));
            startActivity(intent);
        });

        showInfoBtn = findViewById(R.id.btn_info);
        showInfoBtn.setOnClickListener(v -> showInfo());
    }

    private void showInfo(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Info");

        alertDialogBuilder
                .setMessage(textInfo)
                .setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}