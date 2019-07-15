package com.example.finalprojectmad310;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {



    ListView lsp;
    Mylistadapter adapt;

    ArrayList<Products> pro;


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
        //  ImageView search =(ImageView) findViewById(R.menu.main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        item.getItemId();
        Toast.makeText(this, "Search List", Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(this, SearchList.class));

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();




        getSupportActionBar().setTitle("Menu List");
        actionBar.setSubtitle("Please select from menu");
        //  actionBar.setLogo(R.drawable.logomenu);





        lsp = findViewById(R.id.lst_products);


        String ls = getResources().getString(R.string.link);

        pro = new ArrayList<>();

        try {
            String mysts = new Asycdata().execute(ls).get();

            System.out.println("This is from MainActivity :"+mysts);


            JSONObject mainobj = new JSONObject(mysts);

            JSONArray proarray = mainobj.getJSONArray("products");

            for(int i =0;i<proarray.length();i++)
            {
                JSONObject childobj = proarray.getJSONObject(i);

                String name = childobj.getString("title");
                String pimg = childobj.getString("imageFront");
                String pimg1 = childobj.getString("imageBack");
                String desc = childobj.getString("description");
                String brand = childobj.getString("brand");
                long price = childobj.getLong("price");


                pro.add(new Products(pimg,pimg1,name,brand,desc,price));

                // System.out.println("Bag Names :"+childobj.getString("title"));
            }


            System.out.println("Array list size :"+pro.size());

            adapt = new Mylistadapter(MainActivity.this,pro);

            lsp.setAdapter(adapt);



            lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,pro.get(position).getPname(),Toast.LENGTH_LONG).show();


                    Intent i = new Intent(MainActivity.this,ProductsDesc.class);
                    i.putExtra("data",pro.get(position));
                    startActivity(i);

                }
            });





        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
