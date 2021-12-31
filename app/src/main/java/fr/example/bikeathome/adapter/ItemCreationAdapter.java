package fr.example.bikeathome.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.example.bikeathome.Item;
import fr.example.bikeathome.MainActivity;
import fr.example.bikeathome.R;
import fr.example.bikeathome.Session;

public class ItemCreationAdapter extends RecyclerView.Adapter<ItemCreationAdapter.ItemCreationViewHolder> {
    public MainActivity context;
    private Session session;


    public ItemCreationAdapter(MainActivity context, Session session1){
        this.context = context;
        this.session = session1;
    }




    public class ItemCreationViewHolder extends RecyclerView.ViewHolder {
        private View itemCreation;
        public TextView dureeItem;
        public TextView puissanceItem;
        public TextView trminItem;
        public ImageView deleteItem;

        public ItemCreationViewHolder(@NonNull View itemView){
            super(itemView);
            this.itemCreation = itemView.findViewById(R.id.item_creation);
            this.dureeItem = itemView.findViewById(R.id.text_time_item);
            this.puissanceItem = itemView.findViewById(R.id.text_power_item);
            this.trminItem = itemView.findViewById(R.id.text_trmin_item);
            this.deleteItem = itemView.findViewById(R.id.delete_item_creation);
        }

    }




    @NonNull
    @Override
    public ItemCreationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_creation, parent, false);
        return new ItemCreationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCreationViewHolder holder, int position) {
        //mettre a jour item
        Item currentItem = this.session.getItems().get(position);
        int size = this.session.getItems().size();
        holder.dureeItem.setText(String.valueOf(currentItem.getDuree() / 60));
        holder.puissanceItem.setText(String.valueOf(currentItem.getPuissance()));
        holder.trminItem.setText(String.valueOf(currentItem.getFrequence()));

        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(currentItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.session.getItems().size();
    }


    public void removeItem(Item item){
        this.session.getItems().remove(item);
        this.notifyItemRemoved(this.session.getItems().indexOf(item));
        this.context.dbM.supprimerItem(item.getId_item());
    }


}
