package app.it.testone_55410075;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity075 extends Activity implements OnClickListener{
private Button btnadd,btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout075);
        
      SQLDB_075 sqldb_075 = new SQLDB_075(this);
       sqldb_075.getWritableDatabase();
        
        btnadd = (Button) findViewById(R.id.btnAdd075);
        btnadd.setOnClickListener(this);
        btnshow =(Button) findViewById(R.id.btnshow075);
        btnshow.setOnClickListener(this);
        
        
       
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAdd075:
			Intent s =new Intent(MainActivity075.this,Add075.class);
			startActivity(s);
			break;
		case R.id.btnshow075:
			Intent k =new Intent(MainActivity075.this,Show1075.class);
			startActivity(k);
			break;
		default:
			break;
		}
		
	}

}
