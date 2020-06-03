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
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
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
