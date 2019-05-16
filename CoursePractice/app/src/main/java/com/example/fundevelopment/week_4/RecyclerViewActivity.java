package com.example.fundevelopment.week_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fundevelopment.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Car> mCars;
    private RecyclerView mRecyclerViewCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initView();
        setLayoutManager();
        setCars();
        setAdapter();
    }

    private void initView() {
        mRecyclerViewCars = findViewById(R.id.recycler_view_cars);
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);
        mRecyclerViewCars.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        mRecyclerViewCars.setAdapter(new CarAdapter(mCars));
    }

    private void setCars() {
        mCars = new ArrayList<>();

        mCars.add(new Car("Dacia", "red", 70));
        mCars.add(new Car("Benveu", "negru", 500));
        mCars.add(new Car("Trabant", "roz", 2));
        mCars.add(new Car("Bentley", "lila", 650));
        mCars.add(new Car("Audi", "alb", 300));
        mCars.add(new Car("Bentley", "lila", 650));
        mCars.add(new Car("Audi", "albastru", 40));
        mCars.add(new Car("Sentley", "maro", 652));
        mCars.add(new Car("Wentley", "verde", 30));
    }

}
