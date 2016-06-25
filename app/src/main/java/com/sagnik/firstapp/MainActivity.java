package com.sagnik.firstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getName();
    private static final String FILENAME="myfile.txt";
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
    private void writeToFile(String data)
    {
        try{
            OutputStreamWriter op=new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
            op.write(data);
            op.close();
        }
        catch (IOException e)
        {
            Log.e(TAG, "File write failed: "+e.toString());
        }
    }
    private String readFromFile()
    {
        String ret="";
        try {
            InputStream ip = openFileInput(FILENAME);
            if (ip != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(ip);
                BufferedReader br = new BufferedReader(inputStreamReader);

                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = br.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                ip.close();
                ret = stringBuilder.toString();
            }
        }
        catch(FileNotFoundException e) {
            Log.e(TAG, "File not Found"+ e.toString());
        }
        catch (IOException e) {
            Log.e(TAG, "Can not read FILE"+ e.toString());
        }

        return ret;
    }

    public void loadMiniontext(View view)
    {
        Toast.makeText(getApplicationContext(),"Loading strings...",Toast.LENGTH_LONG).show();
        dis.setText(readFromFile());
    }


    public void minionMe(View view)
    {
        String txt1,txt2, text;
        txt1=inp1.getText().toString();
        txt2=inp2.getText().toString();
        text=txt1.concat(" "+txt2);

        writeToFile(text);
        Toast.makeText(getApplicationContext(),"Strings SAVED",Toast.LENGTH_SHORT).show();


//        dis.setText(inp1.getText()+" "+inp2.getText());
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

        TextView text1 = (TextView) layout.findViewById(R.id.text);
        text1.setText("Sagnik loves Minions");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
