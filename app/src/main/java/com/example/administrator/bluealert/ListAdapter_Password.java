package com.example.administrator.bluealert;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONException;

import java.util.List;


/**
 * Created by AndyChuo on 2016/4/5.
 *  建立自訂義清單:
 *      單一項目利用 list_item_checkbox 介面元件來建立
 */
public class ListAdapter_Password extends BaseAdapter
{
    EditText editText;
    private AppCompatActivity activity;
    private List<String> mList;
    DataControler dataControler;
    private static LayoutInflater inflater = null;

    public ListAdapter_Password(AppCompatActivity a)
    {
        activity = a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dataControler = MainActivity.dataControler;
    }

    public int getCount()
    {
        return 1;
    }

    public Object getItem(int position)
    {
        return position;
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {

        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        editText = (EditText) convertView.findViewById(R.id.editText3);

        return convertView;

    }
    public String getPassword(){
        return editText.getText().toString();
    }
    public EditText getEditEext(){
        return editText;
    }

}
