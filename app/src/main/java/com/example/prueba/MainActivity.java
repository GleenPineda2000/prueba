package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


Button mostrarview;
    ListView listaview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaview = (ListView) findViewById(R.id.listview);
mostrarview = (Button) findViewById(R.id.mostrarlista);

mostrarview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String consulta = "http://192.168.0.11/eleconomicoconexion/mis_entregas.php";
        EnviarRecibirDatos(consulta);

    }
});



listaview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {



            startActivity(new Intent(MainActivity.this,lista_repartidor.class));





    }
});


    }

    public void EnviarRecibirDatos(String URL){

        Toast.makeText(getApplicationContext(), ""+URL, Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("||", ",");
                if (response.length() > 0) {
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson", "" + ja.length());
                        CargarLista(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error no carga"," "+error.getMessage());
            }
        });

        queue.add(stringRequest);
    }

    public void CargarLista(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i++){
            try{

                lista.add(ja.getString(i));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaview.setAdapter(adaptador);
    }












}