package com.rizkasalma.test4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.rizkasalma.test4.BuildConfig.DEVICE_IC;
import static com.rizkasalma.test4.BuildConfig.URL_API;

public class ArkademyActivity extends AppCompatActivity {
    private String mURL = URL_API + "/" + DEVICE_IC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arkademy);

        Button nyala = (Button)findViewById(R.id.buttonnyala);
        Button nyala2 = (Button)findViewById(R.id.buttonnyala2);
        nyala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HTTPAsyncGPIO(ArkademyActivity.this).execute(mURL + "/gpio/control", "3", "1");
            }
        });
        nyala2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HTTPAsyncGPIO(ArkademyActivity.this).execute(mURL + "/gpio/control", "3", "0");
            }
        });
//        cekStatus();
//        cekStatusGPIO();
    }

    // cek status kelembaban
//    public void cekStatus () {
//        new DownloadWebpageTask(new AsyncResult() {
//            @Override
//            public void onResult(JSONObject object) {
//                getStatus(object);
//            }
//        }).execute(mURL + "/adc/data");
//    }
//    public void cekStatusGPIO() {
//        new DownloadWebpageTask(new AsyncResult() {
//            @Override
//            public void onResult(JSONObject object) {
//                getStatus(object);
//            }
//        }).execute(mURL + "/gpio/data");
//    }
    // ini trigger buat nelakukan sesuatu
//    public void getStatus (JSONObject object){
//        try {
//
//            //JSONObject table = new JSONObject(jsonResponse);
//            JSONObject rows = object.getJSONObject("data");
//            JSONObject result = rows.getJSONObject("result");
//            String adc = result.getString("0");
//            Log.d("coba", adc);
//            float a = Float.valueOf(adc);
//            TextView hasill = findViewById(R.id.hasill);
//            hasill.setText(Float.toString(a));
//            //String pin_4= result.getString("4");
//            if (a > 1000) {
//                Toast.makeText(ArkademyActivity.this, "KERING", Toast.LENGTH_SHORT).show();
//                final Button nyala = findViewById(R.id.buttonnyala);
//                nyala.setText("NYALAKAN");
//                nyala.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        new HTTPAsyncGPIO(ArkademyActivity.this).execute(mURL + "/gpio/control", "3", "1");
//                        //10 detik
//                        nyala.setText("MATIKAN");
//                        nyala.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                new HTTPAsyncGPIO(ArkademyActivity.this).execute(mURL + "/gpio/control", "3", "0");
//                            }
//                        });
//                    }
//                });
//            } else if (a < 1000) {
//                Toast.makeText(ArkademyActivity.this, "CUKUP BASAH", Toast.LENGTH_SHORT).show();
//                final Button nyala = findViewById(R.id.buttonnyala);
//                nyala.setText("MATIKAN");
//                nyala.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        new HTTPAsyncGPIO(ArkademyActivity.this).execute(mURL + "/gpio/control", "3", "0");
//                        //3 detik
//                        nyala.setText("NYALAKAN");
//                        nyala.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                new HTTPAsyncGPIO(ArkademyActivity.this).execute(mURL + "/gpio/control", "3", "1");
//                                Toast.makeText(ArkademyActivity.this, "baca =", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                });
//            } else {
//                Toast.makeText(ArkademyActivity.this, "Pembacaan status gagal...", Toast.LENGTH_SHORT).show();
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

}
