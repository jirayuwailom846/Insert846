package app.buusk15.sqlite_846;

	import android.app.Activity;
	import android.app.AlertDialog;
	import android.os.Bundle;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.Toast;

	public class AddActivity extends Activity {

		private EditText edt1, edt2, edt3, edt4, edt5, edt6, edt7;
		private Button btn_save;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.add);
			
			edt1 = (EditText) findViewById(R.id.edt_name);
			edt2 = (EditText) findViewById(R.id.edt_Age);
			edt3 = (EditText) findViewById(R.id.edt_blood);
			edt4 = (EditText) findViewById(R.id.edt_cities);
			edt5 = (EditText) findViewById(R.id.edt_birth);
			edt6 = (EditText) findViewById(R.id.edt_hob);
			edt7 = (EditText) findViewById(R.id.edt_religion);
			btn_save = (Button) findViewById(R.id.btn_save);
			
			btn_save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(v == btn_save){
						Save();
					}
						
					
				}
			});
		}
		
		public boolean Save(){
			edt1 = (EditText) findViewById(R.id.edt_name);
			edt2 = (EditText) findViewById(R.id.edt_Age);
			edt3 = (EditText) findViewById(R.id.edt_blood);
			edt4 = (EditText) findViewById(R.id.edt_cities);
			edt5 = (EditText) findViewById(R.id.edt_birth);
			edt6 = (EditText) findViewById(R.id.edt_hob);
			edt7 = (EditText) findViewById(R.id.edt_religion);
			final AlertDialog.Builder adb = new AlertDialog.Builder(this);
			AlertDialog ad = adb.create();
			/*if (edt1.getText().length() == 0) {
				ad.setMessage("Please input Name");
				edt1.requestFocus();
				return false;
			}
			if (edt2.getText().length() == 0) {
				ad.setMessage("Please input Age");
				edt2.requestFocus();
				return false;
			}*/
			control846DB dbClass = new control846DB(this);
			long savedata = dbClass.InsertData(edt1.getText().toString(), edt2
					.getText().toString(), edt3.getText().toString(), edt4
					.getText().toString(), edt5.getText().toString(), edt6
					.getText().toString(), edt7.getText().toString());
			if (savedata <= 0) {
				ad.setMessage("No....!");
				ad.show();
				return false;
			}
			Toast.makeText(getApplicationContext(), "Add Data Successfully",
					Toast.LENGTH_SHORT).show();
			return true;
			
		}
	}


