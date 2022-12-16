package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonOpenParenthesis,buttonCloseParenthesis,buttonMod,buttonAdd,buttonSub,buttonClear,buttonDiv,buttonMul,buttonDot,buttonEqual;
    TextView textDisplay,textExpression;

    float operand1=0,operand2=0;

    boolean isAdd,isSub,isMul,isDiv,isMod,isEqual=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDisplay = (TextView)findViewById(R.id.buttonDisplay);
        textExpression=(TextView)findViewById(R.id.buttonExpression);
        buttonOpenParenthesis=(Button)findViewById(R.id.buttonOpenParenthesis);
        buttonCloseParenthesis=(Button)findViewById(R.id.buttonCloseParenthesis);
        buttonMod=(Button)findViewById(R.id.buttonMod);
        buttonClear=(Button)findViewById(R.id.buttonClear);

        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        buttonDiv=(Button)findViewById(R.id.buttonDiv);

        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        buttonMul=(Button)findViewById(R.id.buttonMul);

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        buttonSub=(Button)findViewById(R.id.buttonSub);

        button0=(Button)findViewById(R.id.button0);
        buttonDot=(Button)findViewById(R.id.buttonDot);
        buttonEqual=(Button)findViewById(R.id.buttonEqual);
        buttonAdd=(Button)findViewById(R.id.buttonAdd);

        buttonOpenParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"(");
                textDisplay.setText(textDisplay.getText()+"(");
            }
        });

        buttonCloseParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+")");
                textDisplay.setText(textDisplay.getText()+")");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"0");
                textDisplay.setText(textDisplay.getText()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"1");
                textDisplay.setText(textDisplay.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"2");
                textDisplay.setText(textDisplay.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"3");
                textDisplay.setText(textDisplay.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"4");
                textDisplay.setText(textDisplay.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"5");
                textDisplay.setText(textDisplay.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"6");
                textDisplay.setText(textDisplay.getText()+"6"); }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"7");
                textDisplay.setText(textDisplay.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"8");
                textDisplay.setText(textDisplay.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"9");
                textDisplay.setText(textDisplay.getText()+"9");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+".");
                textDisplay.setText(textDisplay.getText()+".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"+");
                if(!textDisplay.equals("")){
                    operand1=Float.parseFloat(textDisplay.getText()+"");
                    isAdd=true;
                    textDisplay.setText("");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"-");
                /*if(!textDisplay.equals("")){
                    operand1=Float.parseFloat(textDisplay.getText()+"");
                    isSub=true;
                    textDisplay.setText("");
                }*/
                textDisplay.setText("");
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"*");
                /*if(!textDisplay.equals("")){
                    operand1=Float.parseFloat(textDisplay.getText()+"");
                    isMul=true;
                    textDisplay.setText("");
                }*/
                textDisplay.setText("");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"/");
                /*if(!textDisplay.equals("")){
                    operand1=Float.parseFloat(textDisplay.getText()+"");
                    isDiv=true;
                    textDisplay.setText("");
                }*/
                textDisplay.setText("");
            }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExpression.setText(textExpression.getText()+"%");
                /*if(!textDisplay.equals("")){
                    operand1=Float.parseFloat(textDisplay.getText()+"");
                    isMod=true;
                    textDisplay.setText("");
                }*/
                textDisplay.setText("");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textExpression.setText("");
                textDisplay.setText("");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*operand2=Float.parseFloat(textDisplay.getText()+"");
                if(isAdd==true)
                {
                    textDisplay.setText(operand1+operand2+"");
                    isAdd=false;
                }
                else if(isSub==true)
                {
                    textDisplay.setText(operand1-operand2+"");
                    isSub=false;
                }
                else if(isMul==true)
                {
                    textDisplay.setText(operand1*operand2+"");
                    isMul=false;
                }
                else if(isDiv==true)
                {
                    textDisplay.setText(operand1/operand2+"");
                    isDiv=false;
                }
                else if(isMod==true) {
                    textDisplay.setText(operand1 % operand2 + "");
                    isMod = false;
                }*/

                Context context= Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable=context.initSafeStandardObjects();
                String finalRes=context.evaluateString(scriptable,textExpression.getText().toString(),"Javascript",1,null).toString();
                textDisplay.setText(finalRes);


            }
        });

    }
}
