package com.ars.automation;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;



import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class menu extends Activity {
	BluetoothAdapter mBluetoothAdapter;
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;
    OutputStream mmOutputStream;
    InputStream mmInputStream;
	Editable nameb;
	String blname="HC-05";
	int stat;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.rooms);


	
	    //final EditText name = (EditText) (findViewById(R.id.editText1));
	    Button ok = (Button) (findViewById(R.id.button1));
	    ok.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//nameb = name.getText();
			//blname = nameb.toString();
			try {
				findBT();
				stat = 1;
			} catch (IOException e) {
				stat = 0;
				e.printStackTrace();
			}
				
			}
		});

	
	    final ToggleButton light1 = (ToggleButton) findViewById(R.id.toggleButton1);
	    light1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (light1.isChecked()) {
					if (stat == 1){
					try {
						mmOutputStream.write('1');
					}catch (IOException e) {
						// TODO Auto-generated catch block
						Toast.makeText(menu.this,
								"Connection succesfully failed!!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					} else
						  Toast.makeText(menu.this,
									"Connection succesfully failed!!",
									Toast.LENGTH_LONG).show();
				}else {
					if (stat == 1){
					try {
						mmOutputStream.write('2');
					}catch (IOException e) {
						// TODO Auto-generated catch block
						Toast.makeText(menu.this,
								"Connection succesfully failed!!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					} else
						  Toast.makeText(menu.this,
									"Connection succesfully failed!!",
									Toast.LENGTH_LONG).show();
				}
			}
		});


	    final ToggleButton light2 = (ToggleButton) findViewById(R.id.ToggleButton01);
	    light2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (light2.isChecked()) {
					if (stat == 1){
					try {
						mmOutputStream.write('3');
					}catch (IOException e) {
						// TODO Auto-generated catch block
						Toast.makeText(menu.this,
								"Connection succesfully failed!!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					} else
						  Toast.makeText(menu.this,
									"Connection succesfully failed!!",
									Toast.LENGTH_LONG).show();
				}else {
					if (stat == 1){
					try {
						mmOutputStream.write('4');
					}catch (IOException e) {
						// TODO Auto-generated catch block
						Toast.makeText(menu.this,
								"Connection succesfully failed!!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					} else
						  Toast.makeText(menu.this,
									"Connection succesfully failed!!",
									Toast.LENGTH_LONG).show();
				}
			}
		});

	    final ToggleButton light3 = (ToggleButton) findViewById(R.id.light3);
	    light3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (light3.isChecked()) {
					if (stat == 1){
					try {
						mmOutputStream.write('5');
					}catch (IOException e) {
						// TODO Auto-generated catch block
						Toast.makeText(menu.this,
								"Connection succesfully failed!!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					} else
						  Toast.makeText(menu.this,
									"Connection succesfully failed!!",
									Toast.LENGTH_LONG).show();
				}else {
					if (stat == 1){
					try {
						mmOutputStream.write('6');
					}catch (IOException e) {
						// TODO Auto-generated catch block
						Toast.makeText(menu.this,
								"Connection succesfully failed!!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
					} else
						  Toast.makeText(menu.this,
									"Connection succesfully failed!!",
									Toast.LENGTH_LONG).show();
				}
			}
		});


	
	}
	
	
	void findBT() throws IOException
    {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
       // if(mBluetoothAdapter == null)
        //{
          //  myLabel.setText("No bluetooth adapter available");
        //}

        if(!mBluetoothAdapter.isEnabled())
        {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 1);
            
        }

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                if(device.getName().equals("HC-05"))//FireFly-B1A7Change to the name of your bluetooth module (Case sensitive)
                {
                    mmDevice = device;
                    break;
                }
            }
        }
       // myLabel.setText("Bluetooth Device Found");
    

      	UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard //SerialPortService ID
       
		mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
		
        mmSocket.connect();
        mmOutputStream = mmSocket.getOutputStream();
        mmInputStream = mmSocket.getInputStream();
       
      //  beginListenForData();

       // myLabel.setText("Bluetooth Opened");
}
	

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu);
	MenuInflater h= getMenuInflater();
	h.inflate(R.menu.hardmenu,menu);
	return true;
	}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stubf
	switch(item.getItemId())
	{
	case R.id.abou:
		startActivity(new Intent("com.ars.automation.ABOUT"));
		return true;
	}
	return false;
}







}
