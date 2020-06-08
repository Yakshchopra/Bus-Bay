package com.;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
​ import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity
{
    ListView listView;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("Your URL");
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(
                this,
                String.class,
                android.R.layout.simple_list_item_1,
                databaseReference)
        {
            @Override protected void populateView(View v, String model, int position)
            {
                TextView textView =(TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };
        listView.setAdapter(firebaseListAdapter);
    }
}
    Gradle

            packagingOptions
{
        exclude 'META-INF/DEPENDENCIES'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/notice.txt'
        ​}


        compile 'com.firebase:firebase-client-android:2.5.2'
        compile 'com.google.firebase:firebase-database:11.0.0'
        compile 'com.firebaseui:firebase-ui-database:2.0.0'