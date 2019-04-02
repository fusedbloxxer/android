package com.example.fundevelopment.week_4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fundevelopment.R;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> mCars;

    public CarAdapter(List<Car> mCars) {
        this.mCars = mCars;
    }

    /**
     * Creaza item nou si il adauga la viewgroup
     */
    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /**
         * Porneste de la un parent si tot adauga parent
         * Face inflate la itemul din layout, il asociaza viewgroupului
         *    attachToRoot - true: cand stim noi ca trebuie sa se faca inflate
         *                   false: nu stim cand isi termina treaba asa ca il lasam noi sa decida
         * Layout de adaugat, viewgroup, false - el decide cum face inflate
         */
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.car_item, viewGroup, false);

        return new CarViewHolder(itemView);
    }

    /**
     * Populeaza item-ul cu elementul corespunzator din lista de obiecte.
     * i - index, la ce pozitie a ajuns cu desenatul cand itereaza el
     * Preluam continutul si il afisam in itemviewul nostru
     */
    @Override
    public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {
        /**
         * Ia elementul current si seteaza proprietatile carViewHolder-ului curent.
         */

        Car currentCar = mCars.get(i);
        if (currentCar != null) {
            if (currentCar.getmName() != null) {
                carViewHolder.getmTextViewName().setText(currentCar.getmName());
            }
            if (currentCar.getmColor() != null) {
                carViewHolder.getmTextViewColor().setText(currentCar.getmColor());
            }
            if (currentCar.getmHp() > 0) {
                carViewHolder.getmTextViewHp().setText(currentCar.getmHp() + "");
            }
        }
    }

    // Returneaza numarul de elemente din lista.
    @Override
    public int getItemCount() {
        return mCars.size();
    }
}
