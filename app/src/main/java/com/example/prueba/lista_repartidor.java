package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
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
import org.json.JSONObject;



import java.util.ArrayList;





public class lista_repartidor extends AppCompatActivity {



    ListView listarepartidor;

    Button regresar,mostrar;

private TextView nombre,tel,subtotal,total;
private RequestQueue rq;
private RequestQueue rq2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_repartidor);


        listarepartidor = (ListView) findViewById(R.id.lista_repartidor);
regresar = (Button) findViewById(R.id.btnIniciarSesion);
        mostrar = (Button) findViewById(R.id.cargar);
        nombre = (TextView) findViewById(R.id.nombrecliente);
        tel = (TextView) findViewById(R.id.telefono);
        subtotal = (TextView) findViewById(R.id.subtotal);
        total = (TextView) findViewById(R.id.total);
rq = Volley.newRequestQueue(this);
rq2 = Volley.newRequestQueue(this);

regresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(lista_repartidor.this,MainActivity.class));
    }
});

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String consulta = "http://192.168.0.11/eleconomicoconexion/mis_pedidos.php";
                EnviarRecibirDatos(consulta);
                recuperar();
                recuperar2();
            }
        });

    }


    public void recuperar(){

nombre.setText("");
tel.setText("");

String url = "http://192.168.0.11/eleconomicoconexion/consulta1.php";
        JsonArrayRequest requerimiento = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int f = 0; f < response.length(); f++) {
                            try {
                                JSONObject objecto = new JSONObject(response.get(f).toString());
                                nombre.append("nombre"+objecto.getString("nombre"));
                                tel.append("telefono"+objecto.getString("telefono"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error no carga"," "+error.getMessage());
                    }
                });
rq.add(requerimiento);
    }

    public void recuperar2(){

        subtotal.setText("");
        total.setText("");

        String url = "http://192.168.0.11/eleconomicoconexion/prueba2.php";
        JsonArrayRequest requerimiento = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int f = 0; f < response.length(); f++) {
                            try {
                                JSONObject objecto = new JSONObject(response.get(f).toString());
                                subtotal.append("subtotal"+objecto.getString("subtotal"));
                                total.append("total"+objecto.getString("total"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error no carga"," "+error.getMessage());
                    }
                });
        rq.add(requerimiento);
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
        listarepartidor.setAdapter(adaptador);
    }





}