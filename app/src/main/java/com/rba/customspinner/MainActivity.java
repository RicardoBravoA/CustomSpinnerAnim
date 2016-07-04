package com.rba.customspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.rba.customspinner.control.spinner.CustomSpinner;
import com.rba.customspinner.control.spinner.listener.OnFilterDoneListener;
import com.rba.customspinner.model.entity.ItemEntity;
import com.rba.customspinner.view.CustomSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener {

    @Bind(R.id.customSpinner)
    CustomSpinner customSpinner;
    private List<ItemEntity> itemEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init() {
        itemEntityList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            itemEntityList.add(new ItemEntity(String.valueOf(i), "Data "+i));
        }

        String title = "Seleccione";
        customSpinner.setMenuAdapter(new CustomSpinnerAdapter(this, title, itemEntityList));
    }

    @Override
    public void onFilterDone(int position, String description) {
        Log.i("x- done", "position: "+position+" -  title: "+description);

        customSpinner.setPositionIndicatorText(description);
        customSpinner.close();
    }

}
