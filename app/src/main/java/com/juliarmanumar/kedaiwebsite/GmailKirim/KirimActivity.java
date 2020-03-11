package com.juliarmanumar.kedaiwebsite.GmailKirim;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.juliarmanumar.kedaiwebsite.R;

public class KirimActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirim_email);
		final Button send = (Button) this.findViewById(R.id.button1);
		final Button back = (Button) this.findViewById(R.id.kembali);

		sp_jnpaket();


		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				KirimActivity.super.onBackPressed();
			}
		});

		send.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
			kirim();
			}
		});
	}

	public void kirim(){
		Log.i("SendMailActivity", "Send Button Clicked.");


		String nama = ((TextView) findViewById(R.id.editText0))
                .getText().toString();

        String nomor = ((TextView) findViewById(R.id.nomorwhatsapp))
                .getText().toString();

        String jenpaket = ((TextView) findViewById(R.id.jenispaketnya))
                .getText().toString();

		String fromEmail = ((TextView) findViewById(R.id.editText1))
				.getText().toString();
		String fromPassword = ((TextView) findViewById(R.id.editText2))
				.getText().toString();
		String toEmails = "armanumar1996@gmail.com";
		List<String> toEmailList = Arrays.asList(toEmails
				.split("\\s*,\\s*"));
		Log.i("SendMailActivity", "To List: " + toEmailList);



		String emailSubject = ((TextView) findViewById(R.id.editText4)).getText().toString();



		String emailBody1 = ((TextView) findViewById(R.id.editText5))
				.getText().toString();





		/*
		String tbopen = "<table border=\"0\" style=\"padding: 2px\">";
		String tbcolose = "</table>";
		String tropen = "<tr>";
		String trcolose = "</tr>";
		String tdopen1 = "<td style=\"padding: 10px\" bgcolor=\"#34c4cf\">";
		String tdclose1 = "</td>";
		String tdopen2 = "<td style=\"padding: 10px\" bgcolor=\"#ededed\">";
		String tdclose2 = "</td>";
		String boldopen="<b>";
		String boldclose = "</b>";
		 */


		String emailBody = "<table border=\"0\" style=\"padding: 2px\">\t\n" +
                "<tr>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#34c4cf\"><b>Nama : </b></td>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#ededed\">"+nama+"</td>\n" +
                "</tr>\n" +
                "\n" +
                "\n" +
                "<tr>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#34c4cf\"><b>Email : </b></td>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#ededed\">"+fromEmail+"</td>\n" +
                "</tr>\n" +
                "\n" +
                "<tr>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#34c4cf\"><b>No HP/Whatsapp : </b></td>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#ededed\">"+nomor+"</td>\n" +
                "</tr>\n" +
                "\n" +
                "<tr>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#34c4cf\"><b>Jenis Paket</b></td>\n" +
                "\t<td style=\"padding: 10px\" bgcolor=\"#ededed\">"+jenpaket+"</td>\n" +
                "</tr>\n" +
                "\n" +
                "</table>";


		if ( nama.matches("") |fromEmail.matches("") | fromPassword.matches("") | emailSubject.matches("") | emailBody.matches("") ){

            Toast.makeText(this, "Harap isi data dengan benar", Toast.LENGTH_LONG).show();
            return;

        }
		else {

            new KirimTask(KirimActivity.this).execute(fromEmail,
                    fromPassword, toEmailList, emailSubject, emailBody);

        }

	}



	public void sp_jnpaket(){


		String data [] = {"1. PAKET WEBSITE", "2. PAKET DESIGN", "3. PAKET SEO"};

		Spinner spinner = (Spinner) findViewById(R.id.spinner);

		spinner.setPrompt("Silahkan pilih paket!");

		ArrayAdapter<String> spinneradapter  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinneradapter);

	}



}
