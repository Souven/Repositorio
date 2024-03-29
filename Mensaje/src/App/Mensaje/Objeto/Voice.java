package App.Mensaje.Objeto;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Voice extends Activity 
{
	 Button BVoice;
	 private static final int REQUEST_CODE = 1234;
	 private ListView wordsList;
	 private ArrayList<String> matches;
	
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.voice);
       
       Button speakButton = (Button) findViewById(R.id.speakButton);
       
       wordsList = (ListView) findViewById(R.id.list);

       // Disable button if no recognition service is present
       PackageManager pm = getPackageManager();
       List<ResolveInfo> activities = pm.queryIntentActivities(
               new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
       if (activities.size() == 0)
       {
           speakButton.setEnabled(false);
           speakButton.setText("Recognizer not present");
       }
   }
   
   /**
    * Handle the action of the button being clicked
    */
   public void speakButtonClicked(View v)
   {
       startVoiceRecognitionActivity();
   }

   /**
    * Fire an intent to start the voice recognition activity.
    */
   private void startVoiceRecognitionActivity()
   {
       Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
       intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
               RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
       intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
       startActivityForResult(intent, REQUEST_CODE);
   }

   /**
    * Handle the results from the voice recognition activity.
    */
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data)
   {
       if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
       {
           // Populate the wordsList with the String values the recognition engine thought it heard
           matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
           
           ArrayList<String> Result = recognitionwords(matches);
           
           wordsList.setAdapter (new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, Result) );
           
          //wordsList.setAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, matches));
       }
       super.onActivityResult(requestCode, resultCode, data);
   }
   
   public ArrayList<String> recognitionwords (ArrayList<String> matches){
   	Iterator iterador = matches.listIterator();
   	ArrayList <String> Results = new ArrayList<String>();
   	while (iterador.hasNext()){
   		String match = (String) iterador.next();
   		if (match.equals("hola")){
   			Results.add("Matach found is " + match);
   		}
   		else{
   			Results.add("March no found");
   		}
   	}
   	return Results;
   	
   }
}
