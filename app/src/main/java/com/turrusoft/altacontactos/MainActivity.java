package com.turrusoft.altacontactos;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.Dialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button siguiente;
    private EditText nombre, fechanacimiento, telefono, email, descripcion;
    private TextInputLayout tilFechaNac;
    private EditText fechanacim;
    private int mYear,mMonth,mDay,fecha,año,sMonth,sDay,sYear;
    static final int DATE_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.etNombre);
        fechanacimiento=(EditText) findViewById(R.id.etNacimiento);
        telefono = (EditText) findViewById(R.id.etTelefono);
        email = (EditText) findViewById(R.id.etEmail);
        descripcion = (EditText) findViewById(R.id.etDescripcion);

        tilFechaNac=(TextInputLayout) findViewById(R.id.tilNacimiento);
        tilFechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialog(DATE_ID);
            }
        });

        siguiente = (Button) findViewById(R.id.btnSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snombre=nombre.getText().toString();
                String sfechan=fechanacimiento.getText().toString();
                String stel=telefono.getText().toString();
                String smail=email.getText().toString();
                String sdesc=descripcion.getText().toString();
                Intent cDatos = new Intent(MainActivity.this, ConfirmaDatos.class);
                cDatos.putExtra("nombre",snombre);
                cDatos.putExtra("nacimiento",sfechan);
                cDatos.putExtra("telefono",stel);
                cDatos.putExtra("email", smail);
                cDatos.putExtra("descripcion",sdesc);
                startActivity(cDatos);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String mMes="";
                    mYear = year;
                    mMonth = month+1;
                    //mMonth=mMonth+1;
                    mDay=dayOfMonth;
                    switch (mMonth){
                        case 1:
                            mMes="Ene";
                            break;
                        case 2:
                            mMes="Feb";
                            break;
                        case 3:
                            mMes="Mar";
                            break;
                        case 4:
                            mMes="Abr";
                            break;
                        case 5:
                            mMes="May";
                            break;
                        case 6:
                            mMes="Jun";
                            break;
                        case 7:
                            mMes="Jul";
                            break;
                        case 8:
                            mMes="Ago";
                            break;
                        case 9:
                            mMes="Sep";
                            break;
                        case 10:
                            mMes="Oct";
                            break;
                        case 11:
                            mMes="Nov";
                            break;
                        case 12:
                            mMes="Dic";
                            break;
                    }
                   String fechan=Integer.toString(mDay)+"/"+mMes+"/"+Integer.toString(mYear);
                    fechanacim = (EditText) findViewById(R.id.etNacimiento);
                    fechanacim.setText(fechan);
                }
            };

    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_ID:
                return new DatePickerDialog(this,mDateSetListener,sYear,sMonth,sDay );
        }
        return null;
    }
}
