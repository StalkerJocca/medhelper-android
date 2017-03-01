package com.tecwidgets.medhelper;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import static com.tecwidgets.medhelper.R.layout.login;

/**
 * Created by João Costa on 24/02/2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    AlertDialog alertDialog;

    BackgroundTask(Context ctx) {this.ctx = ctx;}


    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");
    }


    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.0.2.2/Appmysql/register.php";
        String login_url = "http://10.0.2.2/Appmysql/login.php";
        String method = params[0];

        if (method.equals("register")){
            String nome = params [1];
            String nome_user = params [2];
            String nome_pass = params [3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("nome", "UTF-8") + "=" + URLEncoder.encode(nome, "UTF-8") + "&" +
                        URLEncoder.encode("nome_user", "UTF-8") + "=" + URLEncoder.encode(nome_user, "UTF-8") + "&" +
                        URLEncoder.encode("nome_pass", "UTF-8") + "=" + URLEncoder.encode(nome_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Sucess...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (method.equals(login)) {
            String nome_user = params[1];
            String nome_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("nome_user", "UTF-8") + "=" + URLEncoder.encode(nome_user, "UTF-8") + "&" +
                        URLEncoder.encode("nome_pass", "UTF-8") + "=" + URLEncoder.encode(nome_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    response += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {super.onProgressUpdate();}

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Registration Sucess...")){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

}
