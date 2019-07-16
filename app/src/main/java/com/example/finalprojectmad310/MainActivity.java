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
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getItemId();
        startActivity(new Intent(MainActivity.this, searchList.class));
//startActivity();
        return super.onOptionsItemSelected(item);
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
        //  ImageView search =(ImageView) findViewById(R.menu.main);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String link = "https://www.foodrepo.org/api/v3/products/";


        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Menu List");
        actionBar.setSubtitle("Please select from menu");
        //  actionBar.setLogo(R.drawable.logomenu);

        lsp = findViewById(R.id.lst_products);

        pro = new ArrayList<>();

        try {
            String mysts = new Asycdata().execute(link).get();

            System.out.println("This is from MainActivity :"+mysts);


            JSONObject mainobj = new JSONObject(mysts);

            JSONArray proarray = mainobj.getJSONArray("data");

            for(int i =0;i<proarray.length();i++)
            {
               JSONObject childobj = proarray.getJSONObject(i);
               String foodName = childobj.getJSONObject("name_translations").getString("fr");
              System.out.println("foodname" + foodName);
                String foodId = childobj.getString("id");
              //  System.out.println("foodId" + foodId);
                String foodCountry = childobj.getString("country");
              // System.out.println("foodCountry" + foodCountry);
               //String foodName = childobj.getString("name_translations");
              // String desc = childobj.getString("images");
               String foodUnit = childobj.getString("unit");
              //  System.out.println("foodUnit" + foodUnit);
               String foodQuantity=childobj.getString("quantity");
               String cate=new String();

               // System.out.println("foodQuantity" + foodQuantity);

              // String des = childobj.getString("description");
              //  System.out.println("des" + des);
               //String imgs= childobj.getJSONObject("images").getJSONObject("categories")
                 //    .getJSONObject("Front").getString("medium");
            //  System.out.println("imgs" + imgs);


               JSONArray imgs = childobj.getJSONArray("images");

                for(int j=0;j<1;j++)
                {
                    JSONObject imgobj = imgs.getJSONObject(j);
                cate = imgobj.getString("medium");
                    System.out.println("this is my image "+cate);
                    /*for (int z=0;z<cate.length();z++)
                    {
                        String cnm = cate.getString(z);
                        //System.out.println("CNM :"+cnm);
                                if(cnm.equals("Front")){
                            String lk = imgobj.getString("medium");
                            System.out.println("Front Found!");
                           System.out.println("Images :"+lk);
                        }
                        else if(cnm.equals("Back")){
                            String lk = imgobj.getString("medium");
                            System.out.println("Back Found!");
                            System.out.println("Images :"+lk);
                        }*/
                       // System.out.println("imgs" + imgs);
                     }
                   // String foodImage = childobj.getString("images");

                pro.add(new Products(foodId,foodCountry,foodName,foodUnit,foodQuantity));
            }

           // pro.add(new Products("foodname" +foodId));


              //  System.out.println("Product name" + foodName);




        System.out.println("Array list size :"+pro.size());

           adapt = new Mylistadapter(MainActivity.this,pro);
          //  adapt = new Mylistadapter(pro, MainActivity.this);

            lsp.setAdapter(adapt);





            lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,pro.get(position).getFoodName(),
                            Toast.LENGTH_LONG).show();


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
