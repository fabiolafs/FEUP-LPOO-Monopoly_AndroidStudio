package com.example.fabiola.monopoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import static android.R.layout.simple_list_item_1;

/**
 * Created by Fabiola on 29/05/2016.
 */
public class ManageListActivity extends Activity {

   private String myStringArray[] = new String[]{"sei la","outra coisa","mais uma","",""};

   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.manage_list);

       final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_list_item_1, myStringArray);

       final ListView listView = (ListView) findViewById(R.id.properties_listView);
       listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


               String theText = adapter.getItem(position);

               Intent i = new Intent(getApplicationContext(), ShowPropertyActivity.class);
               i.putExtra("property_name", theText);
               startActivity(i);

               /*
               //para saber qual é a propriedade nome
               EditText et = (EditText) findViewById(parent.getId());
               String theText = et.getText().toString();

               Intent i = new Intent(getApplicationContext(), ShowPropertyActivity.class);
               i.putExtra("property_name", theText);
               startActivity(i);
               */

               System.out.println("value : " + theText);
               System.out.println("PropertyPosition : " + position);
               System.out.println("Propertyid : " + id);
               System.out.println("PropertyParent : " + parent);
               System.out.println("-------------------------------------------");
           }
       });

   }
}
