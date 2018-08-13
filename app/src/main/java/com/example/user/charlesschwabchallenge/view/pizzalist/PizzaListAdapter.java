package com.example.user.charlesschwabchallenge.view.pizzalist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.charlesschwabchallenge.R;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;
import com.example.user.charlesschwabchallenge.utils.PizzaUtils;
import com.example.user.charlesschwabchallenge.view.pizzadetail.PizzaDetailActivity;

import java.util.List;

public class PizzaListAdapter extends RecyclerView.Adapter<PizzaListAdapter.ViewHolder> {

    private List<Pizza> pizzaList;
    private Context context;

    PizzaListAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Pizza pizza = pizzaList.get(position);

        holder.tvName.setText(pizza.getTitle());
        holder.tvPhone.setText(pizza.getPhone());
        holder.tvDistance.setText(PizzaUtils.formattedDistance(pizza));
        holder.tvAddress.setText(PizzaUtils.formattedAddress(pizza));

    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public void updatePizzaList(List<Pizza> pizzaList) {
        this.pizzaList.clear();
        this.pizzaList.addAll(pizzaList);
        notifyDataSetChanged();

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvAddress;
        TextView tvDistance;
        TextView tvPhone;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, PizzaDetailActivity.class);
            intent.putExtra("pizza", pizzaList.get(getAdapterPosition()));
            context.startActivity(intent);

        }
    }
}
