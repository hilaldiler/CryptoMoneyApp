package com.hilal.cryptomoneyapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.hilal.cryptomoneyapp.R;
import com.hilal.cryptomoneyapp.model.Crypto;
import com.hilal.cryptomoneyapp.svg.GlideApp;
import com.hilal.cryptomoneyapp.svg.SvgSoftwareLayerSet;
import com.bumptech.glide.module.AppGlideModule;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.MyViewHolder>{
     ArrayList<Crypto> cryptoList;
     OnItemClickListener clickListener;
     Context context;
     RequestBuilder requestBuilder;
     private static final int ITEM = 0;
     private static final int LOADING = 1;
     private boolean isLoadingAdded = false;


    public CryptoAdapter(Context context, OnItemClickListener clickListener) {
        cryptoList = new ArrayList<>();
        this.clickListener = clickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_crypto_card, viewGroup, false);
        final MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(cryptoList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return cryptoList == null ? 0 : cryptoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageIcon;
        TextView cryptoSymbol;
        TextView cryptoPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Crypto crypto, int position) {
            try {
                imageIcon = itemView.findViewById(R.id.cryptoImage);
                cryptoSymbol = itemView.findViewById(R.id.cryptoSymbol);
                cryptoPrice = itemView.findViewById(R.id.cryptoPrice);


                cryptoSymbol.setText(crypto.data.getCoins().get(position).getSymbol());
                cryptoPrice.setText(String.format("%.2f", crypto.getData().getCoins().get(position).getPrice()));
                requestBuilder =

                        GlideApp.with(context)
                                .as(PictureDrawable.class)
                                .transition(withCrossFade())
                                .listener(new SvgSoftwareLayerSet());
                Uri uri = Uri.parse(crypto.getData().getCoins().get(position).getIconUrl());
                requestBuilder.load(uri).into(imageIcon);

                if (crypto.getData().getCoins().get(position).getColor() != null) {
                    cryptoSymbol.setTextColor(Color.parseColor(crypto.getData().getCoins().get(position).getColor().toUpperCase()));
                    cryptoPrice.setTextColor(Color.parseColor(crypto.getData().getCoins().get(position).getColor().toUpperCase()));

                }
            }catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }

        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    @Override
    public int getItemViewType(int position) {
        return (position == cryptoList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    public void addAll(List<Crypto> list) {
        cryptoList.addAll(list);
        notifyItemInserted(cryptoList.size() - 1);
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = cryptoList.size() - 1;
        Crypto item = getItem(position);

        if (item != null) {
            cryptoList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Crypto getItem(int position) {
        return cryptoList.get(position);
    }

}





