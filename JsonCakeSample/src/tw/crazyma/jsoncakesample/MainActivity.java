package tw.crazyma.jsoncakesample;

import tw.crazyma.jsoncake.JsonCake;
import tw.crazyma.jsoncake.OnFinishLoadObjectListener;
import tw.crazyma.jsoncake.OnFinishLoadStringListener;
import tw.crazyma.jsoncake.OnTaskFailListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;


public class MainActivity extends Activity {

	private TextView textView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView) findViewById(R.id.text);
        
        httpGetTest();	
        
        /*	You can use http post	*/
//        httpPostTest();		  
    }

    private void httpGetTest(){
    	new JsonCake.Builder()
    	.setUrl("http://crazyma.comli.com/json/test.php")
    	.setObjectType(DataSet.class)
    	.setReadTimeout(5)
    	.setOnFinishListener(new OnFinishLoadObjectListener(){

			@Override
			public void onFinish(Object object) {
				// TODO Auto-generated method stub
				DataSet dataSet = (DataSet)object;
				textView.setText(dataSet.toString());
				Toast.makeText(getBaseContext(), "Got the response", Toast.LENGTH_LONG).show();
			}
    		
    	})
    	.setOnTaskFailListener(new OnTaskFailListener(){

			@Override
			public void onFail(String errorMessage, Exception exception) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "Task fail ...", Toast.LENGTH_LONG).show();
			}
    		
    	})
    	.get();
    }
    
    private void httpPostTest(){
    	RequestBody formBody = new FormEncodingBuilder()
        .add("name", "25sprout")
        .add("age", "25")
        .build();
        
        new JsonCake.Builder()
        	.setUrl("http://crazyma.comli.com/json/post_test.php")
        	.setOnFinishListener(new OnFinishLoadStringListener(){

				@Override
				public void onFinish(String responseStr) {
					// TODO Auto-generated method stub
					textView.setText(responseStr);
					Toast.makeText(getBaseContext(), "Got the response", Toast.LENGTH_LONG).show();
				}
        		
        	})
        	.setOnTaskFailListener(new OnTaskFailListener(){

				@Override
				public void onFail(String errorMessage, Exception exception) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(), "Task fail ...", Toast.LENGTH_LONG).show();
				}
        		
        	})
        	.setFormBody(formBody)
        	.post();
    }
}
