package com.ikaratruyen.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ikaratruyen.R;
import com.ikaratruyen.adapter.IMenuAdapter.ViewHolder;
import com.ikaratruyen.model.Book;
import com.ikaratruyen.model.ItemFont;
import com.nostra13.universalimageloader.core.ImageLoader;

public class FontAdapter extends BaseAdapter{
	
	private static final String TAG = "FontAdapter";
	boolean canLoadMore=true;
	private Context context;
	int nNewPosition=-1;
	
	private ArrayList<ItemFont> chaps;
	public FontAdapter(Context context, ArrayList<ItemFont> chaps){
		this.context = context;
		this.chaps = chaps;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return chaps.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return chaps.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		boolean shouldAnimation = false;
		if (nNewPosition<=position){
			shouldAnimation = true;
			nNewPosition = position;
		}
		
		ViewHolder holder = null;
        
        LayoutInflater mInflater = (LayoutInflater) 
            context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
        	convertView = mInflater.inflate(R.layout.row_chapter, parent, false);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.tv_title_chap);
            holder.imgCheck = (ImageView) convertView.findViewById(R.id.img_check);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        if(chaps.get(position).isCheck()){
        	holder.imgCheck.setVisibility(View.VISIBLE);
        }else{
        	holder.imgCheck.setVisibility(View.GONE);
        }
        
    	holder.txtTitle.setText(chaps.get(position).getTitle());

		return convertView;
	}

	private class ViewHolder {
		TextView txtTitle;
		ImageView imgCheck;
	}
}
