package com.guigu.day01_contentprovider;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsActivity extends AppCompatActivity {
    ListView lv_contact_list;
    private List<Map<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        lv_contact_list = (ListView)findViewById(R.id.lv_contact_list);


        initData();

        ContactAdapter adapter=new ContactAdapter();

        lv_contact_list.setAdapter(adapter);


        lv_contact_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String number = list.get(position).get("number");
                Intent intent = getIntent();
                intent.putExtra("number2",number);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }

    class ContactAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(ContactsActivity.this,R.layout.item_contact,null);
                holder=new ViewHolder();
                convertView.setTag(holder);

                TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                TextView tv_telephone = (TextView) convertView.findViewById(R.id.tv_telephone);

                holder.tv_name=tv_name;
                holder.tv_telephone=tv_telephone;

            }else{
                holder= (ViewHolder) convertView.getTag();
            }

            Map<String, String> map = list.get(position);
            String name = map.get("name");
            String number = map.get("number");

            holder.tv_name.setText(name);
            holder.tv_telephone.setText(number);


            return convertView;
        }

        class ViewHolder {
            TextView tv_name;
            TextView tv_telephone;

        }
    }

    private void initData() {
        list = new ArrayList<>();
        ContentResolver resolver = this.getContentResolver();

        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String name= ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
        String number= ContactsContract.CommonDataKinds.Phone.NUMBER;

        Cursor cursor = resolver.query(uri, new String[]{name, number}, null, null, null);

        while(cursor.moveToNext()){
            Map<String,String> map=new HashMap<>();
            String nameValue = cursor.getString(0);
            String numberValue = cursor.getString(1);
            map.put("name",nameValue);
            map.put("number",numberValue);
            list.add(map);
        }

        cursor.close();

    }
}
