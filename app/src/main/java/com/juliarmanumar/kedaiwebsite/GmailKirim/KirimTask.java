package com.juliarmanumar.kedaiwebsite.GmailKirim;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class KirimTask extends AsyncTask  {

    private Context context;
	private ProgressDialog statusDialog;
	private Activity KirimEmailActivity;

	public KirimTask (Activity activity) {
        KirimEmailActivity = activity;

	}

	public KirimTask() {
	}


	protected void onPreExecute() {
		statusDialog = new ProgressDialog(KirimEmailActivity);
		statusDialog.setMessage("Getting ready...");
		statusDialog.setIndeterminate(false);
		statusDialog.setCancelable(false);
		statusDialog.show();
	}

	@Override
	protected Object doInBackground(Object... args) {
		try {
			Log.i("KirimTask", "About to instantiate GMail...");
			publishProgress("Processing input....");
			GMailClass androidEmail = new GMailClass(args[0].toString(),
					args[1].toString(), (List) args[2], args[3].toString(),
					args[4].toString());
			publishProgress("Preparing mail message....");
			androidEmail.createEmailMessage();
			publishProgress("Mengirim pesanan....");
			androidEmail.sendEmail();
			publishProgress("Email Sent.");





			Log.i("KirimTask", "Mail Sent." );






		} catch (Exception e) {
			publishProgress(e.getMessage());
			Log.e("KirimTask", e.getMessage(), e);
		}
		return null;
	}

	@Override
	public void onProgressUpdate(Object... values) {
		statusDialog.setMessage(values[0].toString());

	}

	@Override
	public void onPostExecute(Object result) {



		if (result.equals(true)){

			statusDialog.setMessage("Berhasil");
		} else if(result.equals(false)) {
			statusDialog.setMessage("Gagal");

		}


	}

}
