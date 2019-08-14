package com.rizkasalma.test4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.rizkasalma.test4.BuildConfig.DEVICE_IC;
import static com.rizkasalma.test4.BuildConfig.URL_API;


public class HomeFragment extends Fragment {
    View v;
    Button button_toartikel,motoron,refresh;
    Switch switch1,switch2;
    private String mURL = URL_API + "/" + DEVICE_IC;
    private String mURL2 = URL_API + "/lembab";
    boolean button_on = true;
    public HomeFragment() {


        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);

        button_toartikel = v.findViewById(R.id.search_bar);
        motoron = v.findViewById(R.id.motoron);
        refresh = v.findViewById(R.id.refresh);

//        button_toartikel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setButton_toartikel();
//            }
//        });
        motoron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button_on)
                    usiron();
                else
                    usiroff();

            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekStatus();

            }
        });
        switch1 = (Switch) v.findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switch1.isChecked())
                new HTTPAsyncGPIO(getContext()).execute(mURL + "/gpio/control", "1", "1");
               else
                new HTTPAsyncGPIO(getContext()).execute(mURL + "/gpio/control", "1", "0");

            }
        });
        cekStatus();
        cekStatusGPIO();

        return v;

    }

    public void cekStatus () {
        new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                getStatus(object);
            }
        }).execute(mURL + "/adc/data");
    }
    public void cekStatusGPIO() {
        new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                getStatus(object);
            }
        }).execute(mURL + "/gpio/data");
    }
    public void getStatus (JSONObject object){
        try {
            //JSONObject table = new JSONObject(jsonResponse);
            JSONObject rows = object.getJSONObject("data");
            JSONObject result = rows.getJSONObject("result");
            String adc = result.getString("0");
            Log.d("coba", adc);
            float a = Float.valueOf(adc);
            TextView hasill = v.findViewById(R.id.kelembaban);
            hasill.setText(Float.toString(a));

            //String pin_4= result.getString("4");
            if (a > 500) {
                Toast.makeText(getContext(), "KERING", Toast.LENGTH_SHORT).show();
                //final Button nyala = v.findViewById(R.id.nyala2);
//                nyala.setText("NYALAKAN");
//                nyala.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        new HTTPAsyncGPIO(getContext()).execute(mURL + "/gpio/control", "4", "0");
//                        //10 detik
//                        nyala.setText("MATIKAN");
//                        nyala.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                new HTTPAsyncGPIO(getContext()).execute(mURL + "/gpio/control", "4", "1");
//                            }
//                        });
//                    }
//                });
            } else if (a < 500) {
                Toast.makeText(getContext(), "CUKUP BASAH", Toast.LENGTH_SHORT).show();
                //final Button nyala = v.findViewById(R.id.nyala2);
//                nyala.setText("MATIKAN");
//                nyala.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
                   //new HTTPAsyncGPIO(getContext()).execute(mURL + "/gpio/control", "1", "0");
//                        //3 detik
//                        nyala.setText("NYALAKAN");
//                        nyala.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                new HTTPAsyncGPIO(getContext()).execute(mURL + "/gpio/control", "4", "0");
//                            }
//                        });
//                    }
//                });
            } else {
                Toast.makeText(getContext(), "Pembacaan status gagal...", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void usiron(){
        button_on = false;
        new HTTPAsyncGPIO(getContext()).execute(mURL + "/pwm/control", "5","5");
        //Toast.makeText(getContext(), "Menunggu delayy...", Toast.LENGTH_SHORT).show();


    }
    public void usiroff() {
        button_on =true;
        new HTTPAsyncGPIO(getContext()).execute(mURL + "/pwm/control", "5", "10");


//        try {
//            //set time in mili
//            Thread.sleep(3000);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

//    public void usiron(){
//        //Toast.makeText(getContext(), "Burung akan terusir / pengusir nyala ", Toast.LENGTH_SHORT).show();
//        Toast.makeText(getContext(), "NYALA ", Toast.LENGTH_SHORT).show();
//    }
//    public void usiroff(){
//        //Toast.makeText(getContext(), "Burung telah terusir / pengusir mati", Toast.LENGTH_SHORT).show();
//        Toast.makeText(getContext(), "MATI ", Toast.LENGTH_SHORT).show();
//    }
    public void setButton_toartikel() {
        this.button_toartikel = button_toartikel;
        //startActivity(new Intent(getContext(), SplashActivity.class));

        // Create new fragment and transaction
//        HomeFragment arFragment = new HomeFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//// Replace whatever is in the fragment_container view with this fragment,
//// and add the transaction to the back stack
//        transaction.replace(R.id.artikel1, arFragment);
//        transaction.addToBackStack(null);
//
//// Commit the transaction
//        transaction.commit();

    }


}
