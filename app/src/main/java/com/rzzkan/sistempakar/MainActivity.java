package com.rzzkan.sistempakar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SmartMaterialSpinner spinGejala1,spinGejala2,spinGejala3,spinGejala4,spinGejala5,spinGejala6,spinGejala7,spinGejala8,spinGejala9;
    ArrayList<String> status;
    ArrayList<Score> score;
    Button btnDiagnostic;
    Double valueGejala1,valueGejala2,valueGejala3,valueGejala4,valueGejala5,valueGejala6,valueGejala7,valueGejala8,valueGejala9;
    Double userValue1,userValue2,userValue3,userValue4,userValue5,userValue6,userValue7,userValue8,userValue9;
    String disease = "";
    String cek1 = "",cek2 = "",cek3 = "",cek4 = "",cek5 = "",cek6 = "",cek7 = "",cek8 = "",cek9 = "";
    Boolean checkSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        addSpinner();
        btnListener();
        spinnerListener();
    }

    private void initialization(){
        spinGejala1 = findViewById(R.id.spinGejala1);
        spinGejala2 = findViewById(R.id.spinGejala2);
        spinGejala3 = findViewById(R.id.spinGejala3);
        spinGejala4 = findViewById(R.id.spinGejala4);
        spinGejala5 = findViewById(R.id.spinGejala5);
        spinGejala6 = findViewById(R.id.spinGejala6);
        spinGejala7 = findViewById(R.id.spinGejala7);
        spinGejala8 = findViewById(R.id.spinGejala8);
        spinGejala9 = findViewById(R.id.spinGejala9);
        btnDiagnostic = findViewById(R.id.btnDiagnostic);
    }

    private void addSpinner(){
        status = new ArrayList<>();
        score  = new ArrayList<>();

        status.add("Tidak");
        status.add("Sedikit Yakin");
        status.add("Cukup Yakin");
        status.add("Yakin");
        status.add("Sangat Yakin");

        score.add(new Score(
                "Tidak",
                0.0
        ));

        score.add(new Score(
                "Sedikit Yakin",
                0.2
        ));

        score.add(new Score(
                "Cukup Yakin",
                0.5
        ));

        score.add(new Score(
                "Yakin",
                0.8
        ));

        score.add(new Score(
                "Sangat Yakin",
                1.0
        ));

        spinGejala1.setItem(status);
        spinGejala2.setItem(status);
        spinGejala3.setItem(status);
        spinGejala4.setItem(status);
        spinGejala5.setItem(status);
        spinGejala6.setItem(status);
        spinGejala7.setItem(status);
        spinGejala8.setItem(status);
        spinGejala9.setItem(status);
    }


    private void btnListener(){
        btnDiagnostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cek1.equalsIgnoreCase("isi")&&
                        cek2.equalsIgnoreCase("isi")&&
                        cek3.equalsIgnoreCase("isi")&&
                        cek4.equalsIgnoreCase("isi")&&
                        cek5.equalsIgnoreCase("isi")&&
                        cek6.equalsIgnoreCase("isi")&&
                        cek7.equalsIgnoreCase("isi")&&
                        cek8.equalsIgnoreCase("isi")&&
                        cek9.equalsIgnoreCase("isi")
                ){
                    diagnosis();
                }else {
                    Toast.makeText(getApplicationContext(),"Pastikan Mengisi Gejala", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void spinnerListener(){
        spinGejala1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue1 = findValue(spinGejala1.getSelectedItem().toString());
                cek1 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue2 = findValue(spinGejala2.getSelectedItem().toString());
                cek2 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue3 = findValue(spinGejala3.getSelectedItem().toString());
                cek3 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue4 = findValue(spinGejala4.getSelectedItem().toString());
                cek4 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue5 = findValue(spinGejala5.getSelectedItem().toString());
                cek5 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue6 = findValue(spinGejala6.getSelectedItem().toString());
                cek6 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue7 = findValue(spinGejala7.getSelectedItem().toString());
                cek7 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue8 = findValue(spinGejala8.getSelectedItem().toString());
                cek8 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });

        spinGejala9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkSpinner = true;
                userValue9 = findValue(spinGejala9.getSelectedItem().toString());
                cek9 = "isi";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                checkSpinner = false;
            }
        });
    }

    private void diagnosis(){
        valueGejala1 = 0.8;
        valueGejala2 = 0.4;
        valueGejala3 = 0.3;
        valueGejala4 = 0.5;
        valueGejala5 = 0.7;
        valueGejala6 = 0.9;
        valueGejala7 = 0.8;
        valueGejala8 = 0.9;
        valueGejala9 = 0.6;

        Double countGejala1 = valueGejala1 * userValue1;
        Double countGejala2 = valueGejala2 * userValue2;
        Double countGejala3 = valueGejala3 * userValue3;
        Double countGejala4 = valueGejala4 * userValue4;
        Double countGejala5 = valueGejala5 * userValue5;
        Double countGejala6 = valueGejala6 * userValue6;
        Double countGejala7 = valueGejala7 * userValue7;
        Double countGejala8 = valueGejala8 * userValue8;
        Double countGejala9 = valueGejala9 * userValue9;


        if (!spinGejala1.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala2.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala3.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala4.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala5.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala6.getSelectedItem().toString().equalsIgnoreCase("tidak")
        ){
            Double combine_CF1_CF2 = countGejala1 + countGejala2 * (1-countGejala1);
            Double combine_CF2_CF3 = combine_CF1_CF2 + countGejala3 * (1-combine_CF1_CF2);
            Double combine_CF3_CF4 = combine_CF2_CF3 + countGejala4 * (1-combine_CF2_CF3);
            Double combine_CF4_CF5 = combine_CF3_CF4 + countGejala5 * (1-combine_CF3_CF4);
            Double combine_CF5_CF6 = combine_CF4_CF5 + countGejala6 * (1-combine_CF4_CF5);

            disease += "\n"+ String.valueOf(combine_CF5_CF6*100)+ "%"+" Penyakit Demam Berdarah";

        }

        if (!spinGejala2.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala3.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala7.getSelectedItem().toString().equalsIgnoreCase("tidak")
        ){
            Double combine_CF2_CF3_M = countGejala2 + countGejala3 * (1-countGejala2);
            Double combine_CF3_CF7_M = combine_CF2_CF3_M + countGejala7 * (1-combine_CF2_CF3_M);

            disease += "\n"+ String.valueOf(combine_CF3_CF7_M*100)+ "%" +" Penyakit Malaria";
        }

        if (!spinGejala4.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala8.getSelectedItem().toString().equalsIgnoreCase("tidak")&&
                !spinGejala9.getSelectedItem().toString().equalsIgnoreCase("tidak")
        ){
            Double combine_CF4_CF8_C = countGejala4 + countGejala8 * (1-countGejala4);
            Double combine_CF8_CF9_C = combine_CF4_CF8_C + countGejala9 * (1-combine_CF4_CF8_C);

            disease += "\n"+ String.valueOf(combine_CF8_CF9_C*100)+ "%" +" Penyakit Chikungunya";
        }

        showDialog(disease);

    }


    private Double findValue (String name) {
        Double currentValue = null;
        for(Score list : score) {
            if (list.getName().equalsIgnoreCase(name)) {
                currentValue = list.getValue();
            }
        }
        System.out.println("Not Found");
        return currentValue;
    }

    private void showDialog(String text){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);

        Button btnOk = dialog.findViewById(R.id.btnOk);
        TextView tvTittle = dialog.findViewById(R.id.tvTittle);
        Button btnRetry = dialog.findViewById(R.id.btnRetry);

        tvTittle.setText(text);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disease = "";
                dialog.dismiss();
            }
        });

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        dialog.show();
    }
}