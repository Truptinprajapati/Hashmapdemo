package com.example.nepl2.my_task;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ArrayList<HashMap<String , String>> iteamlists;
    Iteamlist iteamlistdata;
    RecyclerView myRecyclerView;
    String Data_url,id,sno,postid,posttype,posttitle,postby,tages,sdes,pdes,imga,imgb,imgc,imgd,imge;
    ProgressDialog progressDialog;
    HashMap<String,String> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView=(RecyclerView)findViewById(R.id.rviteam);
       myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        iteamlists=new ArrayList<HashMap<String, String>>();
       // myRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        iteamlists=new ArrayList<>();
        loaddata();

    }

    private void loaddata() {

        Data_url = "http://24variyasamaj.com/includes/loader_functions.php?Action=GetAllBlogs";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Data_url, new Response.Listener<String>() {
            @Override
                public void onResponse(String response) {
                try {
                    JSONObject responsejson = new JSONObject(response);


                    JSONArray jsonArray = responsejson.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);
                        Toast.makeText(getApplicationContext(),""+c,Toast.LENGTH_SHORT).show();

                        id = c.getString("DT_RowId");
                        map = new HashMap<>();
                        map.put("id",id);




                        sno=c.getString("SrNo");
                        map.put("sno",sno);


                        postid=c.getString("PostID");
                        map.put("postid",postid);

                        posttype=c.getString("PostType");
                        map.put("posttype",posttype);


                        posttitle=c.getString("PostTitle");
                        map.put("posttitle",posttitle);

                        postby=c.getString("PostBy");
                        map.put(" postby", postby);

                        tages=c.getString("Tags");
                        map.put("tages",tages);

                        sdes=c.getString("ShortDescription");
                        map.put("sdes",sdes);

                        pdes=c.getString("PostDescription");
                        map.put("pdes",pdes);


                        imga=c.getString("Photo1");
                        map.put("imga", imga);

                        imgb=c.getString("Photo2");
                        map.put("imgb",imgb);

                        imgc=c.getString("Photo3");
                        map.put("imgc",imgc);


                        iteamlists.add(map);
//                        iteamlistdata = new Iteamlist(c.getInt("DT_RowId"), c.getInt("SrNo"), c.getInt("PostID"), c.getString("PostType"), c.getString("PostTitle"), c.getString("Photo1"), c.getString("Photo2"), c.getString("Photo3"), c.getString("Photo4"), c.getString("Photo5"), c.getString("PostBy"), c.getString("Tags"), c.getString("ShortDescription"), c.getString("PostDescription"));
//                        iteamlists.add(iteamlistdata);
                    }
                    Toast.makeText(getApplicationContext(),""+iteamlists.size(),Toast.LENGTH_SHORT).show();



                    Myadapter adapter = new Myadapter(iteamlists, getApplicationContext());
                    myRecyclerView.setAdapter(adapter);

                    progressDialog.dismiss();

                } catch (JSONException e) {
                    progressDialog.dismiss();
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params=new HashMap<String, String>();
                return params;
            }
        };


        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        progressDialog=ProgressDialog.show(MainActivity.this,"plz wait ...",null,true,true);
        progressDialog.setMessage("feaching data view");
        progressDialog.setCancelable(false);

    }

}




