package nyc.c4q.android.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import nyc.c4q.android.R;

public class LoginActivity extends Activity {

  private EditText emailField;
  private EditText passwordField;
  private Button loginButton;
    private ImageView logo;
  private final AuthenticationManager manager;
  int counter =4;

  public LoginActivity() {
    // TODO - fix this
//    AuthenticationManager manager = new AuthenticationManager() {
//      @Override
//      public boolean validateLogin(String email, String password) {
//
//        return false;
//      }
//    } return;
//
    manager = null;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
      logo = (ImageView)findViewById(R.id.logo);
    emailField=(EditText)findViewById(R.id.email);
    passwordField =(EditText)findViewById(R.id.password);
    loginButton =(Button)findViewById(R.id.login);

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (passwordField.getText().toString().equals("abc")){
          Toast.makeText(getApplicationContext(),"Logging in..", Toast.LENGTH_SHORT).show();
        }
        else{
          Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

          emailField.setVisibility(View.VISIBLE);
          emailField.setBackgroundColor(Color.RED);
          counter--;
          emailField.setText(Integer.toString(counter));

          if (counter == 0) {
            emailField.setEnabled(false);
          }
        }
      }
    });
      }

    // TODO - load view hierarchy in R.layout.activity_login

    // TODO - get references to views, and other setup

    // TODO - call checkCredentials via OnClickListener


  private void checkCredentials(String email, String password) {
    if(manager.validateLogin(email, password)) {
      // TODO - go to EmailListActivity
        setContentView(R.layout.activity_email_list);
    }
    else {
      // TODO launch alert dialog on failed login
      // check strings.xml for dialog
      Toast.makeText(getApplicationContext(), "Wrong Credentials, enter again",Toast.LENGTH_SHORT).show();
    }
  }
}
