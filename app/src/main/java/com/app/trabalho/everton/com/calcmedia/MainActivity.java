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
        EditText editNp2;
        EditText editPim;
        TextView textResult;
        TextView textNota;
        Button btnCalcular;
    }

    ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editNp1 = (EditText) findViewById(R.id.editNp1);
        this.mViewHolder.editNp2 = (EditText) findViewById(R.id.editNp2);
        this.mViewHolder.editPim = (EditText) findViewById(R.id.editPim);
        this.mViewHolder.textResult = (TextView) findViewById(R.id.textResult);
        this.mViewHolder.textNota =  (TextView) findViewById(R.id.textNota);
        this.mViewHolder.btnCalcular = (Button) findViewById(R.id.btnCalcular);

        this.mViewHolder.btnCalcular.setOnClickListener(this);

    }
    public void  calculate(){

        if (this.mViewHolder.editNp1.getText().toString().trim().equals("") &&
                this.mViewHolder.editNp2.getText().toString().trim().equals("")&&
                this.mViewHolder.editPim.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Todos os Campos vazios", Toast.LENGTH_SHORT).show();

        }else if(!this.mViewHolder.editNp1.getText().toString().trim().equals("") &&
                !this.mViewHolder.editNp2.getText().toString().trim().equals("")&&
                this.mViewHolder.editPim.getText().toString().trim().equals("")){
            //calcular o quanto precisa no pim
            double np1,np2;
            np2 = Double.valueOf(this.mViewHolder.editNp2.getText().toString());
            np1 = Double.valueOf(this.mViewHolder.editNp1.getText().toString());
            this.mViewHolder.textNota.setText("No Pim voçê precissa tirar no minimo:");
            this.mViewHolder.textResult.setText(String.format("%.2",(5-((np2*0.4)+(np1*0.4)))/0.2));

        }else if(this.mViewHolder.editNp1.getText().toString().trim().equals("") &&
                !this.mViewHolder.editNp2.getText().toString().trim().equals("")&&
                !this.mViewHolder.editPim.getText().toString().trim().equals("")){
             //calcular o quanto precisa na np1dfd
            double np2,pim;
            np2 = Double.valueOf(this.mViewHolder.editNp2.getText().toString());
            pim = Double.valueOf(this.mViewHolder.editPim.getText().toString());
            this.mViewHolder.textNota.setText("Na np1 voçê precissa tirar no minimo:");
            this.mViewHolder.textResult.setText(String.format("%.2",(5-(pim*0.2)-(np2*0.4))/0.4));

        }else if(!this.mViewHolder.editNp1.getText().toString().trim().equals("") &&
                this.mViewHolder.editNp2.getText().toString().trim().equals("")&&
                !this.mViewHolder.editPim.getText().toString().trim().equals("")){
             //calcular o quanto precisa na np2
            double np1,pim;
            np1 = Double.valueOf(this.mViewHolder.editNp1.getText().toString());
            pim = Double.valueOf(this.mViewHolder.editPim.getText().toString());
            this.mViewHolder.textNota.setText("Na np2 voçê precissa tirar no minimo:");
            this.mViewHolder.textResult.setText(String.format("%.2",(5-(pim*0.2)-(np1*0.4))/0.4));

        }else if(!this.mViewHolder.editNp2.getText().toString().trim().equals("")&&
                !this.mViewHolder.editNp2.getText().toString().trim().equals("")&&
                !this.mViewHolder.editPim.getText().toString().trim().equals("")) {
             //calcular media
            double np1,np2,pim;
            np2 = Double.valueOf(this.mViewHolder.editNp2.getText().toString());
            np1 = Double.valueOf(this.mViewHolder.editNp1.getText().toString());
            pim = Double.valueOf(this.mViewHolder.editPim.getText().toString());
            this.mViewHolder.textNota.setText("Sua média será:");
            this.mViewHolder.textResult.setText(String.format("%.2",((np1*0.4)+(np2*0.4))+(pim*0.2)));
        }else{
            Toast.makeText(this, "coloque mais uma nota", Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnCalcular){
            calculate();

        }
    }
}
   // getText().toString().trim().equals("")