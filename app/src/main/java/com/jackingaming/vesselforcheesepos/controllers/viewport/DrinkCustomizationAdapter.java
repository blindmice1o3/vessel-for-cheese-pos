package com.jackingaming.vesselforcheesepos.controllers.viewport;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.Customization;
import com.jackingaming.vesselforcheesepos.models.drinks.customizations.DrinkCustomization;

import java.util.List;

public class DrinkCustomizationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = "DrinkCustomizationAdapter";

    public interface DrinkCustomizationAdapterListener {
        void onDrinkCustomizationClicked(int position, View view);

        void onDrinkCustomizationLongClicked(int position);
    }

    private DrinkCustomizationAdapterListener listener;

    private List<DrinkCustomization> drinkCustomizations;

    public DrinkCustomizationAdapter(List<DrinkCustomization> drinkCustomizations,
                                     DrinkCustomizationAdapterListener listener) {
        this.drinkCustomizations = drinkCustomizations;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolderCustomization(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Customization customization = drinkCustomizations.get(position);
        ViewHolderCustomization viewHolderCustomization = (ViewHolderCustomization) holder;
        viewHolderCustomization.bind(customization);
    }

    @Override
    public int getItemCount() {
        return drinkCustomizations.size();
    }

    public DrinkCustomizationAdapterListener getListener() {
        return listener;
    }

    public class ViewHolderCustomization extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvCustomization;

        public ViewHolderCustomization(@NonNull View itemView) {
            super(itemView);
            tvCustomization = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Customization customization) {
            tvCustomization.setText(customization.getName());
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in nested-RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onDrinkCustomizationClicked(position, view);
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
                    listener.onDrinkCustomizationLongClicked(position);
                    return true;
                }
            }
            return false;
        }
    }
}
