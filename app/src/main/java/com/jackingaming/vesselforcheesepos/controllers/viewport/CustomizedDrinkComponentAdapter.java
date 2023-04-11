package com.jackingaming.vesselforcheesepos.controllers.viewport;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_in.LineCupWithDrizzle;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milks.Milk;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweeteners.liquids.sauces.Sauce;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweeteners.liquids.syrups.Syrup;

import java.util.List;

public class CustomizedDrinkComponentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = "CustomizedDrinkComponentAdapter";

    public interface CustomizedDrinkComponentAdapterListener {
        void onCustomizedDrinkComponentClicked(int position, View view);

        void onCustomizedDrinkComponentLongClicked(int position);
    }

    private CustomizedDrinkComponentAdapterListener listener;

    private List<DrinkComponent> customizedDrinkComponents;

    public CustomizedDrinkComponentAdapter(List<DrinkComponent> customizedDrinkComponents,
                                           CustomizedDrinkComponentAdapterListener listener) {
        this.customizedDrinkComponents = customizedDrinkComponents;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolderCustomizedDrinkComponent(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DrinkComponent customizedDrinkComponent = customizedDrinkComponents.get(position);
        ViewHolderCustomizedDrinkComponent viewHolderCustomizedDrinkComponent = (ViewHolderCustomizedDrinkComponent) holder;
        viewHolderCustomizedDrinkComponent.bind(customizedDrinkComponent);
    }

    @Override
    public int getItemCount() {
        return customizedDrinkComponents.size();
    }

    public class ViewHolderCustomizedDrinkComponent extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvCustomizedDrinkComponent;

        public ViewHolderCustomizedDrinkComponent(@NonNull View itemView) {
            super(itemView);
            tvCustomizedDrinkComponent = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(DrinkComponent drinkComponent) {
            String nameDrinkComponent = drinkComponent.getClass().getSimpleName() + " ";
            if (drinkComponent instanceof LineCupWithDrizzle) {
                nameDrinkComponent += ((LineCupWithDrizzle) drinkComponent).getSauceType().name();
            } else if (drinkComponent instanceof Milk) {
                nameDrinkComponent += ((Milk) drinkComponent).getType().name();
            } else if (drinkComponent instanceof Sauce) {
                nameDrinkComponent += ((Sauce) drinkComponent).getType().name();
            } else if (drinkComponent instanceof Syrup) {
                nameDrinkComponent += ((Syrup) drinkComponent).getType().name();
            } else {
                nameDrinkComponent += "ViewHolderCustomizedDrinkComponent.bind(DrinkComponent) did not specify";
            }
            tvCustomizedDrinkComponent.setText(nameDrinkComponent);
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in nested-RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onCustomizedDrinkComponentClicked(position, view);
                }
            }
        }

        @SuppressLint("LongLogTag")
        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in nested-RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onCustomizedDrinkComponentLongClicked(position);
                    return true;
                }
            }
            return false;
        }
    }
}
