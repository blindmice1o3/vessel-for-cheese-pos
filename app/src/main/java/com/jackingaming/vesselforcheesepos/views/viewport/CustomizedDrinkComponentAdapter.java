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
import com.jackingaming.vesselforcheesepos.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.refresher_base_options.RefresherBaseOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesepos.models.components.drinks.topping_options.ToppingOptions;

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
            // AddInOptions
            if (drinkComponent instanceof AddInsOptions) {
                AddInsOptions addInsOptions = (AddInsOptions) drinkComponent;
                if (addInsOptions.getLineTheCup() != null) {
                    String nameDrinkComponent = AddInsOptions.LineTheCup.class.getSimpleName() + ": " + addInsOptions.getLineTheCup().name();
                    tvName.setText(nameDrinkComponent);
                } else if (addInsOptions.getMilkCreamer() != null) {
                    String nameDrinkComponent = AddInsOptions.MilkCreamer.class.getSimpleName() + ": " + addInsOptions.getMilkCreamer().name();
                    tvName.setText(nameDrinkComponent);
                } else if (addInsOptions.getRoom() != null) {
                    String nameDrinkComponent = AddInsOptions.Room.class.getSimpleName() + ": " + addInsOptions.getRoom().name();
                    tvName.setText(nameDrinkComponent);
                } else if (addInsOptions.getPowder() != null) {
                    String nameDrinkComponent = AddInsOptions.Powder.class.getSimpleName() + ": " + addInsOptions.getPowder().name();
                    tvName.setText(nameDrinkComponent);
                } else if (addInsOptions.getWater() != null) {
                    String nameDrinkComponent = AddInsOptions.Water.class.getSimpleName() + ": " + addInsOptions.getWater().name();
                    tvName.setText(nameDrinkComponent);
                } else if (addInsOptions.getIce() != null) {
                    String nameDrinkComponent = AddInsOptions.Ice.class.getSimpleName() + ": " + addInsOptions.getIce().name();
                    tvName.setText(nameDrinkComponent);
                } else if (addInsOptions.getFruit() != null) {
                    String nameDrinkComponent = AddInsOptions.Fruit.class.getSimpleName() + ": " + addInsOptions.getFruit().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() AddInOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR AddInsOptions");
                }
            }
            // FlavorOptions
            else if (drinkComponent instanceof FlavorOptions) {
                FlavorOptions flavorOptions = (FlavorOptions) drinkComponent;
                if (flavorOptions.getSyrup() != null) {
                    String nameDrinkComponent = FlavorOptions.Syrup.class.getSimpleName() + ": " + flavorOptions.getSyrup().name();
                    tvName.setText(nameDrinkComponent);
                } else if (flavorOptions.getSauce() != null) {
                    String nameDrinkComponent = FlavorOptions.Sauce.class.getSimpleName() + ": " + flavorOptions.getSauce().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() FlavorOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR FlavorOptions");
                }
            }
            // SweetenerOptions
            else if (drinkComponent instanceof SweetenerOptions) {
                SweetenerOptions sweetenerOptions = (SweetenerOptions) drinkComponent;
                if (sweetenerOptions.getLiquid() != null) {
                    String nameDrinkComponent = SweetenerOptions.Liquid.class.getSimpleName() + ": " + sweetenerOptions.getLiquid().name();
                    tvName.setText(nameDrinkComponent);
                } else if (sweetenerOptions.getPacket() != null) {
                    String nameDrinkComponent = SweetenerOptions.Packet.class.getSimpleName() + ": " + sweetenerOptions.getPacket().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() SweetenerOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR SweetenerOptions");
                }
            }
            // TeaOptions
            else if (drinkComponent instanceof TeaOptions) {
                TeaOptions teaOptions = (TeaOptions) drinkComponent;
                if (teaOptions.getChai() != null) {
                    String nameDrinkComponent = TeaOptions.Chai.class.getSimpleName() + ": " + teaOptions.getChai().name();
                    tvName.setText(nameDrinkComponent);
                } else if (teaOptions.getIcedTeaBase() != null) {
                    String nameDrinkComponent = TeaOptions.IcedTeaBase.class.getSimpleName() + ": " + teaOptions.getIcedTeaBase().name();
                    tvName.setText(nameDrinkComponent);
                } else if (teaOptions.getIcedTeaSplash() != null) {
                    String nameDrinkComponent = TeaOptions.IcedTeaSplash.class.getSimpleName() + ": " + teaOptions.getIcedTeaSplash().name();
                    tvName.setText(nameDrinkComponent);
                } else if (teaOptions.getMatchaPowder() != null) {
                    String nameDrinkComponent = TeaOptions.MatchaPowder.class.getSimpleName() + ": " + teaOptions.getMatchaPowder().name();
                    tvName.setText(nameDrinkComponent);
                } else if (teaOptions.getTeaBag() != null) {
                    String nameDrinkComponent = TeaOptions.TeaBag.class.getSimpleName() + ": " + teaOptions.getTeaBag().name();
                    tvName.setText(nameDrinkComponent);
                } else if (teaOptions.getExtras() != null) {
                    String nameDrinkComponent = TeaOptions.Extras.class.getSimpleName() + ": " + teaOptions.getExtras().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() TeaOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR TeaOptions");
                }
            }
            // MilkOptions
            else if (drinkComponent instanceof MilkOptions) {
                MilkOptions milkOptions = (MilkOptions) drinkComponent;
                if (milkOptions.getMilkBase() != null) {
                    String nameDrinkComponent = MilkOptions.MilkBase.class.getSimpleName() + ": " + milkOptions.getMilkBase().name();
                    tvName.setText(nameDrinkComponent);
                } else if (milkOptions.getTemperature() != null) {
                    String nameDrinkComponent = MilkOptions.Temperature.class.getSimpleName() + ": " + milkOptions.getTemperature().name();
                    tvName.setText(nameDrinkComponent);
                } else if (milkOptions.getMilkFoam() != null) {
                    String nameDrinkComponent = MilkOptions.MilkFoam.class.getSimpleName() + ": " + milkOptions.getMilkFoam().name();
                    tvName.setText(nameDrinkComponent);
                } else if (milkOptions.getCappuccinoFoam() != null) {
                    String nameDrinkComponent = MilkOptions.CappuccinoFoam.class.getSimpleName() + ": " + milkOptions.getCappuccinoFoam().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() MilkOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR MilkOptions");
                }
            }
            // ToppingOptions
            else if (drinkComponent instanceof ToppingOptions) {
                ToppingOptions toppingOptions = (ToppingOptions) drinkComponent;
                if (toppingOptions.getCinnamonPowder() != null) {
                    String nameDrinkComponent = ToppingOptions.CinnamonPowder.class.getSimpleName() + ": " + toppingOptions.getCinnamonPowder().name();
                    tvName.setText(nameDrinkComponent);
                } else if (toppingOptions.getColdFoam() != null) {
                    String nameDrinkComponent = ToppingOptions.ColdFoam.class.getSimpleName() + ": " + toppingOptions.getColdFoam().name();
                    tvName.setText(nameDrinkComponent);
                } else if (toppingOptions.getDrizzle() != null) {
                    String nameDrinkComponent = ToppingOptions.Drizzle.class.getSimpleName() + ": " + toppingOptions.getDrizzle().name();
                    tvName.setText(nameDrinkComponent);
                } else if (toppingOptions.getTopping() != null) {
                    String nameDrinkComponent = ToppingOptions.Topping.class.getSimpleName() + ": " + toppingOptions.getTopping().name();
                    tvName.setText(nameDrinkComponent);
                } else if (toppingOptions.getWhippedCream() != null) {
                    String nameDrinkComponent = ToppingOptions.WhippedCream.class.getSimpleName() + ": " + toppingOptions.getWhippedCream().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() ToppingOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR ToppingOptions");
                }
            }
            // BlendedOptions
            else if (drinkComponent instanceof BlendedOptions) {
                BlendedOptions blendedOptions = (BlendedOptions) drinkComponent;
                if (blendedOptions.getFrapRoast() != null) {
                    String nameDrinkComponent = BlendedOptions.FrapRoast.class.getSimpleName() + ": " + blendedOptions.getFrapRoast().name();
                    tvName.setText(nameDrinkComponent);
                } else if (blendedOptions.getFrapChips() != null) {
                    String nameDrinkComponent = BlendedOptions.FrapChips.class.getSimpleName() + ": " + blendedOptions.getFrapChips().name();
                    tvName.setText(nameDrinkComponent);
                } else if (blendedOptions.getBlendedPrep() != null) {
                    String nameDrinkComponent = BlendedOptions.BlendedPrep.class.getSimpleName() + ": " + blendedOptions.getBlendedPrep().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() BlendedOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR BlendedOptions");
                }
            }
            // RefresherBaseOptions
            else if (drinkComponent instanceof RefresherBaseOptions) {
                RefresherBaseOptions refresherBaseOptions = (RefresherBaseOptions) drinkComponent;
                if (refresherBaseOptions.getRefresherBase() != null) {
                    String nameDrinkComponent = RefresherBaseOptions.RefresherBase.class.getSimpleName() + ": " + refresherBaseOptions.getRefresherBase().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() RefresherBaseOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR RefresherBaseOptions");
                }
            }
            // JuiceOptions
            else if (drinkComponent instanceof JuiceOptions) {
                JuiceOptions juiceOptions = (JuiceOptions) drinkComponent;
                if (juiceOptions.getJuice() != null) {
                    String nameDrinkComponent = JuiceOptions.Juice.class.getSimpleName() + ": " + juiceOptions.getJuice().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() JuiceOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR JuiceOptions");
                }
            }
            // LemonadeOptions
            else if (drinkComponent instanceof LemonadeOptions) {
                LemonadeOptions lemonadeOptions = (LemonadeOptions) drinkComponent;
                if (lemonadeOptions.getLemonade() != null) {
                    String nameDrinkComponent = LemonadeOptions.Lemonade.class.getSimpleName() + ": " + lemonadeOptions.getLemonade().name();
                    tvName.setText(nameDrinkComponent);
                } else {
                    String errorMessage = CustomizedDrinkComponentAdapter.class.getSimpleName() + ".ViewHolderCustomization.bind() LemonadeOptions else-clause";
                    Log.e(TAG, errorMessage);
                    tvName.setText("ERROR LemonadeOptions");
                }
            }
            // UNDEFINED
            else {
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
