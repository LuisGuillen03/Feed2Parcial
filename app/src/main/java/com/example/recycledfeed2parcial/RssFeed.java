package com.example.recycledfeed2parcial;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RssFeed extends AppCompatActivity {
    private RecyclerView recycler;
    private ArrayList<elemento> lista;
    private Adapter Adapt;
    public Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_feed);
        recycler=findViewById(R.id.Recycler_Vista);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        lista=new ArrayList<>();
        parseJSON2();
    }

    private void parseJSON2(){
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("hits");
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject hit = m_jArry.getJSONObject(i);
                String Name=hit.getString("title");
                String Year=hit.getString("year");
                String Director=hit.getString("director");
                String Lenguage=hit.getString("lenguage");

                lista.add(new elemento(Name,Year,Director,Lenguage));
            }
            Adapt =new Adapter(context,lista);
            recycler.setAdapter(Adapt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("JsonMovies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
