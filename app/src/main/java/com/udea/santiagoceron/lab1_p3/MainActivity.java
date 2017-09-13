package com.udea.santiagoceron.lab1_p3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Float n1,n2,res;
    private TextView tScreen;
    private boolean Add,Subs,Mult,Divi;
    int num_op;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tScreen = (TextView) findViewById(R.id.tScreen);
        tScreen.setText(null);
        clear();

    }

//capture numbers and dot-----------------------------------------------------------
//--------------------------------------------------------
    public void bZero(View view){
        tScreen.setText(tScreen.getText() + "0");
    }
    public void bOne(View view){
        tScreen.setText(tScreen.getText() + "1");
    }
    public void bTwo(View view){
        tScreen.setText(tScreen.getText() + "2");
    }
    public void bThree(View view){
        tScreen.setText(tScreen.getText() + "3");
    }
    public void bFour(View view){
        tScreen.setText(tScreen.getText() + "4");
    }
    public void bFive(View view){
        tScreen.setText(tScreen.getText() + "5");
    }
    public void bSix(View view){
        tScreen.setText(tScreen.getText() + "6");
    }
    public void bSeven(View view){
        tScreen.setText(tScreen.getText() + "7");
    }
    public void bEight(View view){
        tScreen.setText(tScreen.getText() + "8");
    }
    public void bNine(View view){
        tScreen.setText(tScreen.getText() + "9");
    }
    public void bDot(View view){
        String aux = tScreen.getText().toString();
        int prueba = debug_op();
        // not contains .
        if (    (!aux.contains(".")) ){
            tScreen.setText(tScreen.getText() + ".");
        }
        //comprobar segundo numero no más de un punto
        if (    (aux.contains(".")) &&  (debug_op()==4) ) {
            String aux1 = tScreen.getText().toString();
            String[] aux2 = aux1.split(" ");
            if (    !(aux2[2].contains("."))    ){
                tScreen.setText(tScreen.getText() + ".");;
            }
    }}

//Operate-----------------------------------------------------------
//--------------------------------------------------------
    public void bAdd(View view){
        //empty
        if (tScreen.getText().toString().isEmpty()) return;
        Add = true;
        //first operand
        if (debug_op() == 2) {
            n1 = Float.parseFloat(tScreen.getText().toString());
            tScreen.setText(tScreen.getText() + " + ");
        }
        //repeated operand
        if (debug_op() == 3) Add = false;

    }
    public void bSubs(View view){
       //empty
        if (tScreen.getText().toString().isEmpty()) return;
        Subs = true;
        //first operand
        if (debug_op() == 2) {
            n1 = Float.parseFloat(tScreen.getText().toString());
            tScreen.setText(tScreen.getText() + " - ");
        }
        //repeated operand
        if (debug_op() == 3) Subs = false;
    }
    public void bMult(View view){
        //empty
        if (tScreen.getText().toString().isEmpty()) return;
        Mult = true;
        //first operand
        if (debug_op() == 2) {
            n1 = Float.parseFloat(tScreen.getText().toString());
            tScreen.setText(tScreen.getText() + " * ");
        }
        //repeated operand
        if (debug_op() == 3) Mult = false;
    }
    public void bDivide(View view){
        //empty
        if (tScreen.getText().toString().isEmpty()) return;
        Divi = true;
        //first operand
        if (debug_op() == 2) {
            n1 = Float.parseFloat(tScreen.getText().toString());
            tScreen.setText(tScreen.getText() + " / ");
        }
        //repeated operand
        if (debug_op() == 3) Divi = false;
    }
    public void bEqual(View view){
        if (debug_op()==1) return; //no operation
        String aux1 = tScreen.getText().toString();
        String[] aux2 = aux1.split(" ");
        n2 = Float.parseFloat(aux2[2]);

        if (Add) res = n1+n2;
        if (Subs) res = n1-n2;
        if (Mult) res = n1*n2;
        if (Divi) res =n1/n2;

        tScreen.setText(res.toString());
        clear();

    }

//DEBUGGEAR repeticion de operadores--------------------
//--------------------------------------------------------
    public int debug_op(){
        num_op = 0;
        String aux = tScreen.getText().toString();
        boolean aux2 = aux.contains(" ");
        if (Mult) num_op += 1;
        if (Divi) num_op += 1;
        if (Add) num_op += 1;
        if (Subs) num_op += 1;
        //MORE THAN ONE OP
        if (num_op > 1){
            return 3;
        //NO OPERATOR
        } if (num_op == 0){
            return 1;
        }
        //FIRST OPERATOR IS SELECTED AT THAT MOMENT
        if(!aux2) return 2;
        //FIRST OPERATOR IS SELECTED (BEFORE)
        return 4;
    }

//LIMPIAR --------------------------------------------------------

    public void clear(){
        Add = false;
        Subs = false;
        Mult = false;
        Divi = false;
        num_op = 0;
    }

}
