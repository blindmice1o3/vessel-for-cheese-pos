package com.jackingaming.vesselforcheesepos.views.viewport;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesepos.R;
import com.jackingaming.vesselforcheesepos.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesepos.models.menu.MenuItem;
import com.jackingaming.vesselforcheesepos.models.menu.drinks.Drink;
import com.jackingaming.vesselforcheesepos.models.menu.foods.Food;
import com.jackingaming.vesselforcheesepos.models.menu.sides.Side;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = MenuItemAdapter.class.getSimpleName();

    public static final int MENU_ITEM = R.layout.listitem_menuitem;
    public static final int DRINK = 1;
    public static final int FOOD = 2;
    public static final int SIDE = 3;

    public interface MenuItemAdapterListener {
        void onMenuItemClicked(int position, View view);

        void onMenuItemLongClicked(int position, View view);
    }

    private MenuItemAdapterListener listener;

    private List<MenuItem> menuItems;

    public MenuItemAdapter(List<MenuItem> menuItems,
                           MenuItemAdapterListener listener) {
        this.menuItems = menuItems;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (menuItems.get(position) instanceof Drink) {
            return DRINK;
        } else if (menuItems.get(position) instanceof Food) {
            return FOOD;
        } else if (menuItems.get(position) instanceof Side) {
            return SIDE;
        } else if (menuItems.get(position) instanceof MenuItem) {
            return MENU_ITEM;
        } else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case DRINK:
                View viewDrink = inflater.inflate(R.layout.listitem_drink, parent, false);
                viewHolder = new ViewHolderDrink(viewDrink);
                // TODO:
                break;
            case FOOD:
                View viewFood = inflater.inflate(R.layout.listitem_food, parent, false);
                viewHolder = new ViewHolderMenuItem(viewFood);
                // TODO:
                break;
            case SIDE:
                View viewSide = inflater.inflate(R.layout.listitem_side, parent, false);
                viewHolder = new ViewHolderMenuItem(viewSide);
                // TODO:
                break;
            case MENU_ITEM:
                View viewMenuItem = inflater.inflate(R.layout.listitem_menuitem, parent, false);
                viewHolder = new ViewHolderMenuItem(viewMenuItem);
                break;
            default:
                View viewSimpleListItem = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new ViewHolderSimpleListItem(viewSimpleListItem);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem itemSelected = menuItems.get(position);

        switch (holder.getItemViewType()) {
            case DRINK:
                // TODO:
                ViewHolderDrink viewHolderDrink = (ViewHolderDrink) holder;
                Drink drinkSelected = (Drink) itemSelected;
                viewHolderDrink.bind(drinkSelected);
                break;
            case FOOD:
                // TODO:
                ViewHolderMenuItem viewHolderFood = (ViewHolderMenuItem) holder;
                Food foodSelected = (Food) itemSelected;
                viewHolderFood.bind(foodSelected);
                break;
            case SIDE:
                // TODO:
                ViewHolderMenuItem viewHolderSide = (ViewHolderMenuItem) holder;
                Side sideSelected = (Side) itemSelected;
                viewHolderSide.bind(sideSelected);
                break;
            case MENU_ITEM:
                ViewHolderMenuItem viewHolderMenuItem = (ViewHolderMenuItem) holder;
                viewHolderMenuItem.bind(itemSelected);
                break;
            default:
                ViewHolderSimpleListItem viewSimpleListItem = (ViewHolderSimpleListItem) holder;
                viewSimpleListItem.bind(itemSelected);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class ViewHolderDrink extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvSize;
        private TextView tvIced;
        private RecyclerView rvCustomizedDrinkComponents;

        public ViewHolderDrink(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvSize = itemView.findViewById(R.id.tv_size);
            tvIced = itemView.findViewById(R.id.tv_iced);
            rvCustomizedDrinkComponents = itemView.findViewById(R.id.rv_customized_drink_components);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Drink drinkSelected) {
            tvName.setText(drinkSelected.getName());
            tvPrice.setText(String.format("%.2f", drinkSelected.getPrice()));
            tvSize.setText(drinkSelected.getSize().name());
            String isIced = (drinkSelected.isIced()) ? "iced" : "not iced";
            tvIced.setText(isIced);
            initRvCustomizedDrinkComponents(drinkSelected);
        }

        protected RecyclerView getRvCustomizedDrinkComponents() {
            return rvCustomizedDrinkComponents;
        }

        private void initRvCustomizedDrinkComponents(Drink drinkSelected) {
            List<DrinkComponent> customizedDrinkComponents = drinkSelected.getCustomizedDrinkComponents();
            CustomizedDrinkComponentAdapter adapter = new CustomizedDrinkComponentAdapter(
                    customizedDrinkComponents,
                    new CustomizedDrinkComponentAdapter.CustomizedDrinkComponentAdapterListener() {
                        @Override
                        public void onCustomizedDrinkComponentClicked(int position, View view) {
                            Toast.makeText(rvCustomizedDrinkComponents.getContext(), "onCustomizedDrinkComponentClicked(int, View) position: " + position, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCustomizedDrinkComponentLongClicked(int position) {
                            Toast.makeText(rvCustomizedDrinkComponents.getContext(), "onCustomizedDrinkComponentLongClicked(int) position: " + position, Toast.LENGTH_SHORT).show();

                            customizedDrinkComponents.remove(position);
                            rvCustomizedDrinkComponents.getAdapter().notifyItemRemoved(position);
                        }
                    });
            rvCustomizedDrinkComponents.setAdapter(adapter);
            rvCustomizedDrinkComponents.setLayoutManager(new LinearLayoutManager(rvCustomizedDrinkComponents.getContext()));
            RecyclerView.ItemDecoration itemDecoration =
                    new DividerItemDecoration(rvCustomizedDrinkComponents.getContext(), DividerItemDecoration.VERTICAL);
            rvCustomizedDrinkComponents.addItemDecoration(itemDecoration);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onMenuItemClicked(position, view);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onMenuItemLongClicked(position, view);
                    return true;
                }
            }
            return false;
        }
    }

//    public class ViewHolderFood extends RecyclerView.ViewHolder
//            implements View.OnClickListener, View.OnLongClickListener {
//        // TODO:
//    }
//
//    public class ViewHolderSide extends RecyclerView.ViewHolder
//            implements View.OnClickListener, View.OnLongClickListener {
//        // TODO:
//    }

    public class ViewHolderMenuItem extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvPrice;

        public ViewHolderMenuItem(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(MenuItem itemSelected) {
            tvName.setText(itemSelected.getName());
            tvPrice.setText(String.format("%.2f", itemSelected.getPrice()));
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onMenuItemClicked(position, view);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onMenuItemLongClicked(position, view);
                    return true;
                }
            }
            return false;
        }
    }

    public class ViewHolderSimpleListItem extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;

        public ViewHolderSimpleListItem(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(MenuItem itemSelected) {
            tvName.setText(
                    "(name: " + itemSelected.getName() + "), (price: " + String.format("%.2f", itemSelected.getPrice()) + ")"
            );
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onMenuItemClicked(position, view);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onMenuItemLongClicked(position, view);
                    return true;
                }
            }
            return false;
        }
    }
}
