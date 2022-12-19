package com.example.project_1.data;

import android.content.Context;

import com.example.project_1.Item;
import com.example.project_1.data.model.LoggedInUser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private LoggedInUser user;
    private Context mContext;
    private static final String FILENAME = "users.txt";



    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
            user = null;
    }

    private void checkUsers(String username, String password) throws IOException{
        BufferedReader reader = null;

        try{
            FileInputStream inputStream = mContext.openFileInput(FILENAME);
            reader = new BufferedReader(new InputStreamReader(inputStream))

            String tempLine;
            while((tempLine = reader.readLine()) != null){
                if(tempLine.equals(username)){
                    user =
                    reader.readLine()
                }

            }
        }
        catch (FileNotFoundException ex){
            //ignored for now
        }
        finally{
            if (reader != null){
                reader.close();
            }
        }
    }
}