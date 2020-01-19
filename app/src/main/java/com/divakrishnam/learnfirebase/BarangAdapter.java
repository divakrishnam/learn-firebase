package com.divakrishnam.learnfirebase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder>{

    private ArrayList<Barang> mList;
    private Context mContext;
    FirebaseDataListener listener;

    public BarangAdapter(ArrayList<Barang> list, Context context){
        mList = list;
        mContext = context;
        listener = (LihatActivity) context;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        BarangViewHolder mViewHolder = new BarangViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, final int position) {
        holder.tvNamaBarang.setText(mList.get(position).getNama());
        holder.tvNamaBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.tvNamaBarang.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.dialog_barang);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button btnUbah = dialog.findViewById(R.id.btn_ubah);
                Button btnHapus = dialog.findViewById(R.id.btn_hapus);

                btnUbah.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                mContext.startActivity(TambahActivity.getActIntent((Activity) mContext).putExtra("data", mList.get(position)));
                            }
                        }
                );

                btnHapus.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(mList.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BarangViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaBarang;
        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaBarang = itemView.findViewById(R.id.tv_namabarang);
        }
    }

    public interface FirebaseDataListener{
        void onDeleteData(Barang barang, int position);
    }
}
