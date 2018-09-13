package com.app.trabalho.everton.com.calcmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private class ViewHolder{
        EditText editNp1;
        EditText editPim;
        TextView textNp2;
        Button btnCalcular;
    }

    ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editNp1 = (EditText) findViewById(R.id.editNp1);
        this.mViewHolder.editPim = (EditText) findViewById(R.id.editPim);
        this.mViewHolder.textNp2 = (TextView) findViewById(R.id.textNp2);
        this.mViewHolder.btnCalcular = (Button) findViewById(R.id.btnCalcular);

        this.mViewHolder.btnCalcular.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnCalcular){
            if(this.mViewHolder.editNp1.getText().toString().trim().equals("") ||
                    this.mViewHolder.editPim.getText().toString().trim().equals("")){
                Toast.makeText(this, "Valores incorretos", Toast.LENGTH_SHORT).show();
            }else{
                double np1,pim;
                np1 = Double.valueOf(this.mViewHolder.editNp1.getText().toString());
                pim = Double.valueOf(this.mViewHolder.editPim.getText().toString());


                this.mViewHolder.textNp2.setText(String.format("%.2f",(5-(pim*0.2)-(np1*0.4))/0.4));

            }
        }
    }
}
   // getText().toString().trim().equals("")