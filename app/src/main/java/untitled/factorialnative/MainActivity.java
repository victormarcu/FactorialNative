package untitled.factorialnative;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numberEntryField;
    private TextView factorizedResultView;
    private TextView resultTextView;
    private Vibrator myVib;
    private double number;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEntryField = findViewById(R.id.numberEntry);
        factorizedResultView = findViewById(R.id.numberDisplay);
        resultTextView = findViewById(R.id.resultTextView);
        Button factorizeButton = findViewById(R.id.factorizeButton);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        /*
            On button pressed: Get the number entered by the user and
            call the native method that recursively factorizes the number.
            Display the result.
         */
        factorizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.vibrate(25);

                //Try to get the input number from the NumberEntry field.
                try {
                    number = Double.parseDouble(numberEntryField.getText().toString());

                    String inputInfo = getString(R.string.infoNumberEntered, number);
                    resultTextView.setText(inputInfo);

                    //display the result of the native function call
                    factorizedResultView.setText(String.valueOf(factorial(number)));
                    numberEntryField.setText(getString(R.string.blank));

                }catch(NumberFormatException e){
                    factorizedResultView.setText(getString(R.string.blank));
                    resultTextView.setText(getString(R.string.result));
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * Invoking a native method that is implemented in the Factorial Controller.
     */
    public native double factorial(double number);
}
