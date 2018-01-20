package com.example.nepl2.my_task;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nepl2 on 20/1/18.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    ArrayList<HashMap<String , String>> iteamlists;
    Context context;
    String Upload_URL="http://24variyasamaj.com/uploads/";

    public Myadapter(ArrayList<HashMap<String ,String>> iteamlists, Context applicationContext) {

        this.iteamlists=iteamlists;
        this.context=applicationContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.childlist_layout,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        HashMap<String,String> map = new HashMap<>();

      //  Iteamlist listioteam=iteamlists.get(position);
        holder.trowid.setText(iteamlists.get(position).get("id"));
      holder.tsrno.setText(iteamlists.get(position).get("sno"));
     holder.tpostid.setText(iteamlists.get(position).get("postid"));
     holder.tposttype.setText(iteamlists.get(position).get("posttype"));
     holder.tposttitle.setText(iteamlists.get(position).get("posttitle"));
        holder.ttages.setText(iteamlists.get(position).get("tages"));
        holder.tshortdes.setText(iteamlists.get(position).get("sdes"));
        holder.tpostdes.setText(iteamlists.get(position).get("pdes"));
        Toast.makeText(context,""+iteamlists.get(position).get("imga"),Toast.LENGTH_SHORT).show();

      //  Toast.makeText(Myadapter.this,""+iteamlists.get(position).get("imga"),Toast.LENGTH_SHORT).show();

        Log.d("img","http://24variyasamaj.com/uploads/" + "blogs/" + iteamlists.get(position).get(("imga")));

        Picasso.with(context).load("http://24variyasamaj.com/uploads/" + "blogs/" + iteamlists.get(position).get(("imga"))).into(holder.timga);

     /* holder.tsrno.setText(listioteam.getSrno());
        holder.tpostid.setText(listioteam.getPostid());
        holder.tposttype.setText(listioteam.getPosttype());
        holder.tposttitle.setText(listioteam.getPosttitle());
        holder.tpostby.setText(listioteam.getPostby());
        holder.ttages.setText(listioteam.getTags());
        holder.tshortdes.setText(listioteam.getShortdescription());
        holder.tpostdes.setText(listioteam.getPostdescription());

        Picasso.with(context).load(listioteam.getPhoto1()).into(holder.imga);
        Picasso.with(context).load(listioteam.getPhoto2()).into(holder.imgb);
        Picasso.with(context).load(listioteam.getPhoto3()).into(holder.imgc);
        Picasso.with(context).load(listioteam.getPhoto4()).into(holder.imgd);
        Picasso.with(context).load(listioteam.getPhoto5()).into(holder.imge);

*/
    }

    @Override
    public int getItemCount() {
        return iteamlists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView trowid,tsrno,tpostid,tposttype,tposttitle,tpostby,ttages,tshortdes,tpostdes;
        ImageView timga,timgb,timgc,timgd,timge;

        public ViewHolder(View itemView) {
            super(itemView);

            trowid=(TextView)itemView.findViewById(R.id.rowid);
            tsrno=(TextView)itemView.findViewById(R.id.srno);
            tpostid=(TextView)itemView.findViewById(R.id.postid);
            tposttype=(TextView)itemView.findViewById(R.id.posttype);
            tposttitle=(TextView)itemView.findViewById(R.id.posttitle);
            tpostby=(TextView)itemView.findViewById(R.id.postby);
            ttages=(TextView)itemView.findViewById(R.id.tags);
            tshortdes=(TextView)itemView.findViewById(R.id.shortdescription);
            tpostdes=(TextView)itemView.findViewById(R.id.postdescription);
            timga=(ImageView)itemView.findViewById(R.id.photoa);
            timgb=(ImageView)itemView.findViewById(R.id.photob);
            timgc=(ImageView)itemView.findViewById(R.id.photoc);
            timgd=(ImageView)itemView.findViewById(R.id.photod);
            timge=(ImageView)itemView.findViewById(R.id.photoe);
        }
    }

}
