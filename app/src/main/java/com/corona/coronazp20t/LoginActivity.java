package com.corona.coronazp20t;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //reikalinga atidaryti tuscia langa
        setContentView(R.layout.activity_login); //i tuscia langa ikrauna sukurta vaizda
        //visas kodas rasomas po sito komentaro
        Button loginbatonas = findViewById(R.id.loginbatonas);//tokiu budu issitraukiam elementus
        //is vaizdo
        final EditText usernametext = findViewById(R.id.usernametext);
        final EditText passwordtext = findViewById(R.id.passwordtext);
        loginbatonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cia bus vygdomas kodas po batono paspaudimo
               /* Toast.makeText(LoginActivity.this,
                        "Prisijungimo Vardas:"+usernametext.getText().toString()+"\n"+
                        "Slaptazodis:"+passwordtext.getText().toString(),
                        Toast.LENGTH_SHORT).show(); */
                if (Validation.isValidUsername(usernametext.getText().toString()))
                {
                    //konstruojamas objektas
                    //public User(String username, String password, String email)
                    User user=new User(usernametext.getText().toString(),passwordtext.getText().toString());
                    Toast.makeText(LoginActivity.this,
                            "Username:"+ user.getUsername()+"\n"+
                                    "Password:"+user.getPassword()+"\n",
                            Toast.LENGTH_SHORT).show();

                    //ketinimas pereiti i paieskos langa
                    Intent goToSearchActivity = new Intent(LoginActivity.this,//from
                            SearchActivity.class);//to
                    startActivity(goToSearchActivity);//cia pereina
                }
                else { //Kai duomenys neatinka reikalavimų
                    usernametext.setError(getResources().getString(R.string.login_invalid_username));
                    usernametext.requestFocus(); //Naudojamam laukely išmeta pranešimą
                }

            }
        });
    }

}
