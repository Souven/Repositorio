package App.Mensaje.Objeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import 	android.util.Log;

public class Text extends Activity {
	Button Btext;
	Button Bsend;
	EditText Sintomas;
	TextView Logs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		Bsend = (Button) findViewById(R.id.BtnSend);
		Sintomas = (EditText) findViewById(R.id.Emessage);
		Logs = (TextView) findViewById(R.id.TVtext);
		SendMessage();
	}
	
	public void SendMessage(){
		final String TAG = "MyActivity";
		Bsend.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
    			Log.v(TAG,Environment.getExternalStorageDirectory().toString());
    			String Result = Sintomas.getText().toString();
    			File directory = new File (Environment.getExternalStorageDirectory().toString() + "/Tesis");
    			directory.mkdirs();
    			File file = new File(directory, "mysdfile.txt");
    			FileOutputStream fOut;
				try {
					fOut = new FileOutputStream(file);
					OutputStreamWriter osw = new OutputStreamWriter(fOut);
					osw.write(Result);
					osw.flush();
					osw.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
				Logs.setText("DOCUMENTO GUARDADO!");
 
			}
	});
	}
}
