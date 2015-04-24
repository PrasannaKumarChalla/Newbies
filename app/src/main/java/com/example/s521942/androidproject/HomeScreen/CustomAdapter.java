package com.example.s521942.androidproject.HomeScreen; /**
 * Created by S521731 on 4/4/2015.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s521942.androidproject.MainActivity;
import com.example.s521942.androidproject.R;

public class CustomAdapter extends BaseAdapter{
    Typeface micky;

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Context context, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        this.context=context;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.layout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);


        micky=Typeface.createFromAsset(rowView.getContext().getAssets(),"fonts/funky.otf");
        holder.tv.setTypeface(micky);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
             switch (position) {
                 case 0:
                 ((MainActivity) context).onEventsClick();
                 break;
                 case 1:
                     ((MainActivity) context).onIncomingClick();
                     break;
                 case 3:
                     ((MainActivity) context).onStoresClick();
                     break;
                 case 5:
                     ((MainActivity) context).onBridgeClick();
                     break;
                 case 2:
                     ((MainActivity) context).onAccomodateClick();
                     break;
                 case 4:
                     ((MainActivity) context).onContactClicked();
                       break;
                 default:
                     Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                     break;
             }
            }
        });

        return rowView;
    }

}