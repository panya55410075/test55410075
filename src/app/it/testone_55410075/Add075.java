package app.it.testone_55410075;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Add075 extends Activity implements OnClickListener {
	private TextView t1;
	private EditText e1, e2, e3 ,e4 ;
	private Button Bok, Bsave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add075);

		t1 = (TextView) findViewById(R.id.textView5_075);
	//	t1.setText("kk");
		e1 = (EditText) findViewById(R.id.userID_075);
		e2 = (EditText) findViewById(R.id.name_075);
		e3 = (EditText) findViewById(R.id.score_075);
		//e4 = (EditText) findViewById(R.id.grade_075);
		Bok = (Button) findViewById(R.id.btnok_075);
		Bsave = (Button) findViewById(R.id.btnsave_075);
		Bsave.setOnClickListener(this);
		Bok.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnok_075:
			kobboonOK();
			break;
		case R.id.btnsave_075:
			kobboomSave();
			break;
		default:
			break;
		}
	}

	public boolean kobboomSave() {
		final AlertDialog.Builder ss = new AlertDialog.Builder(this);
		AlertDialog g = ss.create();

		if (e1.getText().length() == 0) {
			g.setMessage("Please input UserID");
			e1.requestFocus();
			return false;
		}
		if (e2.getText().length() == 0) {
			g.setMessage("Please input Name");
			e2.requestFocus();
			return false;
		}
		if (e3.getText().length() == 0) {
			g.setMessage("Please input score");
			e3.requestFocus();
			return false;
		}
		SQLDB_075 sqldb_075 = new SQLDB_075(this);
		long savedata = sqldb_075.InsertData(e1.getText().toString(), e2
				.getText().toString(), e3.getText().toString(), t1.getText()
				.toString());
		
		if (savedata <= 0) { 
			   g.setMessage("Error !!!!"); 
			   g.show(); 
			   return false; 
			  } 
			   
			   
		Toast.makeText(getApplicationContext(), "Add Data Successfully",Toast.LENGTH_SHORT).show(); 
		  return true; 
		 
	}
	public boolean kobboonOK() {
		String k = e3.getText().toString();
		Double d = Double.parseDouble(k);
		if(d>=80){
			t1.setText("a");
		}
		else if(d>=75&&d<80){
			t1.setText("b+");
		}
		else if(d>=70&&d<75){
			t1.setText("b");
		}
		else if(d>=65.00&&d<70){
			t1.setText("c+");
		}
		else if(d>=60.00&&d<65){
			t1.setText("c");
		}
		else if(d>=55&&d<60){
			t1.setText("d+");
		}
		else if(d>=50&&d<55){
			t1.setText("d");
		}
		 else{
			t1.setText("f");
		}
		Toast.makeText(getApplicationContext(), "ok",Toast.LENGTH_SHORT).show();
		
		return true;}
}
