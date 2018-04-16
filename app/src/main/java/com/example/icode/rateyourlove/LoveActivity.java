package com.example.icode.rateyourlove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoveActivity extends AppCompatActivity {

    //Edit Text field for first and second partner
    private EditText fPartner;
    private EditText sPartner;

    //Button for check love rate
    private Button checkLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        //findViewByIds for the EditText fields
        fPartner = (EditText)findViewById(R.id.first_partner_name);
        sPartner = (EditText)findViewById(R.id.second_partner_name);

        //findViewByIds for the EditText fields
        checkLove = (Button)findViewById(R.id.calcBtn);

    }

    public void onCheckLoveRate(View view){
        //gets input from the user through the Editfield
        String first_p = fPartner.getText().toString().trim();
        String second_p = sPartner.getText().toString().trim();

        if(first_p.isEmpty() || second_p.isEmpty()){
            Toast.makeText(LoveActivity.this,"Please enter both names first",Toast.LENGTH_LONG).show();
        }
        else if( first_p.equalsIgnoreCase(second_p) || second_p.equalsIgnoreCase(first_p)){
            Toast.makeText(LoveActivity.this,"Please enter different names for both fields",Toast.LENGTH_LONG).show();
        }
        else
        {
            int first_num = getNumber(first_p);
            int second_num = getNumber(second_p);

            //gets the average of the count of the number of characters in each string entered
            int avg_of_num = ((first_num + second_num) / 2) % 100;

            Toast.makeText(this, " YoUr LOve is :\t " + avg_of_num + "%", Toast.LENGTH_LONG).show();
        }

    }

    //gets the count of the number of characters in the string entered
    public int getNumber(String s){
        int i = 0;
        int sum = 0;
        //loops through the strings and counts the number  of characters within each string
        while(i < s.length()){
            char c = s.charAt(i);
            int ASCII = (int)c;
            sum = sum + ASCII;
            i++;
        }
        return sum;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent intentAbout = new Intent(LoveActivity.this, AboutUsActivity.class);
                startActivity(intentAbout);
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
       // return super.onOptionsItemSelected(item);
    }
}
