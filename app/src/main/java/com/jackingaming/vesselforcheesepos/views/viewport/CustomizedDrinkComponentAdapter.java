package com.jackingaming.vesselforcheesepos.views.viewport;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.components.drinks.add_ins.AddInsOptions;

import java.util.List;

public class CustomizedDrinkComponentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CustomizedDrinkComponentAdapter.class.getSimpleName();

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
        View view = inflater.inflate(R.layout.listitem_customized_drink_component, parent, false);
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

    public void addDrinkComponent(DrinkComponent drinkComponent) {
        int indexNewEnd = customizedDrinkComponents.size();
        customizedDrinkComponents.add(drinkComponent);
        notifyItemInserted(indexNewEnd);
    }

    public void removeDrinkComponent(int indexSelected) {
        customizedDrinkComponents.remove(indexSelected);
        notifyItemRemoved(indexSelected);
    }

    public class ViewHolderCustomizedDrinkComponent extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;

        public ViewHolderCustomizedDrinkComponent(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(DrinkComponent drinkComponent) {
            // TODO: move parsing to a method in Menu that returns a String to display
            if (drinkComponent instanceof AddInsOptions) {
                Log.i(TAG, "bind(DrinkComponent) drinkComponent instanceof AddInsOptions");
                AddInsOptions addInsOptions = (AddInsOptions) drinkComponent;
                if (addInsOptions.getLineTheCup()[0] != null || addInsOptions.getLineTheCup()[1] != null) {
                    Log.i(TAG, "bind(DrinkComponent) addInsOptions.getLineTheCup() has something in the first or second element (possibly both)");
                    AddInsOptions.LineTheCup[] lineTheCup = addInsOptions.getLineTheCup();
                    if (lineTheCup[0] != null && lineTheCup[1] != null) {
                        String nameDrinkComponent = "LineTheCup: " + lineTheCup[0].name() +
                                " AND " + lineTheCup[1].name();
                        tvName.setText(nameDrinkComponent);
                    } else if (lineTheCup[0] != null) {
                        String nameDrinkComponent = "LineTheCup: " + lineTheCup[0].name();
                        tvName.setText(nameDrinkComponent);
                    } else if (lineTheCup[1] != null) {
                        String nameDrinkComponent = "LineTheCup: " + lineTheCup[1].name();
                        tvName.setText(nameDrinkComponent);
                    }
                } else if (addInsOptions.getIce() != null) {
                    Log.i(TAG, "bind(DrinkComponent) addInsOptions.getIce() != null");
                    AddInsOptions.Ice ice = addInsOptions.getIce();
                    String nameDrinkComponent = "Ice: " + ice.name();
                    tvName.setText(nameDrinkComponent);
                }
            } else {
                String nameDrinkComponent = drinkComponent.getClass().getSimpleName();
                tvName.setText(nameDrinkComponent);
            }
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
