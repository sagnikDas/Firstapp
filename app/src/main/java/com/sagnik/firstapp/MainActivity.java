package com.sagnik.firstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText inp1,inp2;


    TextView dis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp1= (EditText)findViewById(R.id.input1);
        inp2= (EditText)findViewById(R.id.input2);
        dis=(TextView) findViewById(R.id.display);






    }
    public void minionMe(View view)
    {

        dis.setText(inp1.getText()+" "+inp2.getText());
/*        Context context=getApplicationContext();
        CharSequence text="Minions are superb!";
        int duration= Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();*/

        //Toast.makeText(MainActivity.this, "Hi this is Sagnik, Minions are superb !!!", Toast.LENGTH_SHORT).show();


        /*String s1=inp1.getText().toString();
        String s2=inp2.getText().toString();

        dis.setText(s1+" "+s2);
*/
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Sagnik loves Minions");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
