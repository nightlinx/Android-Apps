package com.example.app3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;


import java.util.ArrayList;

public class CustomizedViewActivity extends Activity {

    ListView carsListView;
    private Switch categorySwitch;
    Context context;

    ArrayList n;
    public static int[] carsImagesId={R.drawable.auto1, R.drawable.auto2, R.drawable.auto3, R.drawable.auto4, R.drawable.auto5, R.drawable.auto6};
    public static String[] carsNames={"Chakee", "Pavel", "Augustus", "Hakai", "Jack", "Byron"};
    public static String[] carsInfo={"Mazda RX 7", "Polski Fiat", "Pontiac LeMans", "Honda Accord", "Jeep Liberty Sport", "Porsche 550 Spyder"};

    public static int[] gameImagesId={R.drawable.game1, R.drawable.game2, R.drawable.game3, R.drawable.game4, R.drawable.game5, R.drawable.game6};
    public static String[] charactersNames={"Mario", "Link", "Yoshi", "Pikachu", "Donkey Kong", "Peach"};
    public static String[] charactersInfo ={"Super Mario Bros", "The Legend of Zelda", "Yoshi's Island", "Pokemon", "Donkey Kong: Country", "Super Mario Bros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_view);

        context = this;
        categorySwitch = (Switch) findViewById(R.id.categorySwitch);
        categorySwitch.setOnCheckedChangeListener(categorySwitchListener);


        carsListView = (ListView) findViewById(R.id.carsListView);
        carsListView.setAdapter(new CustomAdapter(context, charactersNames, charactersInfo, gameImagesId));
    }


    private final Switch.OnCheckedChangeListener categorySwitchListener = new Switch.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
            if (bChecked) {
                carsListView.setAdapter(new CustomAdapter(context, carsNames, carsInfo, carsImagesId));

            } else {
                carsListView.setAdapter(new CustomAdapter(context, charactersNames, charactersInfo, gameImagesId));
            }
        }
    };




}
