package com.example.finalprojectmad310;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class searchList extends AppCompatActivity {

    ListView lsp;
    Mylistadapter adapt;

    ArrayList<Products> pro;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        MenuItem item=menu.findItem(R.id.search_bar);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
         //   adapt.getFilter().filter(s);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Search here");
        actionBar.setSubtitle("Please enter you want");
        String link = "https://www.foodrepo.org/api/v3/products/";

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

            adapt = new Mylistadapter(searchList.this,pro);
            //  adapt = new Mylistadapter(pro, MainActivity.this);



            lsp.setAdapter(adapt);





            lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(searchList.this,pro.get(position).getFoodName(),
                            Toast.LENGTH_LONG).show();


                    Intent i = new Intent(searchList.this,ProductsDesc.class);
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
