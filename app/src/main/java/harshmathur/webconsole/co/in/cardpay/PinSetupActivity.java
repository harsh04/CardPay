package harshmathur.webconsole.co.in.cardpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PinSetupActivity extends Activity implements View.OnClickListener{


    //TODO: add feature to changind lock image
    //TODO: code back button ( first check it)
    //TODO: code Verify Pin
    private int[] digit = new int[4];
    private int posOfPointer = 0;

    Button one,two,three,four,five,six,seven,eight,nine,zero,cross,next;
    ImageView[] digitImg = new ImageView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        next = (Button) findViewById(R.id.nextBtn);
        next.setEnabled(false);
        one = (Button) findViewById(R.id.num1);
        one.setOnClickListener(this);
        two = (Button) findViewById(R.id.num2);
        two.setOnClickListener(this);
        three = (Button) findViewById(R.id.num3);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.num4);
        four.setOnClickListener(this);
        five = (Button) findViewById(R.id.num5);
        five.setOnClickListener(this);
        six = (Button) findViewById(R.id.num6);
        six.setOnClickListener(this);
        seven = (Button) findViewById(R.id.num7);
        seven.setOnClickListener(this);
        eight = (Button) findViewById(R.id.num8);
        eight.setOnClickListener(this);
        nine = (Button) findViewById(R.id.num9);
        nine.setOnClickListener(this);
        zero = (Button) findViewById(R.id.num0);
        zero.setOnClickListener(this);
        cross = (Button) findViewById(R.id.cross);
        cross.setOnClickListener(this);

        digitImg[0] = (ImageView) findViewById(R.id.digit0);
        digitImg[1] = (ImageView) findViewById(R.id.digit1);
        digitImg[2] = (ImageView) findViewById(R.id.digit2);
        digitImg[3] = (ImageView) findViewById(R.id.digit3);

    }

    protected void imgHandler(int pos,int val){
        if(val == 0){
            digitImg[pos].setImageResource(R.drawable.unlock);
        }else if(val == 1){
            digitImg[pos].setImageResource(R.drawable.dot);
        }
    }


    public void verifyPin(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("infoondata-userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("digit0", String.valueOf(digit[0]));
        editor.putString("digit1", String.valueOf(digit[1]));
        editor.putString("digit2", String.valueOf(digit[2]));
        editor.putString("digit3", String.valueOf(digit[3]));
        editor.apply();
        startActivity(new Intent(PinSetupActivity.this, VerifyPinActivity.class));

    }

    private void buttonHandle(Boolean bool){
        next.setEnabled(!bool);
        one.setEnabled(bool);
        two.setEnabled(bool);
        three.setEnabled(bool);
        four.setEnabled(bool);
        five.setEnabled(bool);
        six.setEnabled(bool);
        seven.setEnabled(bool);
        eight.setEnabled(bool);
        nine.setEnabled(bool);
        zero.setEnabled(bool);

    }
    /* TO DISABLE BACKPRESS FOR SECURITY REASON */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.num0:
                digit[posOfPointer] = 0;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num1:
                digit[posOfPointer] = 1;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num2:
                digit[posOfPointer] = 2;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num3:
                digit[posOfPointer] = 3;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num4:
                digit[posOfPointer] = 4;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num5:
                digit[posOfPointer] = 5;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num6:
                digit[posOfPointer] = 6;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num7:
                digit[posOfPointer] = 7;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num8:
                digit[posOfPointer] = 8;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.num9:
                digit[posOfPointer] = 9;
                imgHandler(posOfPointer,1);
                if(posOfPointer == 3){
                    buttonHandle(false);
                }else {          
                    posOfPointer++;
                }
                break;
            case R.id.cross:
                posOfPointer = 0;
                imgHandler(0,0);
                imgHandler(1,0);
                imgHandler(2,0);
                imgHandler(3,0);
                buttonHandle(true);
                break;
            default: break;
        }
    }
}