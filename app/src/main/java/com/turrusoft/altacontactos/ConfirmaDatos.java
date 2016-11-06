package com.turrusoft.altacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaDatos extends AppCompatActivity {

    private TextView etvNombre, etvNacimiento, etvTelefono, etvEmail, etvDescripcion;
    private Button editarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);
        final Bundle param=getIntent().getExtras();
        final String datoNombre=(String)param.get("nombre");
        String datoNac=(String)param.get("nacimiento");
        String datoTel="Tel. "+(String)param.get("telefono");
        String datoMail="Email: "+(String)param.get("email");
        String datoDesc="Descripción: "+(String)param.get("descripcion");
        etvNombre=(TextView) findViewById(R.id.tvNombre);
        etvNacimiento=(TextView) findViewById(R.id.tvFechaNac);
        etvTelefono=(TextView) findViewById(R.id.tvTelefono);
        etvEmail=(TextView) findViewById(R.id.tvEmail);
        etvDescripcion=(TextView) findViewById(R.id.tvDesc);
        etvNombre.setText(datoNombre);
        etvNacimiento.setText(datoNac);
        etvTelefono.setText(datoTel);
        etvEmail.setText(datoMail);
        etvDescripcion.setText(datoDesc);
        editarDatos = (Button) findViewById(R.id.btnEditarDatos);
        editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
