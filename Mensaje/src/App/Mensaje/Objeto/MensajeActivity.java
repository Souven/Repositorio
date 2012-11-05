package App.Mensaje.Objeto;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MensajeActivity extends Activity {
    /** Called when the activity is first created. */
	Button Btext;
	Button Bvoice;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addListenerOnButton();
    }
    
    public void addListenerOnButton() {
    	final Context context = this;
    	Btext = (Button) findViewById(R.id.btnWrite);
    	Bvoice = (Button) findViewById(R.id.btnVoice);
    	
    	Btext.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Text.class);
                            startActivity(intent);   
 
			}
    	});
    	Bvoice.setOnClickListener(new OnClickListener() {
    		public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Voice.class);
                            startActivity(intent);   
 
			}
    	});
    }
    
}