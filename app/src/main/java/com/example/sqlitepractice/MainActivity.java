package com.example.sqlitepractice;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteHelper = new SqliteHelper(this);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //show("dadaaa","paa");

                textView.setText("nai nai");

               // sqliteHelper.insertData("Nadim","Nadim Mahmud",13);
               // sqliteHelper.insertData("Jui","Jui Pagli",1300);

                boolean l = sqliteHelper.updatetData("1","sssssss","zzzzz",121);

                Cursor cursor  = sqliteHelper.getData();

                if(cursor.getCount()==0){

                }{
                    StringBuffer str = new StringBuffer();

                    while(cursor.moveToNext()){
                        str.append("ID : " + cursor.getString(0) +"\n");
                        str.append("Name : " + cursor.getString(1) +"\n" );
                        str.append("Surname : " + cursor.getString(2)+"\n" );
                        str.append("marks : " + cursor.getString(3) +"\n\n");
                    }

                    show("DATA ",str.toString());

                    textView.setText(str.toString());
                }
            }
        });

    }

    public  void show(String title ,String massage){

        AlertDialog.Builder bul = new AlertDialog.Builder(this);

        bul.setCancelable(true);
        bul.setTitle(title);
        bul.setMessage(massage);
    }
}
