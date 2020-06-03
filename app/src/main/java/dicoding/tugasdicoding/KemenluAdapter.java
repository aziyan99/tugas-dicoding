package dicoding.tugasdicoding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class KemenluAdapter extends RecyclerView.Adapter<KemenluAdapter.MyViewHolder> {

    ArrayList<KemenluData> result;
    Context context;

    public KemenluAdapter(Context context, ArrayList<KemenluData> result){
        super();
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public KemenluAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.row_data, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KemenluAdapter.MyViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(result.get(position).getBendera())
                .apply(new RequestOptions().override(55,55))
                .into(holder.bendera);
        holder.tvNamaNegara.setText(result.get(position).getNamaNegara());
        holder.tvAmbassador.setText(result.get(position).getAmbassador());
        holder.itemView.setOnClickListener(v -> {
            //Toast.makeText(v.getContext(), result.get(position).getAmbassador(), Toast.LENGTH_SHORT).show();
            Intent detailKemenlu = new Intent(v.getContext(), DetailKemenluActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("NAMA_NEGARA", result.get(position).getNamaNegara());
            bundle.putString("URL_BENDERA", result.get(position).getBendera());
            bundle.putString("AMBASSADOR", result.get(position).getAmbassador());
            bundle.putString("ALAMAT", result.get(position).getAlamat());
            bundle.putString("NO_TELP", result.get(position).getNoTelp());
            bundle.putString("FAX", result.get(position).getFax());
            bundle.putString("EMAIL", result.get(position).getEmail());
            bundle.putString("WEB", result.get(position).getWebsite());

            detailKemenlu.putExtras(bundle);
            v.getContext().startActivity(detailKemenlu);
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvAmbassador, tvNamaNegara;
        ImageView bendera;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAmbassador = itemView.findViewById(R.id.ambassador_name);
            tvNamaNegara = itemView.findViewById(R.id.contry_name);
            bendera = itemView.findViewById(R.id.country_flag);
        }
    }
}
